package com.example.ratha.rathanarestuarant.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.ratha.rathanarestuarant.entity.Category;
import com.example.ratha.rathanarestuarant.entity.Product;
import com.example.ratha.rathanarestuarant.repository.CategoryDao;
import com.example.ratha.rathanarestuarant.repository.ProductDao;
import com.example.ratha.rathanarestuarant.utill.DatabaseInfo;

/**
 * Created by ratha on 11/23/2017.
 */

@Database(entities = {Product.class, Category.class},version = DatabaseInfo.NEXT_DATABASE_VERSION)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    private static Context appContext;


    public abstract ProductDao productDao();
    public abstract CategoryDao categoryDao();

    public static AppDatabase newInstance(Context context){
        appContext=context;
        if(null==INSTANCE){
            INSTANCE= Room.databaseBuilder(context,AppDatabase.class,DatabaseInfo.DATABASE_NAME)
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION)
                    //.fallbackToDestructiveMigration()
                    .build();
        }

        return INSTANCE;
    }
    public static void destroy(){
        if(null!=INSTANCE) INSTANCE=null;
    }

    public static final Migration MIGRATION=new Migration(
            DatabaseInfo.CURRENT_DATABASE_VERSION,DatabaseInfo.NEXT_DATABASE_VERSION
    ) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            Toast.makeText(appContext, DatabaseInfo.DATABASE_NAME +" updated, new version "+
                    DatabaseInfo.NEXT_DATABASE_VERSION, Toast.LENGTH_SHORT).show();
        }
    };
}

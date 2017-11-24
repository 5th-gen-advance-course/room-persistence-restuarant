package com.example.ratha.rathanarestuarant.repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ratha.rathanarestuarant.entity.Category;

import java.util.List;

/**
 * Created by ratha on 11/23/2017.
 */

@Dao
public interface CategoryDao {

    @Query("SELECT * FROM category")
    List<Category> getCategories();
    @Update
    void editCategory(Category category);
    @Delete
    void removeCategory(Category category);
    @Insert
    void addCategory(Category category);
}

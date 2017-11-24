package com.example.ratha.rathanarestuarant.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.ratha.rathanarestuarant.R;
import com.example.ratha.rathanarestuarant.database.AppDatabase;
import com.example.ratha.rathanarestuarant.entity.Category;
import com.example.ratha.rathanarestuarant.ui.adapter.CategoryAdapter;
import com.example.ratha.rathanarestuarant.ui.dialog.CreateCategoryDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
implements CreateCategoryDialog.CallBack{

    @BindView(R.id.categoryRecyclerView)
    RecyclerView categoryRecyclerView;
    List<Category> list;
    private CategoryAdapter adapter;
    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //init all object
        objectInject();
        categoryRecyclerView.setLayoutManager(new GridLayoutManager(this,2,
                GridLayoutManager.VERTICAL,false));
        categoryRecyclerView.setAdapter(adapter);

        //setup data
        setData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.createCategory:{
                CreateCategoryDialog dialog=new CreateCategoryDialog();
                dialog.show(getFragmentManager(),"create_category_dialog");
            }
        }
        return false;
    }

    private void setData() {
        list.clear();
        list.addAll(db.categoryDao().getCategories());
        adapter.notifyDataSetChanged();
    }

    private void objectInject() {
        list=new ArrayList<>();
        adapter=new CategoryAdapter(this ,list);
        db=AppDatabase.newInstance(getApplicationContext());
    }

    @Override
    public void onSaveListener(Category category) {
        db.categoryDao().addCategory(category);
        setData();
        Log.e("category-> ",category.toString());
    }

    @Override
    public void onCategoryItemClicked(Category category) {
        Intent intent=new Intent(this,FoodActivity.class);
        Bundle bundle=new Bundle();
        bundle.putParcelable("CATEGORY",category);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

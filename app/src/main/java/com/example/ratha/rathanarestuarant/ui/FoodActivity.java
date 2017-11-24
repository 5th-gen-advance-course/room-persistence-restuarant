package com.example.ratha.rathanarestuarant.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ratha.rathanarestuarant.R;
import com.example.ratha.rathanarestuarant.database.AppDatabase;
import com.example.ratha.rathanarestuarant.entity.Category;
import com.example.ratha.rathanarestuarant.entity.Product;
import com.example.ratha.rathanarestuarant.ui.adapter.FoodAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodActivity extends AppCompatActivity {

    @BindView(R.id.foodRecyclerView)
    RecyclerView foodRecyclerView;
    List<Product> list;
    FoodAdapter foodAdapter;
    AppDatabase db;
    Category category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        ButterKnife.bind(this);
        
        initObjects();

        Intent intent=getIntent();
        if(null !=intent){
            Bundle bundle=intent.getExtras();
            if(null !=bundle){
                category = bundle.getParcelable("CATEGORY");
                foodAdapter.setCategory(category);
            }
        }

        foodRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        foodRecyclerView.setAdapter(foodAdapter);
        setData();
    }


    private void initObjects() {
        list= new ArrayList();
        foodAdapter=new FoodAdapter(this,list);
        db=AppDatabase.newInstance(getApplicationContext());
        //addProducts();
    }

    public void setData(){
        list.clear();
        list.addAll(db.productDao().getProducts(category.getId()));
        Log.e("footList Size-> ",list.size()+"");
        foodAdapter.notifyDataSetChanged();
    }

    private void addProducts(){
        for(int i=0;i<50;i++){
            list.add(new Product(4.5f,"Pat Thai",1));
        }
        db.productDao().addProduct(list);
    }
}

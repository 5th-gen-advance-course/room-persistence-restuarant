package com.example.ratha.rathanarestuarant.repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.util.Log;

import com.example.ratha.rathanarestuarant.entity.Product;

import java.util.List;

/**
 * Created by ratha on 11/23/2017.
 */

@Dao
public interface ProductDao {
    @Query("SELECT * FROM product WHERE id= :productId")
    List<Product> getProducts(int productId);

    @Insert
    void addProduct(Product product);
    @Update
    void editProduct(Product product);
    @Delete
    void removeProduct(Product product);
}

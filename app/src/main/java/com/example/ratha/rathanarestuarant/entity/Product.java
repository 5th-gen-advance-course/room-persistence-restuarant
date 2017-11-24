package com.example.ratha.rathanarestuarant.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ratha on 11/23/2017.
 */

@Entity(tableName = "product",
        foreignKeys = @ForeignKey(  entity = Category.class,
                                    parentColumns = "id",
                                    childColumns = "category_id"))

public class Product {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private float price;
    private String name;
    private String desc;
    @ColumnInfo(name="category_id")
    private int categoryId;

    public int getId() {
        return id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

package com.example.ratha.rathanarestuarant.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ratha on 11/23/2017.
 */

@Entity(tableName = "category")
public class Category implements Parcelable{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String desc;
    private String type;

    @Ignore
    public Category(int id, String name,String type) {
        this.id = id;
        this.name = name;
        this.type=type;
    }
    public Category(String name,String type) {
        this.name = name;
        this.type=type;
    }

    protected Category(Parcel in) {
        id = in.readInt();
        name = in.readString();
        desc = in.readString();
        type = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeString(type);
    }
}

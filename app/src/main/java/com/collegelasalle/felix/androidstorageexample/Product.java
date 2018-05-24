package com.collegelasalle.felix.androidstorageexample;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Product {
    @PrimaryKey
    public int uid;
    public String productName;
    public int count;

    public Product(int uid, String productName, int count) {
        this.uid = uid;
        this.productName = productName;
        this.count = count;
    }
}

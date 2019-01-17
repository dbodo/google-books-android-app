package com.example.domagojbodo.books_android_app.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class ItemsResponse {
    ArrayList<BookItems> items;
    public void setItems(ArrayList<BookItems> items){
        this.items = items;
    }
    public ArrayList<BookItems> getItems(){return items;}
    @NonNull
    @Override
    public String toString(){
        return super.toString();
    }
}

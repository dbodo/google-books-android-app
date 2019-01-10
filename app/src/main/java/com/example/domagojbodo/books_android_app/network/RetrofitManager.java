package com.example.domagojbodo.books_android_app.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager instance;
    private GoogleBooksAPI service;

    private RetrofitManager(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(GoogleBooksAPI.class);
    }

    public static RetrofitManager getInstance(){
        if(instance==null){
            instance = new RetrofitManager();
        }
        return instance;
    }
    public GoogleBooksAPI getService(){
        return service;
    };
}

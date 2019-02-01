package com.example.domagojbodo.books_android_app.network;

import com.example.domagojbodo.books_android_app.fragments.HomeFragment;
import com.example.domagojbodo.books_android_app.model.ItemsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GoogleBooksAPI {
    @GET("books/v1/volumes/?")
    Call<ItemsResponse> getItems(@Query("q") String text);


}
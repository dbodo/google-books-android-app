package com.example.domagojbodo.books_android_app.network;

import com.example.domagojbodo.books_android_app.model.ItemsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GoogleBooksAPI {
    @GET("books/v1/volumes/?q=harry%20potter")
    Call<ItemsResponse> getItems();
}
package com.example.domagojbodo.books_android_app.network;

import com.example.domagojbodo.books_android_app.model.VolumeInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GoogleBooksAPI {
    @GET("books/v1/volumes/beSP5CCpiGUC")
    Call<VolumeInfo> getTitle();
}
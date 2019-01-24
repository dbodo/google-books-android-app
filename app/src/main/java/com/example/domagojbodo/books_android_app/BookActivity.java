package com.example.domagojbodo.books_android_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BookActivity extends AppCompatActivity {
    public static String EXTRA_BOOK_INFO = "book_info";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_book);
        getIntent().getParcelableExtra(EXTRA_BOOK_INFO)
    }
}

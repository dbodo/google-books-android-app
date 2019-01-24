package com.example.domagojbodo.books_android_app.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.domagojbodo.books_android_app.R;
import com.example.domagojbodo.books_android_app.listeners.BookshelfListener;

public class BookshelfFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    public static BookshelfFragment newInstance() {
        Bundle args = new Bundle();
        BookshelfFragment fragment = new BookshelfFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public BookshelfListener bookshelfListener;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookshelf, container, false);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bookshelfListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

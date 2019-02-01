package com.example.domagojbodo.books_android_app.fragments;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.domagojbodo.books_android_app.MainActivity;
import com.example.domagojbodo.books_android_app.R;
import com.example.domagojbodo.books_android_app.adapter.BookshelfAdapter;

import com.example.domagojbodo.books_android_app.database.Book;
import com.example.domagojbodo.books_android_app.database.DatabaseClient;
import com.example.domagojbodo.books_android_app.decoration.GridSpacingItemDecoration;


import java.util.ArrayList;
import java.util.List;

public class BookshelfFragment extends Fragment implements AdapterView.OnItemSelectedListener{
        private RecyclerView recyclerView;
        private List<Book> bookList;
        private BookshelfAdapter mAdapter;

    public BookshelfFragment() {
        // Required empty public constructor
    }

    public static BookshelfFragment newInstance() {
        Bundle args = new Bundle();
        BookshelfFragment fragment = new BookshelfFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBooks();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookshelf, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);

        bookList = new ArrayList<>();
        mAdapter = new BookshelfAdapter(getActivity(), bookList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        return view;
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private void getBooks() {
        class GetBooks extends AsyncTask<Void, Void, List<Book>> {
            @Override
            protected List<Book> doInBackground(Void... voids) {
                List<Book> bookLists = DatabaseClient
                        .getInstance(getActivity().getApplicationContext())
                        .getAppDatabase()
                        .bookDao()
                        .getAll();
                return bookLists;
            }
            @Override
            protected void onPostExecute(List<Book> books) {
                super.onPostExecute(books);
                BookshelfAdapter adapter = new BookshelfAdapter(getContext(), books);
                recyclerView.setAdapter(adapter);
            }
        }
        GetBooks gt = new GetBooks();
        gt.execute();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

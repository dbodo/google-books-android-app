package com.example.domagojbodo.books_android_app.fragments;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.domagojbodo.books_android_app.R;
import com.example.domagojbodo.books_android_app.adapter.HomeAdapter;
import com.example.domagojbodo.books_android_app.decoration.GridSpacingItemDecoration;
import com.example.domagojbodo.books_android_app.model.BookItems;
import com.example.domagojbodo.books_android_app.model.ItemsResponse;
import com.example.domagojbodo.books_android_app.model.VolumeInfo;
import com.example.domagojbodo.books_android_app.network.RetrofitManager;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class HomeFragment extends Fragment implements Callback<ItemsResponse>{

    private RecyclerView recyclerView;
    private List<BookItems> bookList;
    private HomeAdapter mAdapter;
    private EditText editText;
    private Button button;
    private String text;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        editText = (EditText) view.findViewById(R.id.search);
        button = (Button) view.findViewById(R.id.btnSearch);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = editText.getText().toString();
                Call<ItemsResponse> callResponse = RetrofitManager.getInstance().getService().getItems(text);
                callResponse.enqueue(HomeFragment.this);
            }
        });
        bookList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycler_view);
        mAdapter = new HomeAdapter(getActivity(), bookList);
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

    @Override
    public void onResponse(@NonNull Call<ItemsResponse> call, @NonNull Response<ItemsResponse> response) {
        ItemsResponse itemsResponse = response.body();
        if(response.isSuccessful() && itemsResponse != null){
            if(itemsResponse.getItems() != null){
                List<BookItems> items = itemsResponse.getItems();
                bookList.clear();
                bookList.addAll(items);
                mAdapter.notifyDataSetChanged();
            }
            else{
                Toast.makeText(getActivity(), "Couldn't fetch the book items! Pleas try again.", Toast.LENGTH_LONG).show();
                return;
            }
        }else{
            Toast.makeText(getActivity(), "Couldn't fetch the book items! Pleas try again.", Toast.LENGTH_LONG).show();
            return;
        }
    }

    @Override
    public void onFailure(@NonNull Call<ItemsResponse> call, @NonNull Throwable t) {
        Toast.makeText(getActivity(), "Error: ", Toast.LENGTH_SHORT).show();
    }
}

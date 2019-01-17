package com.example.domagojbodo.books_android_app.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.domagojbodo.books_android_app.R;
import com.example.domagojbodo.books_android_app.listeners.HomeListener;
import com.example.domagojbodo.books_android_app.model.ItemsResponse;
import com.example.domagojbodo.books_android_app.model.VolumeInfo;
import com.example.domagojbodo.books_android_app.network.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements Callback<ItemsResponse>, AdapterView.OnItemSelectedListener{
    public static HomeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public HomeListener homeListener;
    TextView tvRezultat;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tvRezultat = view.findViewById(R.id.home);
        Call<ItemsResponse> callResponse = RetrofitManager.getInstance().getService().getItems();
        callResponse.enqueue(HomeFragment.this);
        return view;
    }

    @Override
    public void onResponse(@NonNull Call<ItemsResponse> call, @NonNull Response<ItemsResponse> response) {
        String text;
        if(response.isSuccessful() && response.body() != null){
            text = response.body().getItems().toString();
        }else{
            text = "Došlo je do pogreške, podaci nisu dostupni";
        }
        setText(text);
    }

    @Override
    public void onFailure(@NonNull Call<ItemsResponse> call, @NonNull Throwable t) {
        setText("Došlo je do pogreške: " + t.getMessage());
    }

    void setText(String text){
        tvRezultat.setText(text);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homeListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

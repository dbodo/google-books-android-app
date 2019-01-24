package com.example.domagojbodo.books_android_app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.domagojbodo.books_android_app.R;
import com.example.domagojbodo.books_android_app.model.BookItems;
import com.example.domagojbodo.books_android_app.model.VolumeInfo;

import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private Context context;
    private List<BookItems> bookItems;

    public HomeAdapter(Context context, List<BookItems> bookItems) {
        this.context = context;
        this.bookItems = bookItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_item_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return bookItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, author;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            author = view.findViewById(R.id.author);
            thumbnail = view.findViewById(R.id.thumbnail);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final BookItems book = bookItems.get(position);
        holder.title.setText(String.valueOf(book.getVolumeInfo().getTitle()));
        holder.author.setText(String.valueOf(book.getVolumeInfo().getAuthors()));

        Glide.with(context)
                .load(book.getVolumeInfo().getImageLinks().getSmallThumbnail())
                .into(holder.thumbnail);

    }
}

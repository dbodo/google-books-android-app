package com.example.domagojbodo.books_android_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.domagojbodo.books_android_app.BookActivity;
import com.example.domagojbodo.books_android_app.R;
import com.example.domagojbodo.books_android_app.listeners.HomeListener;
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

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, author;
        public ImageView thumbnail;
        CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            author = view.findViewById(R.id.author);
            thumbnail = view.findViewById(R.id.thumbnail);
            cardView = view.findViewById(R.id.card_view);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            if (position< bookItems.size()){
                BookItems clickedItem = bookItems.get(position);

                Intent intent = new Intent(context, BookActivity.class);
                intent.putExtra(BookActivity.EXTRA_BOOK_INFO,clickedItem);
                context.startActivity(intent);
            }

        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final BookItems book = bookItems.get(position);
        StringBuilder builder = new StringBuilder();
        for(String value : book.getVolumeInfo().getAuthors()){
            builder.append(value + " ");
        }
        holder.title.setText(String.valueOf(book.getVolumeInfo().getTitle()));
        holder.author.setText(String.valueOf(builder));

        Glide.with(context)
                .load(book.getVolumeInfo().getImageLinks().getSmallThumbnail())
                .into(holder.thumbnail);
    }
}

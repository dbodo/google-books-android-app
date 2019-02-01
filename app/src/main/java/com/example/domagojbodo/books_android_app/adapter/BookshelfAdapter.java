package com.example.domagojbodo.books_android_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.domagojbodo.books_android_app.BookActivity;
import com.example.domagojbodo.books_android_app.R;
import com.example.domagojbodo.books_android_app.database.Book;

import java.util.List;

public class BookshelfAdapter extends RecyclerView.Adapter<BookshelfAdapter.MyViewHolder> {
    private Context context;
    private List<Book> bookList;

    public BookshelfAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bookshelf_item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
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

            if (position < bookList.size()) {
                Book clickedItem = bookList.get(position);

                Intent intent = new Intent(context, BookActivity.class);
                intent.putExtra(BookActivity.GLOBAL_VAR_VALUE, true);
                intent.putExtra(BookActivity.EXTRA_BOOK_INFO, clickedItem);
                context.startActivity(intent);
            }
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Book book = bookList.get(position);
        holder.title.setText(String.valueOf(book.getTitle()));
        holder.author.setText(book.getAuthors().substring(1,book.getAuthors().length()-1));
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.no_cover);
        requestOptions.fallback(R.drawable.no_cover);
        requestOptions.error(R.drawable.no_cover);
        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(book.getImageLinks())
                .into(holder.thumbnail);
    }
}

package com.example.domagojbodo.books_android_app;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.domagojbodo.books_android_app.database.Book;
import com.example.domagojbodo.books_android_app.database.DatabaseClient;
import com.example.domagojbodo.books_android_app.model.BookItems;

public class BookActivity extends AppCompatActivity {

    public static final String GLOBAL_VAR_VALUE = "value";
    public static final String EXTRA_BOOK_INFO = "Book";
    public static final String EXTRA_BOOK_INFO_API = "BookItems";
    TextView title;
    TextView subtitle;
    TextView authors;
    TextView publisher;
    TextView publisheDate;
    TextView pageCount;
    TextView description;
    ImageView image;
    private ActionBar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_book);
        if(getIntent().getBooleanExtra(GLOBAL_VAR_VALUE, true) == true){
            FloatingActionButton floatingActionButton = (FloatingActionButton) this.findViewById(R.id.button);
            floatingActionButton.setImageResource(android.R.drawable.ic_delete);
            final Book book = getIntent().getParcelableExtra(EXTRA_BOOK_INFO);
            toolbar = getSupportActionBar();
            toolbar.setTitle(book.getTitle());

            title = (TextView) findViewById(R.id.title);
            subtitle = (TextView) findViewById(R.id.subtitle);
            authors = (TextView) findViewById(R.id.authors);
            publisher = (TextView) findViewById(R.id.publisher);
            publisheDate = (TextView) findViewById(R.id.published_date);
            pageCount = (TextView) findViewById(R.id.page_count);
            description = (TextView) findViewById(R.id.description);
            image = (ImageView) findViewById(R.id.image);

            loadBook(book);

            findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteBook(book);
                }
            });
        }
        else if(getIntent().getBooleanExtra(GLOBAL_VAR_VALUE, false) == false){
            FloatingActionButton floatingActionButton = (FloatingActionButton) this.findViewById(R.id.button);
            floatingActionButton.setImageResource(android.R.drawable.ic_input_add);
            final BookItems book = getIntent().getParcelableExtra(EXTRA_BOOK_INFO_API);
            toolbar = getSupportActionBar();
            toolbar.setTitle(book.getVolumeInfo().getTitle());
            title = (TextView) findViewById(R.id.title);
            subtitle = (TextView) findViewById(R.id.subtitle);
            authors = (TextView) findViewById(R.id.authors);
            publisher = (TextView) findViewById(R.id.publisher);
            publisheDate = (TextView) findViewById(R.id.published_date);
            pageCount = (TextView) findViewById(R.id.page_count);
            description = (TextView) findViewById(R.id.description);
            image = (ImageView) findViewById(R.id.image);

            loadBookItems(book);

            findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveBook(book);
                }
            });
        }
    }

    private void loadBook(Book book) {
        title.setText(book.getTitle());
        subtitle.setText(book.getSubtitle());
        if(book.getAuthors() == null) {
            authors.setText("not found");
        }
        else{
            authors.setText(book.getAuthors().substring(1,book.getAuthors().length()-1));
        }
        if(book.getPublisher()==null){
            publisher.setText("not found");
        }
        else {
            publisher.setText(book.getPublisher());
        }
        if(book.getPublishedDate()==null){
            publisheDate.setText("not found");
        }
        else{
            publisheDate.setText(book.getPublishedDate());
        }
        if(book.getPageCount() == 0) {
            pageCount.setText("not found");
        }
        else{
            pageCount.setText(book.getPageCount().toString());
        }
        if(book.getDescription()==null) {
            description.setText("Summary not found");
        }
        else{
            description.setText(book.getDescription());
        }
        Glide.with(getApplicationContext())
                .load(book.getImageLinks())
                .into(image);
    }

    private void loadBookItems(BookItems book) {
        title.setText(book.getVolumeInfo().getTitle());
        subtitle.setText(book.getVolumeInfo().getSubtitle());
        if(book.getVolumeInfo().getAuthors() == null) {
            authors.setText("not found");
        }
        else {
            authors.setText(book.getVolumeInfo().getAuthors().toString().substring(1, book.getVolumeInfo().getAuthors().toString().length() - 1));
        }
        if(book.getVolumeInfo().getPublisher()==null){
            publisher.setText("not found");
        }
        else {
            publisher.setText(book.getVolumeInfo().getPublisher());
        }
        if(book.getVolumeInfo().getPublishedDate()==null){
            publisheDate.setText("not found");
        }
        else {
            publisheDate.setText(book.getVolumeInfo().getPublishedDate());
        }
        if(book.getVolumeInfo().getPageCount() == null) {
            pageCount.setText("not found");
        }
        else{
            pageCount.setText(book.getVolumeInfo().getPageCount().toString());
        }
        if(book.getVolumeInfo().getDescription()==null) {
            description.setText("Summary not found");
        }
        else {
            description.setText(book.getVolumeInfo().getDescription());
        }
        if(book.getVolumeInfo().getImageLinks()==null)
        {
            Glide.with(getApplicationContext())
                    .load(R.drawable.no_cover)
                    .into(image);
        }
        else {
            Glide.with(getApplicationContext())
                    .load(book.getVolumeInfo().getImageLinks().getSmallThumbnail())
                    .into(image);
        }
    }

    private void saveBook(BookItems book) {
        final String sTitle = book.getVolumeInfo().getTitle();
        final String sSubtitle;
        if(book.getVolumeInfo().getSubtitle()==null){
            sSubtitle = "not found";
        }
        else{
            sSubtitle = book.getVolumeInfo().getSubtitle();
        }
        final String sAuthors;
        if(book.getVolumeInfo().getAuthors()==null){
            sAuthors = "not found";
        }
        else{
            sAuthors = book.getVolumeInfo().getAuthors().toString();
        }
        final String sPublisher;
        if(book.getVolumeInfo().getPublisher()==null){
            sPublisher = "not found";
        }
        else{
            sPublisher = book.getVolumeInfo().getPublisher();
        }
        final String sPublishedDate;
        if(book.getVolumeInfo().getPublishedDate() == null){
            sPublishedDate = "";
        }
        else{
            sPublishedDate = book.getVolumeInfo().getPublishedDate();
        }
        final Integer nPageCount;
        if(book.getVolumeInfo().getPageCount()==null){
            nPageCount = 0;
        }
        else{
            nPageCount = book.getVolumeInfo().getPageCount();
        }
        final String sDescription;
        if(book.getVolumeInfo().getDescription()==null){
            sDescription = "not found";
        }
        else {
            sDescription = book.getVolumeInfo().getDescription();
        }
        final String sImageLinks;
        if(book.getVolumeInfo().getImageLinks()==null){
            sImageLinks = "https://vignette.wikia.nocookie.net/rokuaka/images/9/90/No_Cover_Available.jpg/revision/latest/scale-to-width-down/300?cb=20180508044720";
        }
        else{
            sImageLinks = book.getVolumeInfo().getImageLinks().getSmallThumbnail();
        }
        class SaveTask extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                Book book = new Book();
                book.setTitle(sTitle);
                book.setSubtitle(sSubtitle);
                book.setAuthors(sAuthors);
                book.setPublisher(sPublisher);
                book.setPublishedDate(sPublishedDate);
                book.setPageCount(nPageCount);
                book.setDescription(sDescription);
                book.setImageLinks(sImageLinks);
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .bookDao()
                        .insert(book);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(getApplicationContext(), "Added to bookshelf", Toast.LENGTH_LONG).show();
            }
        }
        SaveTask st = new SaveTask();
        st.execute();
    }

    private void deleteBook(final Book book) {
        class DeleteTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .bookDao()
                        .delete(book);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "Book deleted", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(BookActivity.this, MainActivity.class));
            }
        }
        DeleteTask dt = new DeleteTask();
        dt.execute();
    }
}

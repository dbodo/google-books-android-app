package com.example.domagojbodo.books_android_app.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface BookDao {
    @Query("SELECT * FROM Book")
    List<Book> getAll();

    @Insert
    void insert(Book book);

    @Delete
    void delete(Book book);
}

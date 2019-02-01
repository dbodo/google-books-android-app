package com.example.domagojbodo.books_android_app.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Book.class}, version = 1 )
public abstract class AppDatabase extends RoomDatabase {
    public abstract BookDao bookDao();
}

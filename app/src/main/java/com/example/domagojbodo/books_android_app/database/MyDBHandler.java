package com.example.domagojbodo.books_android_app.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class MyDBHandler extends SQLiteOpenHelper {
    //informacije o bazi
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bookDB.db";
    public static final String TABLE_NAME = "Books";
    //inicijaliziraj bazu
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

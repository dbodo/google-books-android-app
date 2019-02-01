package com.example.domagojbodo.books_android_app.database;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseClient {

    private static final String DATABASE_NAME = "Books";
    private static DatabaseClient mInstance;

    //our app database object
    private AppDatabase appDatabase;

    private DatabaseClient(Context context) {
        //creating the app database with Room database builder
        //Books is the name of the database
        appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
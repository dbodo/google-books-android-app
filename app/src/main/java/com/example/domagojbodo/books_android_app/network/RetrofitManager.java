package com.example.domagojbodo.books_android_app.network;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager instance;
    private GoogleBooksAPI service;

    private RetrofitManager(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(GoogleBooksAPI.class);
    }

    public static RetrofitManager getInstance(){
        if(instance==null){
            instance = new RetrofitManager();
        }
        return instance;
    }
    public GoogleBooksAPI getService(){
        return service;
    };

    public class NullOnEmptyConverterFactory extends Converter.Factory {
        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
            return new Converter<ResponseBody, Object>() {
                @Override
                public Object convert(ResponseBody body) throws IOException {
                    if (body.contentLength() == 0) return null;
                    return delegate.convert(body);                }
            };
        }
    }
}



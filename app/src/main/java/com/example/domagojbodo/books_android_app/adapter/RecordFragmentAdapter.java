package com.example.domagojbodo.books_android_app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.domagojbodo.books_android_app.fragments.BookshelfFragment;
import com.example.domagojbodo.books_android_app.fragments.HomeFragment;
import com.example.domagojbodo.books_android_app.listeners.HomeListener;
import com.example.domagojbodo.books_android_app.listeners.BookshelfListener;


public class RecordFragmentAdapter extends FragmentPagerAdapter implements HomeListener, BookshelfListener{
    public RecordFragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        Fragment fragment;
        switch(i){
            case 0:
                fragment = HomeFragment.newInstance();
                ((HomeFragment)fragment).homeListener = this;

                break;
            default:
                fragment = BookshelfFragment.newInstance();
                ((BookshelfFragment)fragment).bookshelfListener = this;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 0;
    }
}

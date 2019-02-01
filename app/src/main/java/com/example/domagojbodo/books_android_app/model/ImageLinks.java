package com.example.domagojbodo.books_android_app.model;

import android.os.Parcel;
import android.os.Parcelable;


public class ImageLinks implements Parcelable {
    private String smallThumbnail;
    private String thumbnail;

    public ImageLinks(Parcel in) {
        smallThumbnail = in.readString();
        thumbnail = in.readString();
    }

    public static final Creator<ImageLinks> CREATOR = new Creator<ImageLinks>() {
        @Override
        public ImageLinks createFromParcel(Parcel in) {
            return new ImageLinks(in);
        }

        @Override
        public ImageLinks[] newArray(int size) {
            return new ImageLinks[size];
        }
    };

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(smallThumbnail);
        parcel.writeString(thumbnail);
    }
}
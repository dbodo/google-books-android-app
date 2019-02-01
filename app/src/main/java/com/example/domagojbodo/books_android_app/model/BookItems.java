package com.example.domagojbodo.books_android_app.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class BookItems implements Parcelable {
    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumeInfo volumeInfo;

    public BookItems(Parcel in) {
        kind = in.readString();
        id = in.readString();
        etag = in.readString();
        selfLink = in.readString();
        volumeInfo = in.readParcelable(VolumeInfo.class.getClassLoader());
    }

    public static final Creator<BookItems> CREATOR = new Creator<BookItems>() {
        @Override
        public BookItems createFromParcel(Parcel in) {
            return new BookItems(in);
        }

        @Override
        public BookItems[] newArray(int size) {
            return new BookItems[size];
        }
    };

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    @NonNull
    @Override
    public String toString(){
        return "\n" + getVolumeInfo();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(kind);
        parcel.writeString(id);
        parcel.writeString(etag);
        parcel.writeString(selfLink);
        parcel.writeParcelable(volumeInfo, i);
    }
}
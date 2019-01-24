package com.example.domagojbodo.books_android_app.model;

import android.support.annotation.NonNull;

public class BookItems {
    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumeInfo volumeInfo;

    public BookItems(String kind, String id, String etag, String selfLink, VolumeInfo volumeInfo) {
        this.kind = kind;
        this.id = id;
        this.etag = etag;
        this.selfLink = selfLink;
        this.volumeInfo = volumeInfo;
    }

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
}
package com.example.domagojbodo.books_android_app.model;

import android.support.annotation.NonNull;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;
//Implementirati parcelable interface: https://developer.android.com/reference/android/os/Parcelable
//http://www.vogella.com/tutorials/AndroidParcelable/article.html
public class VolumeInfo implements Parcelable{
    private String title;
    private String subtitle;
    private List<String> authors = null;
    private String publisher;
    private String publishedDate;
    private String description;
    private Integer pageCount;
    private String printType;
    private List<String> categories = null;
    private String contentVersion;
    private ImageLinks imageLinks;
    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;

    public VolumeInfo(Parcel in) {
        title = in.readString();
        subtitle = in.readString();
        authors = in.createStringArrayList();
        publisher = in.readString();
        publishedDate = in.readString();
        description = in.readString();
        if (in.readByte() == 0) {
            pageCount = null;
        } else {
            pageCount = in.readInt();
        }
        printType = in.readString();
        categories = in.createStringArrayList();
        contentVersion = in.readString();
        imageLinks = in.readParcelable(ImageLinks.class.getClassLoader());
        language = in.readString();
        previewLink = in.readString();
        infoLink = in.readString();
        canonicalVolumeLink = in.readString();
    }

    public static final Creator<VolumeInfo> CREATOR = new Creator<VolumeInfo>() {
        @Override
        public VolumeInfo createFromParcel(Parcel in) {
            return new VolumeInfo(in);
        }

        @Override
        public VolumeInfo[] newArray(int size) {
            return new VolumeInfo[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }

    public void setCanonicalVolumeLink(String canonicalVolumeLink) {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(subtitle);
        parcel.writeStringList(authors);
        parcel.writeString(publisher);
        parcel.writeString(publishedDate);
        parcel.writeString(description);
        if (pageCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(pageCount);
        }
        parcel.writeString(printType);
        parcel.writeStringList(categories);
        parcel.writeString(contentVersion);
        parcel.writeParcelable(imageLinks, i);
        parcel.writeString(language);
        parcel.writeString(previewLink);
        parcel.writeString(infoLink);
        parcel.writeString(canonicalVolumeLink);
    }
}
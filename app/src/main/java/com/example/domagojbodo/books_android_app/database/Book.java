package com.example.domagojbodo.books_android_app.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class Book implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "Title")
    public String title;
    @ColumnInfo(name = "Subtitle")
    public String subtitle;
    @ColumnInfo(name = "Authors")
    public String authors;
    @ColumnInfo(name = "Publisher")
    public String publisher;
    @ColumnInfo(name = "Published_date")
    public String publishedDate;
    @ColumnInfo(name = "Description")
    public String description;
    @ColumnInfo(name = "Page_count")
    public Integer pageCount;
    @ColumnInfo(name = "Image_links")
    public String imageLinks;

    public Book(){

    }

    protected Book(Parcel in) {
        id = in.readInt();
        title = in.readString();
        subtitle = in.readString();
        authors = in.readString();
        publisher = in.readString();
        publishedDate = in.readString();
        description = in.readString();
        if (in.readByte() == 0) {
            pageCount = null;
        } else {
            pageCount = in.readInt();
        }
        imageLinks = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public int getId(){
        return id;
    }
    public void setId(int id) { this.id = id; }
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
    public String getAuthors() {
        return authors;
    }
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getPublishedDate() { return publishedDate; }
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getPageCount() {
        return pageCount;
    }
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
    public String getImageLinks() {
        return imageLinks;
    }
    public void setImageLinks(String imageLinks) {
        this.imageLinks = imageLinks;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(subtitle);
        parcel.writeString(authors);
        parcel.writeString(publisher);
        parcel.writeString(publishedDate);
        parcel.writeString(description);
        if (pageCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(pageCount);
        }
        parcel.writeString(imageLinks);
    }
}

package com.bit_makers.saikat.stratupbd;

/**
 * Created by ASUS on 3/21/2016.
 */
public class Article {
    String title;
    String author;
    String commment;
    String date;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCommment(String commment) {
        this.commment = commment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommment() {
        return commment;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }
}

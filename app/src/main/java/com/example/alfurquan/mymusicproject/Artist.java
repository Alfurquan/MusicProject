package com.example.alfurquan.mymusicproject;

public class Artist {

    String name;
    int thumbnail;
    String genre;

    public Artist(String name,String genre, int thumbnail) {
        this.name = name;
        this.genre = genre;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

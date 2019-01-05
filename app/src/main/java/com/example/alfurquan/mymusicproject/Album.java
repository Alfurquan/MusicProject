package com.example.alfurquan.mymusicproject;

public class Album {
    String name;
    String artist;
    int thumbnail;

    public Album(String name, String artist, int thumbnail) {
        this.name = name;
        this.artist = artist;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}

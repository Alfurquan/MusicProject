package com.example.alfurquan.mymusicproject;

public class Feature {
    String name,theme;
    int thumbnail;

    public Feature(String name, String theme, int thumbnail) {
        this.name = name;
        this.theme = theme;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}

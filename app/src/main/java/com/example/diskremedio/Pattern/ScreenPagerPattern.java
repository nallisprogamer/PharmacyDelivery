package com.example.diskremedio.Pattern;

public class ScreenPagerPattern {
    String title,descripion;
    int ScreenImg;

    public ScreenPagerPattern(String title, String descripion, int screenImg) {
        this.title = title;
        this.descripion = descripion;
        ScreenImg = screenImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public int getScreenImg() {
        return ScreenImg;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }
}

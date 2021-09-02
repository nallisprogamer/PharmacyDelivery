package com.example.diskremedio.Pattern;

public class Artigospattern {
    private int img;
    private String text;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    private String subtext;


    public Artigospattern(int img, String text, String subtext) {
        this.img = img;
        this.text = text;
        this.subtext = subtext;
    }
}

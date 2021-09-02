package com.example.diskremedio.Pattern;

public class CategoriaMain {
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

    public CategoriaMain(int img, String text) {
        this.img = img;
        this.text = text;
    }
}

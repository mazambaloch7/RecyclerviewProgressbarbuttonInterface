package com.example.recyclerviewprogressbar_button_interface;

public class Model {
    int imageView;
    String text;
    String progress;

    public Model(int imageView, String text, String progress) {
        this.imageView = imageView;
        this.text = text;
        this.progress = progress;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}

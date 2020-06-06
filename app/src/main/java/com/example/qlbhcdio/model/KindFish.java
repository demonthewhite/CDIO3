package com.example.qlbhcdio.model;


public class KindFish {
    private int Index;
    private int image;

    public KindFish(int index, int image) {
        Index = index;
        this.image = image;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getIndex() {
        return Index;
    }

    public int getImage() {
        return image;
    }
}

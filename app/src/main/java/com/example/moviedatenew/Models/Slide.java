package com.example.moviedatenew.Models;

public class Slide {

    private int Image;
    private String Title;

    //add more field depend on what you want
   //generate constructor

    public Slide(int image, String title) {
        Image = image;
        Title = title;
    }

    //generate getter

    public int getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }

    //generate setter

    public void setImage(int image) {
        Image = image;
    }

    public void setTitle(String title) {
        Title = title;
    }
}

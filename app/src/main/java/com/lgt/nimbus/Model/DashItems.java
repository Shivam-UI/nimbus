package com.lgt.nimbus.Model;

public class DashItems {
    String Title,  imageID;
    int Color;

    public DashItems(int color,String Title) {
        this.Color = color;
        this.Title = Title;
    }

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        Color = color;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }
}

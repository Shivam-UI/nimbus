package com.lgt.nimbus.Model;

public class MenuItem {
    String Title;
    int imageID;

    public MenuItem(String title, int imageID) {
        Title = title;
        this.imageID = imageID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}

package com.lgt.nimbus.menu;

/**
 * Created by anupamchugh on 22/12/17.
 */

public class MenuModel {

    public String menuName, url;

    public boolean hasChildren, isGroup;
    Integer[] imageId;
    public MenuModel(String menuName, boolean isGroup, boolean hasChildren) {

        this.menuName = menuName;
        this.url = url;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
       // this.imageId=imageId;
    }
}

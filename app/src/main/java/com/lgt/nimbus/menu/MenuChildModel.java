package com.lgt.nimbus.menu;

import android.widget.ImageView;

/**
 * Created by anupamchugh on 22/12/17.
 */

public class MenuChildModel {

    public String menuName, url;
    public ImageView menuImage;
    public boolean hasChildren, isGroup;

    public MenuChildModel(String menuName, boolean isGroup, boolean hasChildren) {

        this.menuName = menuName;
        this.url = url;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;

    }
}

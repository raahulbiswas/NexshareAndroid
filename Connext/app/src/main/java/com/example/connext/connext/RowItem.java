package com.example.connext.connext;

import android.graphics.Bitmap;

/**
 * Created by raahulbiswas on 15-03-24.
 */
public class RowItem {

    private String title;
    private String icon;

    public RowItem(String title, String icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
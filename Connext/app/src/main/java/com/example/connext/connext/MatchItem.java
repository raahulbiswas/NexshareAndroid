package com.example.connext.connext;

/**
 * Created by raahulbiswas on 15-04-06.
 */
public class MatchItem {
    private String title;
    private String icon;
    private double match;

    public MatchItem(String title, String icon, double match) {
        this.title = title;
        this.icon = icon;
        this.match = match;

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

    public double getMatch() {return match;}

    public void setMatch(double match) {this.match = match;}
}

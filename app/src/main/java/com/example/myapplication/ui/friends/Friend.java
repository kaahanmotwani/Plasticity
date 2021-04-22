package com.example.myapplication.ui.friends;

public class Friend {
    private int level;
    private String name;
    private boolean followed;
    public Friend(String name, int level, boolean followed){
        this.name = name;
        this.level = level;
        this.followed = followed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }
}

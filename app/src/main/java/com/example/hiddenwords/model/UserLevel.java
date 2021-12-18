package com.example.hiddenwords.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserLevel {
    private String uid;
    private int level;

    public UserLevel() {
    }

    public UserLevel(String uid, int level) {
        this.uid = uid;
        this.level = level;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

package me.alexjordache.geopix.model;

import java.util.ArrayList;

/**
 * Created by Alex on 4/30/2016.
 */
public class User {

    // User Fields

    private String userName;
    private String password;
    private ArrayList<String> stickers;


    // Constructor

    public User(String userName, String password, ArrayList<String> stickers ) {
        userName = this.userName;
        password = this.password;
        stickers = this.stickers;
    }

    // Getters & Setters


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getStickers() {
        return stickers;
    }

    public void setStickers(ArrayList<String> stickers) {
        this.stickers = stickers;
    }

//    public static void doLogin()

}

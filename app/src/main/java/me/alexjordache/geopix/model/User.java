package me.alexjordache.geopix.model;

import java.util.ArrayList;

public class User {

    // User Fields

    // What we find
    private int foundStickerScore;
    // How our one sticker is doing
    private int usersStickerScore;
    // Sum of all the users scores
    private int overallScore;

    private String userName;
    private String password;
    private String avatarURL;
    private ArrayList<String> stickers;

    // Constructor

    public User(String userName, String password, String avatarURL, ArrayList<String> stickers, int foundStickerScore, int usersStickerScore) {
        userName = this.userName;
        password = this.password;
        stickers = this.stickers;
        avatarURL = avatarURL;
        foundStickerScore = this.foundStickerScore;
        usersStickerScore = this.usersStickerScore;
        overallScore = foundStickerScore + usersStickerScore;

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

    public int getFoundStickerScore() {
        return foundStickerScore;
    }

    public void setFoundStickerScore(int foundStickerScore) {
        this.foundStickerScore = foundStickerScore;
    }

    public int getUsersStickerScore() {
        return usersStickerScore;
    }

    public void setUsersStickerScore(int usersStickerScore) {
        this.usersStickerScore = usersStickerScore;
    }

    public int getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }

    public ArrayList<String> getStickers() {
        return stickers;
    }

    public void setStickers(ArrayList<String> stickers) {
        this.stickers = stickers;
    }

    

}

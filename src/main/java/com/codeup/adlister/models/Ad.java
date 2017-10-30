package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private String address;
    private String state;
    private String zip_code;

    public Ad(long id, long userId, String title, String description, String address, String state, String zip_code) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.address =address;
        this.state = state;
        this.zip_code = zip_code;
    }

    public Ad(long userId, String title, String description, String address, String state, String zip_code) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.address =address;
        this.state = state;
        this.zip_code = zip_code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  String getAddress(){return address;}

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }
}

package com.codeup.adlister.models;

public class User {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String phone;
    private String streetAddress;
    private String state;
    private String zipcode;
    private String email;
    private String password;

    public User() {}

    public User(String username, String email, String firstName, String lastName, String streetAddress, String state, String zipcode, String phone, String password) {
        this.username = username;
        this.email = email;
        this.firstName =firstName;
        this.lastName =lastName;
        this.streetAddress = streetAddress;
        this.state= state;
        this.zipcode=zipcode;
        this.phone=phone;
        this.password = password;

    }

    public User(long id, String username, String email, String firstName, String lastName, String streetAddress, String state, String zipcode, String phone, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName =firstName;
        this.lastName =lastName;
        this.streetAddress = streetAddress;
        this.state= state;
        this.zipcode=zipcode;
        this.phone=phone;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

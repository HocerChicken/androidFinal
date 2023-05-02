package com.example.finalproject;

public class User {
    private String id;
    private String email;
    private String userFullName;
    private String phoneNumber;
    private String address;
    private String password;

    public User(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String id, String email,  String password, String userFullName, String phoneNumber,  String address) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userFullName = userFullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters và setters cho các thuộc tính

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.example.sql;

public class User {

    private String Name;
    private String email;
    private String phone;


    public User(String EName, String Eemail, String Ephone) {
        Name = EName;
        email = Eemail;
        phone = Ephone;

    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }


}
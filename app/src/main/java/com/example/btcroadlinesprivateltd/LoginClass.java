package com.example.btcroadlinesprivateltd;

public class LoginClass {
    String username,password,_id;
    Boolean status;

    public LoginClass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginClass{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", _id='" + _id + '\'' +
                ", status=" + status +
                '}';
    }
}

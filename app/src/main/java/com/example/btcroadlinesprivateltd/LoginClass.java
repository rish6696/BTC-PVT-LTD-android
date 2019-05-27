package com.example.btcroadlinesprivateltd;

public class LoginClass {
    String username,password,status;

    public LoginClass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginClass{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

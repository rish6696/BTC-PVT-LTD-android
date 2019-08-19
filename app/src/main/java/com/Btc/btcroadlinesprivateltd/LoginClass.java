package com.Btc.btcroadlinesprivateltd;

public class LoginClass {
    String username,password,_id;
    Boolean status;

    public LoginClass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginClass(String username) {
        this.username = username;
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

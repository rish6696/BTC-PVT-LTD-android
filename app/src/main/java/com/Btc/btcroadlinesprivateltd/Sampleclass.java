package com.Btc.btcroadlinesprivateltd;

public class Sampleclass {

    String _id,name,phone;

    public Sampleclass(String _id, String name, String phone) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
    }

    public Sampleclass(String name) {
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Sampleclass{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

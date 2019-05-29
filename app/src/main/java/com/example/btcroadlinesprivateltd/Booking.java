package com.example.btcroadlinesprivateltd;

public class Booking {
    String port,date, time;
    Truck truck;
    Party party;



    public Booking(String port, Truck truck, Party party) {
        this.port = port;
        this.truck = truck;
        this.party = party;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "port='" + port + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", truck=" + truck +
                ", party=" + party +
                '}';
    }
}

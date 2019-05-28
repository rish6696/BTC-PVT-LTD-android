package com.example.btcroadlinesprivateltd;

public class Booking {
    String port;
    truckbd tbd;
    partybd pbd;

    public Booking(String port, truckbd tbd, partybd pbd) {
        this.port = port;
        this.tbd = tbd;
        this.pbd = pbd;
    }
}

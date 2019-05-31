package com.example.btcroadlinesprivateltd;

public class Booking {
    String port,date, time,_id;
    Truck truck;
    Party party;
    TruckSecurity truckSecurity;
    PartySecurity partySecurity;
    boolean status=false;

    public Booking(String port, Truck truck, Party party, TruckSecurity truckSecurity, PartySecurity partySecurity,boolean status) {
        this.port = port;
        this.truck = truck;
        this.party = party;
        this.truckSecurity = truckSecurity;
        this.partySecurity = partySecurity;
        this.status=status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "port='" + port + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", truck=" + truck +
                ", party=" + party +
                ", truckSecurity=" + truckSecurity +
                ", partySecurity=" + partySecurity +
                '}';
    }
}

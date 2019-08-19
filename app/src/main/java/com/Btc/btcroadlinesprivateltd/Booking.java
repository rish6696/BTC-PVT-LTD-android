package com.Btc.btcroadlinesprivateltd;

public class Booking {
    String port,date, time,_id;
    Truck truckAdvance;
    Party partyAdvance;
    TruckSecurity truckSecurity;
    PartySecurity partySecurity;
    boolean status=false;

    public Booking(String port, Truck truck, Party party, TruckSecurity truckSecurity, PartySecurity partySecurity,boolean status) {
        this.port = port;
        this.truckAdvance = truck;
        this.partyAdvance = party;
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
                ", truckAdvance=" + truckAdvance +
                ", partyAdvance=" + partyAdvance +
                ", truckSecurity=" + truckSecurity +
                ", partySecurity=" + partySecurity +
                '}';
    }
}

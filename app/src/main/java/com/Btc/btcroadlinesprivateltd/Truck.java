package com.Btc.btcroadlinesprivateltd;

public class Truck {

    String truckno,lrnum,ownerph,accountno,ifsccode,holdername,challanNo,rcName;
    float weight,rate,cash,diesel,security,dala,comisiion,bilty,total,balance;

    public Truck(String truckno, String lrnum, String ownerph, String accountno, String ifsccode, String holdername, String challanNo, String rcName, float weight, float rate, float cash, float diesel, float security, float dala, float comisiion, float bilty, float total, float balance) {
        this.truckno = truckno;
        this.lrnum = lrnum;
        this.ownerph = ownerph;
        this.accountno = accountno;
        this.ifsccode = ifsccode;
        this.holdername = holdername;
        this.challanNo = challanNo;
        this.rcName = rcName;
        this.weight = weight;
        this.rate = rate;
        this.cash = cash;
        this.diesel = diesel;
        this.security = security;
        this.dala = dala;
        this.comisiion = comisiion;
        this.bilty = bilty;
        this.total = total;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "truckno='" + truckno + '\'' +
                ", lrnum='" + lrnum + '\'' +
                ", ownerph='" + ownerph + '\'' +
                ", accountno='" + accountno + '\'' +
                ", ifsccode='" + ifsccode + '\'' +
                ", holdername='" + holdername + '\'' +
                ", challanNo='" + challanNo + '\'' +
                ", rcName='" + rcName + '\'' +
                ", weight=" + weight +
                ", rate=" + rate +
                ", cash=" + cash +
                ", diesel=" + diesel +
                ", security=" + security +
                ", dala=" + dala +
                ", comisiion=" + comisiion +
                ", bilty=" + bilty +
                ", total=" + total +
                ", balance=" + balance +
                '}';
    }
}

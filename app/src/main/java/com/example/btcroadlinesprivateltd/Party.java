package com.example.btcroadlinesprivateltd;

public class Party {
    String lrnum,partyname,adress,contact;
    float weight,rate,loadingcharge,security,diesel,cash,total,balance;

    public Party(String lrnum, String partyname, String adress, String contact, float weight, float rate, float loadingcharge, float security, float diesel, float cash, float total, float balance) {
        this.lrnum = lrnum;
        this.partyname = partyname;
        this.adress = adress;
        this.contact = contact;
        this.weight = weight;
        this.rate = rate;
        this.loadingcharge = loadingcharge;
        this.security = security;
        this.diesel = diesel;
        this.cash = cash;
        this.total = total;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Party{" +
                "lrnum='" + lrnum + '\'' +
                ", partyname='" + partyname + '\'' +
                ", adress='" + adress + '\'' +
                ", contact='" + contact + '\'' +
                ", weight=" + weight +
                ", rate=" + rate +
                ", loadingcharge=" + loadingcharge +
                ", security=" + security +
                ", diesel=" + diesel +
                ", cash=" + cash +
                ", total=" + total +
                ", balance=" + balance +
                '}';
    }
}

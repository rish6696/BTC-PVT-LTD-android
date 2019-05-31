package com.example.btcroadlinesprivateltd;

public class PartySecurity {
    String lrnum,tno,date,time;
    float security,materialshortagecharges,fratecharges,recievingcharge,tds,weight,topay;
    Boolean status =false;

    public PartySecurity(String lrnum, String tno, float security) {
        this.lrnum = lrnum;
        this.tno = tno;
        this.security = security;
    }
}

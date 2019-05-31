package com.example.btcroadlinesprivateltd;

public class TruckSecurity {
    String tno,lrnum,aacounum,ifsc,holdername;
    float Tds=0,security=0,weight=0,fratecharge,materialshortage,topay;
    Boolean status =false;

    public TruckSecurity(String tno, String lrnum, float security) {
        this.tno = tno;
        this.lrnum = lrnum;
        this.security = security;
    }

}

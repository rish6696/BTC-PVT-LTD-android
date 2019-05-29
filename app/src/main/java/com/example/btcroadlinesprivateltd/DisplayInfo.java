package com.example.btcroadlinesprivateltd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayInfo extends AppCompatActivity {

    TextView tno,lrnum,ownph,wiegh,ratee,cashp,desel,securityy,dalachar,comisn,bitichrge,totall,balancee,banname,banbranch,acno,ifno,holdername;
    TextView plrnum,pname,contactnumber,pwiegh,pratee,pcashp,pdesel,psecurityy,ptotall,pbalancee,loadingc,padress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);
        Log.i("sachin tendulkar",Booking_recview_Adapter.t.toString());


        tno=(TextView)findViewById(R.id.truck);
        lrnum=(TextView)findViewById(R.id.lrno);

        ownph=(TextView)findViewById(R.id.ownphone);
        wiegh=(TextView)findViewById(R.id.weight);
        ratee=(TextView)findViewById(R.id.rate);
        cashp=(TextView)findViewById(R.id.cashpaid);
        desel=(TextView)findViewById(R.id.diesel);
        securityy=(TextView)findViewById(R.id.security);
        dalachar=(TextView)findViewById(R.id.dalacharge);
        comisn=(TextView)findViewById(R.id.commision);
        bitichrge=(TextView)findViewById(R.id.biltycharge);
        totall=(TextView)findViewById(R.id.total);
        balancee=(TextView)findViewById(R.id.balance);

        banname=(TextView)findViewById(R.id.bankname);
        banbranch=(TextView)findViewById(R.id.bankbranch);
        acno=(TextView)findViewById(R.id.acountno);
        ifno=(TextView)findViewById(R.id.ifsccode);
        holdername=(TextView)findViewById(R.id.acountholdername);




        padress=(TextView)findViewById(R.id.partyadress);

        plrnum=(TextView)findViewById(R.id.plrno);
        pname=(TextView)findViewById(R.id.partyname);
        contactnumber=(TextView)findViewById(R.id.partycontact);
        pwiegh=(TextView)findViewById(R.id.pweight);
        pratee=(TextView)findViewById(R.id.prate);
        pcashp=(TextView)findViewById(R.id.pcashpaid);
        pdesel=(TextView)findViewById(R.id.pdiesel);
        psecurityy=(TextView)findViewById(R.id.psecurity);
        ptotall=(TextView)findViewById(R.id.ptotal);
        pbalancee=(TextView)findViewById(R.id.pbalance);
        loadingc=(TextView)findViewById(R.id.loadingcharge);

        setTruckinfo();
        setPartyinfo();
    }

    private void setPartyinfo() {
        plrnum.setText(Booking_recview_Adapter.p.lrnum);
        padress.setText(Booking_recview_Adapter.p.adress);
        pname.setText(Booking_recview_Adapter.p.partyname);
        contactnumber.setText(Booking_recview_Adapter.p.contact);
        pwiegh.setText(Booking_recview_Adapter.p.weight+"");
        pratee.setText(Booking_recview_Adapter.p.rate+"");
        loadingc.setText(Booking_recview_Adapter.p.loadingcharge+"");
        psecurityy.setText(Booking_recview_Adapter.p.security+"");
        pdesel.setText(Booking_recview_Adapter.p.diesel+"");
        pcashp.setText(Booking_recview_Adapter.p.cash+"");
        ptotall.setText(Booking_recview_Adapter.p.total+"");
        pbalancee.setText(Booking_recview_Adapter.p.balance+"");
    }

    private void setTruckinfo() {
        tno.setText(Booking_recview_Adapter.t.truckno);
        lrnum.setText(Booking_recview_Adapter.t.lrnum);
        ownph.setText(Booking_recview_Adapter.t.ownerph);
        wiegh.setText(Booking_recview_Adapter.t.weight+"");
        ratee.setText(Booking_recview_Adapter.t.rate+"");
        cashp.setText(Booking_recview_Adapter.t.cash+"");
        desel.setText(Booking_recview_Adapter.t.diesel+"");
        securityy.setText(Booking_recview_Adapter.t.security+"");
        dalachar.setText(Booking_recview_Adapter.t.dala+"");
        comisn.setText(Booking_recview_Adapter.t.comisiion+"");
        bitichrge.setText(Booking_recview_Adapter.t.bilty+"");
        totall.setText("Total amount="+Booking_recview_Adapter.t.total+"");
        balancee.setText("Balance="+Booking_recview_Adapter.t.balance+"");
        acno.setText(Booking_recview_Adapter.t.accountno);
        ifno.setText(Booking_recview_Adapter.t.ifsccode);


    }
}

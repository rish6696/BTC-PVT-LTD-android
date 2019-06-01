package com.example.btcroadlinesprivateltd;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HistoryDisplay extends AppCompatActivity {

    TextView tno,lrnum,ownph,wiegh,ratee,cashp,desel,securityy,dalachar,comisn,bitichrge,totall,balancee,acno,ifno,holdername;
    TextView plrnum,pname,contactnumber,pwiegh,pratee,pcashp,pdesel,psecurityy,ptotall,pbalancee,loadingc,padress;
    TextView truckno,trucklrno,truckweightt,trucksecurity,trucktopay,bankholder,accountno,ifsc,trucktds,truckmaterialshortage,truckmaterialfrate;
    TextView trucknopartty,lrno,weightt,securityparty,topay,tds,materialshortage,materialfrate;

    Button psec,tsec;
    static Booking booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_display);


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



        acno=(TextView)findViewById(R.id.acountno);
        ifno=(TextView)findViewById(R.id.ifsccode);
        holdername=(TextView)findViewById(R.id.acountholdername);
        psec=(Button)findViewById(R.id.epartysecurity);
        tsec=(Button)findViewById(R.id.etrucksecurity);
        booking=HistoryAdapter.booking;


        if (booking.truckSecurity.status)
        {
            tsec.setVisibility(View.INVISIBLE);

        }
        if (booking.partySecurity.status)
        {
            psec.setVisibility(View.INVISIBLE);

        }






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





        truckno=(TextView)findViewById(R.id.trucknumbersecurity);
        trucklrno=(TextView)findViewById(R.id.lrnotrucksecurity);
        truckweightt=(TextView)findViewById(R.id.truckweighttn);
        trucksecurity=(TextView)findViewById(R.id.securitysecurity);
        trucktopay=(TextView)findViewById(R.id.trucktopay);
        bankholder=(TextView)findViewById(R.id.acountholdernametsecurity);
        accountno=(TextView)findViewById(R.id.acountnosecurity);
        ifsc=(TextView)findViewById(R.id.ifsccodetrucksecurity);
        trucktds=(TextView)findViewById(R.id.trucktds);
        truckmaterialshortage=(TextView)findViewById(R.id.truckmaterialshortage);
        truckmaterialfrate=(TextView)findViewById(R.id.truckmaterialfortage);




        trucknopartty=(TextView)findViewById(R.id.trucknoparty);
        lrno=(TextView)findViewById(R.id.lrnoparty);
        weightt=(TextView)findViewById(R.id.weighttn);
        securityparty=(TextView)findViewById(R.id.securityparty);
        topay=(TextView)findViewById(R.id.topayparty);
        tds=(TextView)findViewById(R.id.tdsparty);
        materialshortage=(TextView)findViewById(R.id.materialshortage);
        materialfrate=(TextView)findViewById(R.id.materialfortage);

        setTruckinfo();
        setPartyinfo();
        setTruckSecurity();
        setPartySecurity();
    }

    private void setPartySecurity() {

        Log.i("viratkohli",tds+"");

        trucknopartty.setText(booking.truckSecurity.tno);
        lrno.setText(booking.partySecurity.lrnum);
        weightt.setText(booking.partySecurity.weight+"");
        securityparty.setText(booking.partySecurity.security+"");
        topay.setText("Paid Amount:"+booking.partySecurity.topay);
        tds.setText(booking.partySecurity.tds+"");
        materialfrate.setText(booking.partySecurity.fratecharges+"");
        materialshortage.setText(booking.partySecurity.materialshortagecharges+"");
    }

    private void setTruckSecurity() {
        truckno.setText(booking.truckSecurity.tno);
        trucklrno.setText(booking.truckSecurity.lrnum);
        truckweightt.setText(booking.truckSecurity.weight+"");
        trucksecurity.setText(booking.truckSecurity.security+"");
        trucktds.setText(booking.truckSecurity.Tds+"");
        truckmaterialshortage.setText(booking.truckSecurity.materialshortage+"");
        truckmaterialfrate.setText(booking.truckSecurity.fratecharge+"");
        trucktopay.setText("Amount Paid:"+booking.truckSecurity.topay+"");
        bankholder.setText(booking.truckSecurity.holdername);
        accountno.setText(booking.truckSecurity.aacounum);
        ifsc.setText(booking.truckSecurity.ifsc);
    }

    private void setPartyinfo() {
        plrnum.setText(booking.party.lrnum);
        padress.setText(booking.party.adress);
        pname.setText(booking.party.partyname);
        contactnumber.setText(booking.party.contact);
        pwiegh.setText(booking.party.weight+"");
        pratee.setText(booking.party.rate+"");
        loadingc.setText(booking.party.loadingcharge+"");
        psecurityy.setText(booking.party.security+"");
        pdesel.setText(booking.party.diesel+"");
        pcashp.setText(booking.party.cash+"");
        ptotall.setText("Total="+booking.party.total+"");
        pbalancee.setText("Balance="+booking.party.balance+"");
    }

    private void setTruckinfo() {
        tno.setText(booking.truck.truckno);
        lrnum.setText(booking.truck.lrnum);
        ownph.setText(booking.truck.ownerph);
        wiegh.setText(booking.truck.weight+"");
        ratee.setText(booking.truck.rate+"");
        cashp.setText(booking.truck.cash+"");
        desel.setText(booking.truck.diesel+"");
        securityy.setText(booking.truck.security+"");
        dalachar.setText(booking.truck.dala+"");
        comisn.setText(booking.truck.comisiion+"");
        bitichrge.setText(booking.truck.bilty+"");
        totall.setText("Total amount="+booking.truck.total+"");
        balancee.setText("Balance="+booking.truck.balance+"");
        acno.setText(booking.truck.accountno);
        ifno.setText(booking.truck.ifsccode);
        holdername.setText(booking.truck.holdername);


    }

    public void enterpartysecurity(View view) {
        startActivity(new Intent(getApplicationContext(),EnterPartySecuriy.class));
    }

    public void entertrucksecurity(View view) {

        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Select Type Of details").setMessage("Please Select Type of Details")
                .setPositiveButton("After party receiving", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(getApplicationContext(),EnterTrucksecurityAfter.class));



                    }
                }).setNegativeButton("Before party receiving", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent=new Intent(getApplicationContext(),EnterTruckSecurityB.class);
                startActivity(intent);

            }
        }).show();


    }
}

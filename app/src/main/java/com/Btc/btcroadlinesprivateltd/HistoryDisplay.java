package com.Btc.btcroadlinesprivateltd;

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

    TextView tno,lrnum,ownph,wiegh,ratee,cashp,desel,securityy,dalachar,comisn,bitichrge,totall,balancee,acno,ifno,holdername,challannumber,rcname;
    TextView plrnum,pname,contactnumber,pwiegh,pratee,pcashp,pdesel,psecurityy,ptotall,pbalancee,loadingc,loadingadress,unloadingadress;
    TextView truckno,trucklrno,truckweightt,trucksecurity,trucktopay,bankholder,accountno,ifsc,trucktds,truckmaterialshortage,truckmaterialfrate,remarks;
    TextView trucknopartty,lrno,weightt,securityparty,topay,tds,materialshortage,materialfrate,recievingcgarge;


    Button psec,tsec;
    static Booking booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_display);


        tno=(TextView)findViewById(R.id.truck);
        lrnum=(TextView)findViewById(R.id.lrno);
        challannumber=(TextView)findViewById(R.id.challannumber);
        rcname=(TextView)findViewById(R.id.rcname);

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






        loadingadress=(TextView)findViewById(R.id.loadingadress);
        unloadingadress=(TextView) findViewById(R.id.unloadingadress);

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
        remarks=(TextView) findViewById(R.id.remarks);
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
        recievingcgarge=(TextView) findViewById(R.id.recievingcharge);

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
        recievingcgarge.setText(booking.partySecurity.recievingcharge+"");
    }

    private void setTruckSecurity() {
        remarks.setText(booking.truckSecurity.remarks);
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
        plrnum.setText(booking.partyAdvance.lrnum);
        loadingadress.setText(booking.partyAdvance.loadadress);
        unloadingadress.setText(booking.partyAdvance.unloadadress);
        pname.setText(booking.partyAdvance.partyname);
        contactnumber.setText(booking.partyAdvance.contact);
        pwiegh.setText(booking.partyAdvance.weight+"");
        pratee.setText(booking.partyAdvance.rate+"");
        loadingc.setText(booking.partyAdvance.loadingcharge+"");
        psecurityy.setText(booking.partyAdvance.security+"");
        pdesel.setText(booking.partyAdvance.diesel+"");
        pcashp.setText(booking.partyAdvance.cash+"");
        ptotall.setText("Total="+booking.partyAdvance.total+"");
        pbalancee.setText("Balance="+booking.partyAdvance.balance+"");
    }

    private void setTruckinfo() {
        challannumber.setText(booking.truckAdvance.challanNo);
        rcname.setText(booking.truckAdvance.rcName);
        tno.setText(booking.truckAdvance.truckno);
        lrnum.setText(booking.truckAdvance.lrnum);
        ownph.setText(booking.truckAdvance.ownerph);
        wiegh.setText(booking.truckAdvance.weight+"");
        ratee.setText(booking.truckAdvance.rate+"");
        cashp.setText(booking.truckAdvance.cash+"");
        desel.setText(booking.truckAdvance.diesel+"");
        securityy.setText(booking.truckAdvance.security+"");
        dalachar.setText(booking.truckAdvance.dala+"");
        comisn.setText(booking.truckAdvance.comisiion+"");
        bitichrge.setText(booking.truckAdvance.bilty+"");
        totall.setText("Total amount="+booking.truckAdvance.total+"");
        balancee.setText("Balance="+booking.truckAdvance.balance+"");
        acno.setText(booking.truckAdvance.accountno);
        ifno.setText(booking.truckAdvance.ifsccode);
        holdername.setText(booking.truckAdvance.holdername);


    }

    public void enterpartysecurity(View view) {
        startActivity(new Intent(getApplicationContext(),EnterPartySecuriy.class));
        finish();
    }

    public void entertrucksecurity(View view) {

        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Select Type Of details").setMessage("Please Select Type of Details")
                .setPositiveButton("After partyAdvance receiving", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(getApplicationContext(),EnterTrucksecurityAfter.class));
                        finish();



                    }
                }).setNegativeButton("Before partyAdvance receiving", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent=new Intent(getApplicationContext(),EnterTruckSecurityB.class);
                startActivity(intent);
               finish();

            }
        }).show();


    }
}

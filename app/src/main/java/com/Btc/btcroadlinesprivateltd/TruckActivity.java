package com.Btc.btcroadlinesprivateltd;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TruckActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    TextView tno,lrnum,ownph,wieghk,weightt,ratee,cashp,desel,securityy,dalachar,comisn,bitichrge,totall,balancee,portname,acno,ifno,holdername,challannumber,rcname;
    float rate=-1,weighttn=-1,cash=-1,diesel=-1,security=-1,dala=-1,comison=-1,bilti=-1,balance=-1,total=-1,weightkg=0,weighttotal;
    String trucknum,ownerphone,lrnumber,ownername,accountno,ifsccode,holname,chalannumber,rcnamee;

    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck);
        sharedPreferences=this.getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);



        tno=(TextView)findViewById(R.id.truck);
        lrnum=(TextView)findViewById(R.id.lrno);
        challannumber=(TextView)findViewById(R.id.challannumber);
        rcname=(TextView)findViewById(R.id.rcname);

        ownph=(TextView)findViewById(R.id.ownphone);
        weightt=(TextView)findViewById(R.id.weighttn);
        wieghk=(TextView)findViewById(R.id.weightkg);
        ratee=(TextView)findViewById(R.id.rate);
        cashp=(TextView)findViewById(R.id.cashpaid);
        desel=(TextView)findViewById(R.id.diesel);
        securityy=(TextView)findViewById(R.id.security);
        dalachar=(TextView)findViewById(R.id.dalacharge);
        comisn=(TextView)findViewById(R.id.commision);
        bitichrge=(TextView)findViewById(R.id.biltycharge);
        totall=(TextView)findViewById(R.id.total);
        balancee=(TextView)findViewById(R.id.balance);
        portname=(TextView)findViewById(R.id.port);
        acno=(TextView)findViewById(R.id.acountno);
        ifno=(TextView)findViewById(R.id.ifsccode);
        holdername=(TextView)findViewById(R.id.acountholdername);
        portname.setText("OFFICE="+MainActivity.portname);
        lrnumber=PartyActivity.lrnumber;
        lrnum.setText(lrnumber);

        weighttn=PartyActivity.weighttn;
        weightt.setText(weighttn+"Ton");
        weightkg=PartyActivity.weightkg;

        wieghk.setText(weightkg+"kg");

        apiInterface=ApiClient.getClient().create(ApiInterface.class);




    }

    public void calculateTandB(View view) {
        validateInfo();

    }

    public void submit(View view) {
        trucknum=tno.getText().toString();
        ownerphone=ownph.getText().toString();
        accountno=acno.getText().toString();
        ifsccode=ifno.getText().toString();
        holname=holdername.getText().toString();
        chalannumber=challannumber.getText().toString();
        rcnamee=rcname.getText().toString();

        if(trucknum.length()<=0)
        {
            tno.setError("INVALID");
            tno.requestFocus();

        }
        else if(ownerphone.length()<=0)
        {
            ownph.setError("INVALID");
            ownph.requestFocus();
        }
        else if(accountno.length()<=0)
        {
            acno.setError("INVALID");
            acno.requestFocus();
        }
        else if (ifsccode.length()<=0)
        {
            ifno.setError("INVALID");
            ifno.requestFocus();
        }
        else if (holdername.length()<=0)
        {
            holdername.setError("INVALID");
            holdername.requestFocus();
        }
        else if(chalannumber.length()<0){
            challannumber.setError("INVALID");
            challannumber.requestFocus();
        }
        else if(rcnamee.length()<0){
            rcname.setError("INVALID");
            rcname.requestFocus();
        }
        else if (!validateInfo()){


        }
        else {
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Please check the details before confirming").setMessage("Truck no:"+trucknum+"\n"+"LR no:"+lrnumber+"\n"+"Owner phno:"+ownerphone+"\n"+"Weight:"+weighttn+"ton "+weightkg+"kg"+"\n"+"Rate:"+rate+"\n"+"Cash:"+cash+"\n"+"Diesel:"+diesel+"\n"+"Security:"+security+"\n"+"Dala charge:"+dala+"\n"+"Comission:"+comison+"\n"+"Bilti charge:"+bilti+"\n"+"Balance:"+balance+"\n"+"Accountno:"+accountno+"\n"+"IFSC:"+ifsccode+"\n"+"Holder name:"+holdername.getText().toString()+"\n"+"Challan Number:"+chalannumber+"\n"+"RC Name:"+rcnamee+"\n")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (haveNetworkConnection()) {
                                //Toast.makeText(TruckActivity.this, "you selected yes", Toast.LENGTH_SHORT).show();
                                makeserverrequest();
                            }
                            else {
                                Toast.makeText(TruckActivity.this, "No internet", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).setNegativeButton("no",null).show();

        }





    }

    private void makeserverrequest() {
        final android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(this).create();
        final ProgressBar pb = new ProgressBar(this);
        alertDialog.setView(pb);
        alertDialog.show();
        Truck tbd=new Truck(trucknum
        ,lrnumber,ownerphone,accountno,ifsccode,holname,chalannumber,rcnamee,weighttotal,rate,cash,diesel,security,dala,comison,bilti,total,balance);
        TruckSecurity truckSecurity=new TruckSecurity(tbd.truckno,tbd.lrnum,tbd.security);
        PartySecurity partySecurity=new PartySecurity(PartyActivity.pbd.lrnum,tbd.truckno,PartyActivity.pbd.security);
        Booking booking=new Booking(MainActivity.portname,tbd,PartyActivity.pbd,truckSecurity,partySecurity,false);
        Call<BookingAddingResponse> call=apiInterface.SubmitDetails(booking);
        call.enqueue(new Callback<BookingAddingResponse>() {
            @Override
            public void onResponse(Call<BookingAddingResponse> call, Response<BookingAddingResponse> response) {
                if (response.body().ok==1)
                {
                    alertDialog.dismiss();
                    Toast.makeText(TruckActivity.this, "Submitted Suceessfully", Toast.LENGTH_SHORT).show();
                    tno.setText("");
                    lrnum.setText("");
                    ownph.setText("");
                    weightt.setText("");
                    wieghk.setText("");
                    ratee.setText("");
                    cashp.setText("");
                    desel.setText("");
                    securityy.setText("");
                    dalachar.setText("");
                    challannumber.setText("");
                    rcname.setText("");
                    comisn.setText("");
                    bitichrge.setText("");
                    totall.setText("Total:");
                    balancee.setText("Acount Balance:");
                    acno.setText("");
                    holdername.setText("");
                    ifno.setText("");
                    PartyActivity.ResetFields();
                    startActivity(new Intent(getApplicationContext(),PartyActivity.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<BookingAddingResponse> call, Throwable t) {
                pb.setVisibility(View.INVISIBLE);
                Toast.makeText(TruckActivity.this, "Cannot submit,try again later", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public boolean validateInfo()
    {
        //float rate=0,weight=0,cash=0,diesel=0,security=0,dala=0,comison=0,bilti=0,balance=0,total;

        // Toast.makeText(this, ratee.getText().toString(), Toast.LENGTH_SHORT).show();
        if (ratee.getText().length()==0||ratee.getText().equals("0")) {
            ratee.setError("INVALID");
            ratee.requestFocus();

            return false;
        }
        rate = Float.parseFloat(ratee.getText().toString());
        weighttotal=weighttn+(weightkg/1000);

        total=rate*weighttotal;
        if (total<=300000) {
            totall.setText("Total=" + Float.toString(total));
        }
        else{
            weightt.setError("INVALID");
            weightt.requestFocus();
            ratee.setError("INVALID");
            ratee.requestFocus();
            totall.setError("INVALID");
            totall.requestFocus();
            return false;
        }
        if (cashp.getText().length()==0||cashp.getText().equals("0")) {
            cashp.setError("INVALID");
            cashp.requestFocus();
             return false;

        }
        cash = Float.parseFloat(cashp.getText().toString());
        if (desel.getText().length()==0||desel.getText().equals("0")) {
            desel.setError("INVALID");
            desel.requestFocus();
            return false;
        }
        diesel = Float.parseFloat(desel.getText().toString());
        if (securityy.getText().length()==0||securityy.getText().equals("0")) {
            securityy.setError("INVALID");
            securityy.requestFocus();
            return false;
        }
        security = Float.parseFloat(securityy.getText().toString());
        if (dalachar.getText().length()==0||dalachar.getText().equals("0")) {
            dalachar.setError("INVALID");
            dalachar.requestFocus();
           return false;
        }
        dala = Float.parseFloat(dalachar.getText().toString());
        if (comisn.getText().length()==0||comisn.getText().equals("0")) {
            comisn.setError("INVALID");
            comisn.requestFocus();
           return false;
        }
        comison=Float.parseFloat(comisn.getText().toString());
        if (bitichrge.getText().length()==0||bitichrge.getText().equals("0")) {
            bitichrge.setError("INVALID");
            bitichrge.requestFocus();

           return false;
        }
        bilti = Float.parseFloat(bitichrge.getText().toString());
        balance=total-cash-diesel-security-dala-comison-bilti;
        balancee.setText("Account Balance=" + Float.toString(balance));
        return true;

    }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.logout)
        {
            sharedPreferences.edit().putString("portname","null").apply();
            sharedPreferences.edit().putBoolean("status",false).apply();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();

        }
        else if(item.getItemId()==R.id.history)
        {
            Intent intent=new Intent(getApplicationContext(),HistoryActivity.class);
            startActivity(intent);

        }
        return false;
    }
}

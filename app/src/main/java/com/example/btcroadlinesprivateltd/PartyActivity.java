package com.example.btcroadlinesprivateltd;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class PartyActivity extends AppCompatActivity  {

    ApiInterface apiInterface;

    static TextView wieghk,weightt,lrnum,pname,contactnumber,ratee,cashp,desel,securityy,totall,balancee,portname,loadingc,padress;
     float rate=-1,weighttn=-1,weightkg=0,weighttotal,cash=-1,diesel=-1,security=-1,balance=-1,total=-1,loadingcharge=-1;
     String partyphone,lrnumber,partyname,partyadress;
    SharedPreferences sharedPreferences;
    static Party pbd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party);
        sharedPreferences=this.getSharedPreferences("com.example.btcroadlinesprivateltd", Context.MODE_PRIVATE);
        portname=(TextView)findViewById(R.id.port);
        portname.setText("Port="+MainActivity.portname);
        padress=(TextView)findViewById(R.id.partyadress);
        weightt=(TextView)findViewById(R.id.weighttn);
        wieghk=(TextView)findViewById(R.id.weightkg);

        lrnum=(TextView)findViewById(R.id.lrno);
        pname=(TextView)findViewById(R.id.partyname);
        contactnumber=(TextView)findViewById(R.id.partycontact);
        ratee=(TextView)findViewById(R.id.rate);
        cashp=(TextView)findViewById(R.id.cashpaid);
        desel=(TextView)findViewById(R.id.diesel);
        securityy=(TextView)findViewById(R.id.security);
        totall=(TextView)findViewById(R.id.total);
        balancee=(TextView)findViewById(R.id.balance);
        loadingc=(TextView)findViewById(R.id.loadingcharge);
        apiInterface=ApiClient.getClient().create(ApiInterface.class);

    }
    public void calculateTandB(View view) {
        validateInfo();

    }

    public boolean validateInfo()
    {
        //float rate=0,weight=0,cash=0,diesel=0,security=0,dala=0,comison=0,bilti=0,balance=0,total;

        // Toast.makeText(this, ratee.getText().toString(), Toast.LENGTH_SHORT).show();
        if (ratee.getText().length()==0||ratee.getText().equals("0.0")) {
            ratee.setError("INVALID");
            ratee.requestFocus();

            return false;
        }
        rate = Float.parseFloat(ratee.getText().toString());
        if (weightt.getText().length()==0||weightt.getText().equals("0")) {
            weightt.setError("INVALID");
            weightt.requestFocus();
            return false;

        }
        weighttn = Float.parseFloat(weightt.getText().toString());
        if (wieghk.getText().length()==0) {
            weightkg=0;

        }
        else{
            weightkg= Float.parseFloat(wieghk.getText().toString());

        }
        weighttotal=weighttn+(weightkg/1000);
        total=rate*weighttotal;
        totall.setText("Total="+Float.toString(total));
        if (cashp.getText().length()==0||cashp.getText().equals("0.0")) {
            cashp.setError("INVALID");
            cashp.requestFocus();
            return false;

        }
        cash = Float.parseFloat(cashp.getText().toString());
        if (desel.getText().length()==0||desel.getText().equals("0.0")) {
            desel.setError("INVALID");
            desel.requestFocus();
            return false;
        }
        diesel = Float.parseFloat(desel.getText().toString());
        if (securityy.getText().length()==0||securityy.getText().equals("0.0")) {
            securityy.setError("INVALID");
            securityy.requestFocus();
            return false;
        }
        security = Float.parseFloat(securityy.getText().toString());
        if (loadingc.getText().length()==0||loadingc.getText().equals("0.0")) {
            loadingc.setError("INVALID");
            loadingc.requestFocus();
            return false;
        }
        loadingcharge = Float.parseFloat(loadingc.getText().toString());



        balance=total-cash-diesel-security-loadingcharge;
        balancee.setText("Balance=" + Float.toString(balance));
        return true;

    }
    public void submit(View view) {

        lrnumber=lrnum.getText().toString();
        partyphone=contactnumber.getText().toString();
        partyname=pname.getText().toString();
        partyadress=padress.getText().toString();


        if(lrnumber.length()<=0)
        {
            lrnum.setError("INVALID");
            lrnum.requestFocus();
        }
        else if (partyname.length()<=0)
        {
            pname.setError("INVALID");
            pname.requestFocus();

        }
        else if(partyphone.length()<=0)
        {
            contactnumber.setError("INVALID");
            contactnumber.requestFocus();
        }
        else if(partyadress.length()<=0)
        {
            padress.setError("INVALID");
            padress.requestFocus();
        }
        else if (!validateInfo()){


        }
        else {
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Please check the details before filling Truck details").setMessage("LR no:"+lrnumber+"\n"+"Party name:"+partyname+"\n"+"Party Adress:"+partyadress+"\n"+"Party phno:"+partyphone+"\n"+"Weight:"+weighttn+"ton "+weightkg+"kg"+"\n"+"Rate:"+rate+"\n"+"Cash:"+cash+"\n"+"Diesel:"+diesel+"\n"+"Security:"+security+"\n"+"Loading charge:"+loadingcharge+"\n"+"Balance:"+balance)
                    .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            pbd=new Party(lrnumber,partyname,partyadress
                                    ,partyphone,weighttotal,rate,loadingcharge,security,diesel,cash,total,balance
                            );
                            Intent intent=new Intent(getApplicationContext(),TruckActivity.class);
                            startActivity(intent);

                        }
                    }).setNegativeButton("Edit",null).show();

        }

    }
    public static void ResetFields()
    {
        lrnum.setText("");
        pname.setText("");
        padress.setText("");
        contactnumber.setText("");
        weightt.setText("");
        wieghk.setText("");
        ratee.setText("");
        loadingc.setText("");
        securityy.setText("");
        desel.setText("");
        cashp.setText("");
        totall.setText("");
        balancee.setText("");
    }

    @Override
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

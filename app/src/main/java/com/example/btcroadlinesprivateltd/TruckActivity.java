package com.example.btcroadlinesprivateltd;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TruckActivity extends AppCompatActivity {
    TextView tno,lrnum,ownname,ownph,wiegh,ratee,cashp,desel,securityy,dalachar,comisn,bitichrge,totall,balancee,portname,banname,banbranch,acno,ifno,holdername;
    float rate=-1,weight=-1,cash=-1,diesel=-1,security=-1,dala=-1,comison=-1,bilti=-1,balance=-1,total=-1;
    String trucknum,ownerphone,lrnumber,ownername,bankname,branch,accountno,ifsccode,holname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck);
        tno=(TextView)findViewById(R.id.truck);
        lrnum=(TextView)findViewById(R.id.lrno);
        ownname=(TextView)findViewById(R.id.ownname);
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
        portname=(TextView)findViewById(R.id.port);
        banname=(TextView)findViewById(R.id.bankname);
        banbranch=(TextView)findViewById(R.id.bankbranch);
        acno=(TextView)findViewById(R.id.acountno);
        ifno=(TextView)findViewById(R.id.ifsccode);
        holdername=(TextView)findViewById(R.id.acountholdername);
        portname.setText("Port="+MainActivity.portname);




    }

    public void calculateTandB(View view) {
        validateInfo();

    }

    public void submit(View view) {
        trucknum=tno.getText().toString();
        lrnumber=lrnum.getText().toString();
        ownerphone=ownph.getText().toString();
        ownername=ownname.getText().toString();
        accountno=acno.getText().toString();
        ifsccode=ifno.getText().toString();

        if(trucknum.length()<=0)
        {
            tno.setError("INVALID");
            tno.requestFocus();

        }
        else if(lrnumber.length()<=0)
        {
            lrnum.setError("INVALID");
            lrnum.requestFocus();
        }
        else if (ownername.length()<=0)
        {
            ownname.setError("INVALID");
            ownname.requestFocus();

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
        else if (!validateInfo()){


        }
        else {
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Please check the details before confirming").setMessage("Truck no:"+trucknum+"\n"+"LR no:"+lrnumber+"\n"+"Owner name:"+ownername+"\n"+"Owner phno:"+ownerphone+"\n"+"Weight:"+weight+"\n"+"Rate:"+rate+"\n"+"Cash:"+cash+"\n"+"Diesel:"+diesel+"\n"+"Security:"+security+"\n"+"Dala charge:"+dala+"\n"+"Comission:"+comison+"\n"+"Bilti charge:"+bilti+"\n"+"Balance:"+balance+"\n"+"Accountno:"+accountno+"\n"+"IFSC:"+ifsccode)
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(TruckActivity.this, "you selected yes", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("no",null).show();

        }





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
        if (wiegh.getText().length()==0||wiegh.getText().equals("0.0")) {
            wiegh.setError("INVALID");
            wiegh.requestFocus();
            return false;

        }
        weight = Float.parseFloat(wiegh.getText().toString());
        total=rate*weight;
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
        if (dalachar.getText().length()==0||dalachar.getText().equals("0")) {
            dalachar.setError("INVALID");
            dalachar.requestFocus();
           return false;
        }
        dala = Float.parseFloat(dalachar.getText().toString());
        if (comisn.getText().length()==0||comisn.getText().equals("0.0")) {
            comisn.setError("INVALID");
            comisn.requestFocus();
           return false;
        }
        comison=Float.parseFloat(comisn.getText().toString());
        if (bitichrge.getText().length()==0||bitichrge.getText().equals("0.0")) {
            bitichrge.setError("INVALID");
            bitichrge.requestFocus();

           return false;
        }
        bilti = Float.parseFloat(bitichrge.getText().toString());
        balance=total-cash-diesel-security-dala-comison-bilti;
        balancee.setText("Balance=" + Float.toString(balance));
        return true;

    }
}
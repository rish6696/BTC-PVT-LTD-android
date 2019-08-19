package com.Btc.btcroadlinesprivateltd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnterPartySecuriy extends AppCompatActivity {

    TextView truckno,lrno,wieghk,weightt,security,topay,tds,materialshortage,materialfrate,recievingcgarge,wieghtdiff;
    Button cal,submit;
    Booking booking;
    float wdiff,tdsval,frate,matreduc,weighttn=0,weightkg=0,weighttotal,payamnt,reciechar;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_party_securiy);


        booking=HistoryDisplay.booking;
        recievingcgarge=(TextView) findViewById(R.id.recievingcharge);
        truckno=(TextView)findViewById(R.id.truck);
        lrno=(TextView)findViewById(R.id.lrno);
        wieghtdiff=(TextView)findViewById(R.id.weightdiff);
        weightt=(TextView)findViewById(R.id.weighttn);
        wieghk=(TextView)findViewById(R.id.weightkg);
        security=(TextView)findViewById(R.id.security);
        topay=(TextView)findViewById(R.id.topay);
        tds=(TextView)findViewById(R.id.tds);
        materialshortage=(TextView)findViewById(R.id.materialshortage);
        materialfrate=(TextView)findViewById(R.id.materialfortage);
        apiInterface=ApiClient.getClient().create(ApiInterface.class);



        submit=(Button)findViewById(R.id.submit);
        cal=(Button)findViewById(R.id.calculate);

        truckno.setText(booking.truckAdvance.truckno);
        lrno.setText(booking.partyAdvance.lrnum);
        security.setText(booking.partyAdvance.security+"");
    }

    public void CalB(View view)
    {

        if (validateinfo())
        {

            payamnt=booking.partySecurity.security-frate-matreduc-tdsval-reciechar;
            Log.i("sec",booking.truckAdvance.security+"");
            Log.i("frate",frate+"");
            Log.i("matred",matreduc+"");
            Log.i("tds",tdsval+"");

            topay.setText("To Pay="+payamnt);
            wieghtdiff.setText(""+wdiff+"Ton");


        }

    }

    public void submitT(View view) {

        if (validateinfo())
        {

            updateRequest();
        }
    }



    private void updateRequest() {
        final android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(this).create();
        ProgressBar pb = new ProgressBar(this);
        alertDialog.setView(pb);
        alertDialog.show();

        booking.partySecurity.weight=weighttotal;
        booking.partySecurity.tds=tdsval;
        booking.partySecurity.materialshortagecharges=matreduc;
        booking.partySecurity.fratecharges=frate;
        booking.partySecurity.topay=payamnt;
        booking.partySecurity.status=true;
        booking.partySecurity.recievingcharge=reciechar;
        booking.partySecurity.weightdiff=wdiff;
        if (booking.truckSecurity.status)
        {
            booking.status=true;
        }
        Call<BookingAddingResponse> call=apiInterface.update(booking);
        call.enqueue(new Callback<BookingAddingResponse>() {
            @Override
            public void onResponse(Call<BookingAddingResponse> call, Response<BookingAddingResponse> response) {
                Log.i("viratkohli",response.body().toString());
                alertDialog.dismiss();
                if (response.body().ok==1)
                {
                    startActivity(new Intent(getApplicationContext(),HistoryActivity.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<BookingAddingResponse> call, Throwable t) {

            }
        });


    }

    public boolean validateinfo()
    {
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
        wdiff=booking.truckAdvance.weight-weighttotal;
        if (tds.getText().length()==0)
        {
            tdsval=0;
        }
        else{
            tdsval=Float.parseFloat(tds.getText().toString());

        }
        if (tds.getText().length()==0)
        {
            tdsval=0;
        }
        else{
            tdsval=Float.parseFloat(tds.getText().toString());

        }
        if (recievingcgarge.getText().length()==0)
        {
            reciechar=0;
        }
        else{
            reciechar=Float.parseFloat(recievingcgarge.getText().toString());

        }
        if (TextUtils.isEmpty(materialshortage.getText()))
        {
            materialshortage.setError("Invalid");
            materialshortage.requestFocus();
            return false;
        }
        matreduc=Float.parseFloat(materialshortage.getText().toString());

        if (TextUtils.isEmpty(materialfrate.getText()))
        {
            materialfrate.setError("Invalid");
            materialfrate.requestFocus();
            return false;
        }
        frate=Float.parseFloat(materialfrate.getText().toString());


        return true;


    }

}

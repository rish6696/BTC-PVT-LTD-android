package com.example.btcroadlinesprivateltd;

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

public class EnterTrucksecurityAfter extends AppCompatActivity {
    TextView truckno,lrno,wieghk,weightt,security,topay,bankholder,accountno,ifsc,tds,materialshortage,materialfrate,weightdiff;
    Button cal,submit;
    Booking booking;
    float wdiff,tdsval,frate,matreduc,weighttn=0,weightkg=0,weighttotal,payamnt;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_trucksecurity_after);
        booking=HistoryDisplay.booking;
        truckno=(TextView)findViewById(R.id.truck);
        lrno=(TextView)findViewById(R.id.lrno);
        weightdiff=(TextView)findViewById(R.id.weightdiff);
        weightt=(TextView)findViewById(R.id.weighttn);
        wieghk=(TextView)findViewById(R.id.weightkg);
        security=(TextView)findViewById(R.id.security);
        topay=(TextView)findViewById(R.id.topay);
        bankholder=(TextView)findViewById(R.id.acountholdername);
        accountno=(TextView)findViewById(R.id.acountno);
        ifsc=(TextView)findViewById(R.id.ifsccode);
        tds=(TextView)findViewById(R.id.tds);
        materialshortage=(TextView)findViewById(R.id.materialshortage);
        materialfrate=(TextView)findViewById(R.id.materialfortage);
        apiInterface=ApiClient.getClient().create(ApiInterface.class);



        submit=(Button)findViewById(R.id.submit);
        cal=(Button)findViewById(R.id.calculate);

        truckno.setText(booking.truck.truckno);
        lrno.setText(booking.truck.lrnum);
        security.setText(booking.truck.security+"");








    }
    public void CalB(View view)
    {

        if (validateinfo())
        {

            payamnt=booking.truck.security-frate-matreduc-tdsval-400;
            Log.i("sec",booking.truck.security+"");
            Log.i("frate",frate+"");
            Log.i("matred",matreduc+"");
            Log.i("tds",tdsval+"");

            topay.setText("To Pay="+payamnt);
            weightdiff.setText(""+wdiff+"Ton");


        }

    }

    public void submitT(View view) {

        if (validateinfo())
        {
            if (TextUtils.isEmpty(accountno.getText()))
            {
                accountno.setError("Invalid");
                accountno.requestFocus();
                return;

            }
            if (TextUtils.isEmpty(bankholder.getText()))
            {
                bankholder.setError("Invalid");
                bankholder.requestFocus();
                return;

            }
            if (TextUtils.isEmpty(ifsc.getText()))
            {
                ifsc.setError("Invalid");
                ifsc.requestFocus();
                return;

            }
            updateRequest();
        }
    }



    private void updateRequest() {
        final android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(this).create();
        ProgressBar pb = new ProgressBar(this);
        alertDialog.setView(pb);
        alertDialog.show();

        booking.truckSecurity.weight=weighttotal;
        booking.truckSecurity.Tds=tdsval;
        booking.truckSecurity.materialshortage=matreduc;
        booking.truckSecurity.fratecharge=frate;
        booking.truckSecurity.topay=payamnt;
        booking.truckSecurity.aacounum=accountno.getText().toString();
        booking.truckSecurity.holdername=bankholder.getText().toString();
        booking.truckSecurity.ifsc=ifsc.getText().toString();
        booking.truckSecurity.status=true;
        if (booking.partySecurity.status)
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
        wdiff=booking.truck.weight-weighttotal;
        if (tds.getText().length()==0)
        {
            tdsval=0;
        }
        else{
            tdsval=Float.parseFloat(tds.getText().toString());

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


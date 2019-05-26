package com.example.btcroadlinesprivateltd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView usename,pasword;
    SharedPreferences sharedPreferences;
    static String portname;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usename=(TextView)findViewById(R.id.username);
        pasword=(TextView)findViewById(R.id.password);
        sharedPreferences=this.getSharedPreferences("com.example.btcroadlinesprivateltd", Context.MODE_PRIVATE);
        portname=sharedPreferences.getString("portname","null");
        if (!portname.equals("null"))
        {
            //take into the next activity
            //Toast.makeText(this, "taken to new activity", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getApplicationContext(), TruckActivity.class);
            startActivity(intent);

        }


    }

    public void login(View view) {

        if(true)//login successful
        {
            sharedPreferences.edit().putString("portname","vishakapatnam").apply();
        }
        else//not succesfull
        {

        }
    }
}

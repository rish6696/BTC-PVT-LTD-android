package com.example.btcroadlinesprivateltd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView usename,pasword;
    SharedPreferences sharedPreferences;
    static String portname;
    static Boolean status;
    ApiInterface apiInterface;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface=ApiClient.getClient().create(ApiInterface.class);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        usename=(TextView)findViewById(R.id.username);
        pasword=(TextView)findViewById(R.id.password);
        sharedPreferences=this.getSharedPreferences("com.example.btcroadlinesprivateltd", Context.MODE_PRIVATE);
        portname=sharedPreferences.getString("portname","null");
        status=sharedPreferences.getBoolean("status",false);
        if (status)
        {
            if (portname.equals("faridabadhr"))
            {
                Intent intent = new Intent(getApplicationContext(), Admin_activity.class);
                startActivity(intent);
                finish();
            }else {
                Intent intent = new Intent(getApplicationContext(), PartyActivity.class);
                startActivity(intent);
                finish();
            }

        }


    }

    public void login(View view) {
        if (haveNetworkConnection()) {


            final String username = usename.getText().toString();
            String password = pasword.getText().toString();
            if (username.length() > 0 && password.length() > 0) {
                progressBar.setVisibility(View.VISIBLE);

                LoginClass loginClass = new LoginClass(username, password);
                Call<LoginClass> call = apiInterface.loginrequest(loginClass);
                call.enqueue(new Callback<LoginClass>() {
                    @Override
                    public void onResponse(Call<LoginClass> call, Response<LoginClass> response) {
                        //Log.i("viratkohli",response.body().username);
                        progressBar.setVisibility(View.INVISIBLE);
                        status = response.body().status;
                        if (status) {
                            portname = response.body().username;
                            sharedPreferences.edit().putString("portname", portname).apply();
                            sharedPreferences.edit().putBoolean("status", status).apply();
                            if (portname.equals("faridabadhr"))
                            {
                                Intent intent = new Intent(getApplicationContext(), Admin_activity.class);
                                startActivity(intent);
                                finish();
                            }else {
                                Intent intent = new Intent(getApplicationContext(), PartyActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                            usename.setError("wrong username or password");
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginClass> call, Throwable t) {

                    }
                });
            } else {
                Toast.makeText(this, "username or password cannot be empty", Toast.LENGTH_SHORT).show();
                usename.setError("Cannot be empty");
                pasword.setError("Cannot be empty");

            }
        }
        else{
            Toast.makeText(this, "No internet", Toast.LENGTH_SHORT).show();
        }


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
}

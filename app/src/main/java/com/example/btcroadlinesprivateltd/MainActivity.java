package com.example.btcroadlinesprivateltd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView usename,pasword;
    SharedPreferences sharedPreferences;
    static String portname;
    Boolean status;
    ApiInterface apiInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface=ApiClient.getClient().create(ApiInterface.class);
        usename=(TextView)findViewById(R.id.username);
        pasword=(TextView)findViewById(R.id.password);
        sharedPreferences=this.getSharedPreferences("com.example.btcroadlinesprivateltd", Context.MODE_PRIVATE);
        portname=sharedPreferences.getString("portname","null");
        status=sharedPreferences.getBoolean("status",false);
        if (!portname.equals("null"))
        {
            //take into the next activity
            //Toast.makeText(this, "taken to new activity", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getApplicationContext(),PartyActivity.class);
            startActivity(intent);

        }


    }

    public void login(View view) {
        String username=usename.getText().toString();
        String password=pasword.getText().toString();

        LoginClass loginClass=new LoginClass(username,password);
        Call<LoginClass> call=apiInterface.loginrequest(loginClass);
        call.enqueue(new Callback<LoginClass>() {
            @Override
            public void onResponse(Call<LoginClass> call, Response<LoginClass> response) {
                Log.i("viratkohli",response.body().toString());
            }

            @Override
            public void onFailure(Call<LoginClass> call, Throwable t) {

            }
        });


    }
}

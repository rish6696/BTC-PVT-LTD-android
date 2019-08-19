package com.Btc.btcroadlinesprivateltd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Admin_activity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> Portnames;
    ArrayList<String> uniqueids;
    ApiInterface apiInterface;
    ProgressBar pb;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_activity);
        sharedPreferences=this.getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        pb=(ProgressBar)findViewById(R.id.pbbar);
        pb.setVisibility(View.VISIBLE);
        recyclerView=(RecyclerView) findViewById(R.id.recview);
        Portnames=new ArrayList<>();
        uniqueids=new ArrayList<>();
        apiInterface=ApiClient.getClient().create(ApiInterface.class);
        getAllPorts();




    }

    private void getAllPorts() {
        Call<List<LoginClass>> call=apiInterface.getAllports();
        call.enqueue(new Callback<List<LoginClass>>() {
            @Override
            public void onResponse(Call<List<LoginClass>> call, Response<List<LoginClass>> response) {
                for (int i=0;i<=response.body().size()-1;i++)
                {
                    if (!response.body().get(i).username.equals("hodfaridabad")) {
                        uniqueids.add(response.body().get(i)._id);
                        Portnames.add(response.body().get(i).username);
                    }
                }
                pb.setVisibility(View.INVISIBLE);
                recyclerView.setLayoutManager(new LinearLayoutManager(Admin_activity.this));
                recyclerView.setAdapter(new Ports_Adapter(Portnames,uniqueids));
                recyclerView.addItemDecoration(new SpacesItemDecoration(10));

            }

            @Override
            public void onFailure(Call<List<LoginClass>> call, Throwable t) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adminmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.logoutadmin)
        {

            sharedPreferences.edit().putString("portname","null").apply();
            sharedPreferences.edit().putBoolean("status",false).apply();

            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
        return false;
    }
}

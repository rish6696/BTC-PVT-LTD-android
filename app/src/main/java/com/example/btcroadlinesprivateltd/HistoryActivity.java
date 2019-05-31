package com.example.btcroadlinesprivateltd;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    SharedPreferences sharedPreferences;
    String username;
    RecyclerView recyclerView;
    ProgressBar pb;


    ArrayList<Booking> bookinglist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        apiInterface=ApiClient.getClient().create(ApiInterface.class);
        sharedPreferences=this.getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        username=sharedPreferences.getString("portname","null");
        pb=(ProgressBar)findViewById(R.id.pbbar);
        recyclerView=(RecyclerView)findViewById(R.id.recview);
        bookinglist=new ArrayList<>();
        fetchBookings();
    }

    private void fetchBookings() {
        LoginClass loginClass=new LoginClass(username);
        Call<List<Booking>> call=apiInterface.getBookings(loginClass);
        call.enqueue(new Callback<List<Booking>>() {
            @Override
            public void onResponse(Call<List<Booking>> call, Response<List<Booking>> response) {

                for (int i=0;i<=response.body().size()-1;i++)
                {
                    bookinglist.add(response.body().get(i));
                }
                pb.setVisibility(View.INVISIBLE);
                recyclerView.setLayoutManager(new LinearLayoutManager(HistoryActivity.this));
                recyclerView.setAdapter(new HistoryAdapter(bookinglist));
                recyclerView.addItemDecoration(new SpacesItemDecoration(10));

            }

            @Override
            public void onFailure(Call<List<Booking>> call, Throwable t) {

            }
        });

    }
}

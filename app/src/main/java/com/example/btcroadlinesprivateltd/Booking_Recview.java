package com.example.btcroadlinesprivateltd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Booking_Recview extends AppCompatActivity {
    ApiInterface apiInterface;
    String username;
    ArrayList<Booking> bookings;
    RecyclerView recyclerView;
    ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking__recview);
        pb=(ProgressBar)findViewById(R.id.bookingpbbar);
        bookings=new ArrayList<>();


        recyclerView=(RecyclerView)findViewById(R.id.bookingrecview);
        apiInterface=ApiClient.getClient().create(ApiInterface.class);
        username=getIntent().getStringExtra("username");
        getBooking();

    }

    private void getBooking() {
        LoginClass loginClass=new LoginClass(username);
        Call<List<Booking>> call=apiInterface.getBookings(loginClass);
        call.enqueue(new Callback<List<Booking>>() {
            @Override
            public void onResponse(Call<List<Booking>> call, Response<List<Booking>> response) {
                for (int i=0;i<=response.body().size()-1;i++)
                {
                    bookings.add(response.body().get(i));
                }
                pb.setVisibility(View.INVISIBLE);
                recyclerView.setLayoutManager(new LinearLayoutManager(Booking_Recview.this));
                recyclerView.setAdapter(new Booking_recview_Adapter(bookings));
                recyclerView.addItemDecoration(new SpacesItemDecoration(10));
            }

            @Override
            public void onFailure(Call<List<Booking>> call, Throwable t) {

            }
        });

    }
}

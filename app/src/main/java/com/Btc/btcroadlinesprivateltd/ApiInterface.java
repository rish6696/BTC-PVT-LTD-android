package com.Btc.btcroadlinesprivateltd;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("/get")
    Call<List<Sampleclass>> getObject(@Body Sampleclass sampleclass);

    @POST("/login")
    Call<LoginClass> loginrequest(@Body LoginClass loginClass);

    @POST("/booking/addbooking")
    Call<BookingAddingResponse> SubmitDetails(@Body Booking booking);

    @GET("/fetchallports/allports")
    Call<List<LoginClass>> getAllports();

    @POST("/fetchbookings")
    Call<List<Booking>> getBookings(@Body LoginClass loginClass);

    @POST("/update")
    Call<BookingAddingResponse> update(@Body Booking booking);
}

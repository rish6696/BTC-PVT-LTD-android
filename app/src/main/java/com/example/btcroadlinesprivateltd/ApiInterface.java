package com.example.btcroadlinesprivateltd;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("/get")
    Call<List<Sampleclass>> getObject(@Body Sampleclass sampleclass);

    @POST("/login")
    Call<LoginClass> loginrequest(@Body LoginClass loginClass);
}

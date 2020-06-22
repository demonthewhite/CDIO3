package com.example.qlbhcdio.retrofit;




import android.database.Observable;

import com.example.qlbhcdio.model.MessengerRes;
import com.example.qlbhcdio.model.Product;
import com.example.qlbhcdio.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataClient {

    @FormUrlEncoded
    @POST("login")
    Call <User> LoginUser(@Field("id") String id , @Field("password") String password );

    @FormUrlEncoded
    @POST("Register")
    Call<String > Register (@Field("id") String id,
                            @Field("password") String password,
                            @Field("name") String name);

    @GET("products")
    Call<List<Product>> getProduct();

    @FormUrlEncoded
    @POST("order/new/")
    Call<MessengerRes> newDetails (@Field("tendn") String name,
                                   @Field("ngay") String Date,
                                   @Field("data") String data );

}

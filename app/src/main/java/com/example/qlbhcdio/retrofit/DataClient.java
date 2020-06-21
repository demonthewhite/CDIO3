package com.example.qlbhcdio.retrofit;

import com.example.qlbhcdio.model.Product;
import com.example.qlbhcdio.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DataClient {


    @POST("login")
    Call<User> LoginUser(@Query("id") String id , @Query("password") String password );

    @FormUrlEncoded
    @POST("/Register/")
    Call<String > Register (@Field("id") String id,
                            @Field("password") String password,
                            @Field("name") String name);

    @GET("products")
    Call<List<Product>> getProduct();

}

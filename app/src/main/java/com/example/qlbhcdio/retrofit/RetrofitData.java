package com.example.qlbhcdio.retrofit;




import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitData {

    public  static Retrofit mRetrofit;

    public  static Retrofit getClient(String baseURL){

        OkHttpClient builder = new OkHttpClient.Builder()
                                        .readTimeout(10000, TimeUnit.MILLISECONDS)
                                        .writeTimeout(10000,TimeUnit.MILLISECONDS)
                                        .connectTimeout(10000,TimeUnit.MILLISECONDS)
                                        .retryOnConnectionFailure(true)
                                        .build();


        Gson gson = new GsonBuilder().setLenient().create();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(builder)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return mRetrofit;
    }
}

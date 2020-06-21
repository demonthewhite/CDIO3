package com.example.qlbhcdio.presenter;

import android.util.Log;

import com.example.qlbhcdio.model.Product;
import com.example.qlbhcdio.model.User;
import com.example.qlbhcdio.retrofit.DataClient;
import com.example.qlbhcdio.retrofit.RetrofitData;
import com.example.qlbhcdio.retrofit.UserAPI;
import com.example.qlbhcdio.view.ViewLogin;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPresenter {

    ViewLogin.setOnListenerValuesText setOnListenerValuesText;
    ViewLogin.setOnLogin onLogin;

    public LoginPresenter(ViewLogin.setOnListenerValuesText setOnListenerValuesText, ViewLogin.setOnLogin onLogin) {
        this.setOnListenerValuesText = setOnListenerValuesText;
        this.onLogin = onLogin;
    }

    public boolean isLogin(String id, String password) {
        if (id.isEmpty() || id.length() < 6) {
            setOnListenerValuesText.onId("Tài khoảng không hợp lệ");
            return false;
        }
        if (password.isEmpty() || password.length() < 6) {
            setOnListenerValuesText.onPassword("Mật khẩu phải >= 6 kí tự");
            return false;
        }
        return true;
    }

    public void LoginAccount(String id, String password) {
        if (isLogin(id, password)) {
            DataClient dataClient = UserAPI.getData();
            /*dataClient.LoginUser(id, password).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Log.e("acc","into");
                    User users = response.body();
                    if (users != null ) {
                        Log.e("acc", users.getTENDN());
                        Log.e("acc", users.getMATKHAU());
                    }
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.e("acc", "no data");
                }
            });*/
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:1220/")
                    .addConverterFactory( GsonConverterFactory.create())
                    .build();
            DataClient d = retrofit.create(DataClient.class);
            Call<List<Product>> call = d.getProduct();
            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                  if(response.isSuccessful()){
                      Log.e("acc", "has data");
                  }
                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {
                    Log.e("acc", "no data");
                }
            });

        }
    }


}

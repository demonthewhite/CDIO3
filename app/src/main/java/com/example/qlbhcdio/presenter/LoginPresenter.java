package com.example.qlbhcdio.presenter;

import android.util.Log;

import com.example.qlbhcdio.model.User;
import com.example.qlbhcdio.retrofit.DataClient;
import com.example.qlbhcdio.retrofit.API;
import com.example.qlbhcdio.view.ViewLogin;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            DataClient dataClient = API.getData() ;
            dataClient.LoginUser(id,password).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User user = response.body();
                    if(user !=null){
                        onLogin.onSuccess(user);
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    onLogin.onFailed("Đăng nhập không thành công!");
                }
            });
        }
    }


}

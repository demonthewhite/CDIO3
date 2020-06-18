package com.example.qlbhcdio.Adapter.presenter;


import com.example.qlbhcdio.Adapter.view.ViewLogin;

public class LoginPresenter {

    ViewLogin.onListenLogin onListenLogin;

    public LoginPresenter(ViewLogin.onListenLogin onListenLogin) {
        this.onListenLogin = onListenLogin;
    }

    public boolean Login(String id, String password) {
        if (id.isEmpty() || id.length() < 6) {
            onListenLogin.onId("Tài khoảng không hợp lệ");
            return false;
        }
        if (password.isEmpty() || password.length() < 6) {
            onListenLogin.onPassword("Mật khẩu phải >= 6 kí tự");
            return false;
        }
        return true;
    }


}

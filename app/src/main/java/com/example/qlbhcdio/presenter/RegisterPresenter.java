package com.example.qlbhcdio.presenter;


import com.example.qlbhcdio.view.ViewRegister;

public class RegisterPresenter {

    ViewRegister.onListenRegister onListenRegister;

    public RegisterPresenter(ViewRegister.onListenRegister onListenRegister) {
        this.onListenRegister = onListenRegister;
    }

    public boolean CheckRegister(String id, String password, String cpassword, String email, boolean cb) {
        if (id.isEmpty() || id.length() < 6) {
            onListenRegister.onId("Tài khoảng không hợp lệ");
            return false;
        }
        if (password.isEmpty() || password.length() < 6) {
            onListenRegister.onPassword("Mật khẩu phải >= 6 kí tự");
            return false;
        }
        if (cpassword.isEmpty() || cpassword.length() < 6) {
            onListenRegister.onCPassword("Mật khẩu phải >= 6 kí tự");
            return false;
        }
        if (!cpassword.equals(password)) {
            onListenRegister.onCPassword("Xác nhận mật khẩu sai");
            return false;
        }
        if (!email.contains("@gmail.com")) {
            onListenRegister.onEmail("Email không hợp lệ");
            return false;
        }

        if (!cb) {
            onListenRegister.onCb("Bạn chưa chấp nhận điều khoản!");
        }
        return true;
    }


}

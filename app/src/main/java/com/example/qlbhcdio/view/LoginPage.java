package com.example.qlbhcdio.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.qlbhcdio.R;
import com.example.qlbhcdio.presenter.LoginPresenter;

public class LoginPage extends AppCompatActivity implements View.OnClickListener, ViewLogin.onListenLogin {
    private LoginPresenter loginPresenter;
    Button btnSignIn;
    Button btnRegister;
    EditText edtID, edtPassword;
    TextView tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        init();
        loginPresenter = new LoginPresenter(this);
        btnSignIn.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);


    }

    void init() {
        btnSignIn = findViewById(R.id.btnDangNhap);
        btnRegister = findViewById(R.id.btnDangKy);
        edtID = findViewById(R.id.edtTaiKhoan);
        edtPassword = findViewById(R.id.edtMatKhau);
        tvForgotPassword = findViewById(R.id.tvQuenMatKhau);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDangKy:
                goActivity(RegisterPage.class);
                break;
            case R.id.btnDangNhap:
                break;
            case R.id.tvQuenMatKhau:
                break;
        }
    }

    void LoginUser(String id, String password) {
        if (loginPresenter.Login(id, password)) {
            goActivity(HomePage.class);
        }
    }

    void goActivity(Class t) {
        Intent intent = new Intent(LoginPage.this, t);
        startActivity(intent);
    }

    @Override
    public void onId(String id) {
        edtID.setError(id);
    }

    @Override
    public void onPassword(String password) {
        edtPassword.setError(password);
    }
}

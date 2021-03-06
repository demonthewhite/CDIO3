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

public class LoginPage extends AppCompatActivity implements View.OnClickListener,
        ViewLogin.setOnListenerValuesText,ViewLogin.setOnLogin {

    private LoginPresenter loginPresenter;
    private Button btnSignIn;
    private Button btnRegister;
    private EditText edtID, edtPassword;
    private TextView tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        init();
        loginPresenter = new LoginPresenter(this,this);
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
                    LoginUser(edtID.getText().toString(),edtPassword.getText().toString());
                break;
            case R.id.tvQuenMatKhau:
                break;
        }
    }

    void LoginUser(String id, String password) {
        loginPresenter.LoginAccount(id,password);
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

    @Override
    public void onSuccess(String s) {

    }

    @Override
    public void onFailed(String s) {

    }
}

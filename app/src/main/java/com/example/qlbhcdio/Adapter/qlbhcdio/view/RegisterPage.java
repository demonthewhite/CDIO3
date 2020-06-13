package com.example.qlbhcdio.Adapter.qlbhcdio.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.qlbhcdio.Adapter.qlbhcdio.presenter.RegisterPresenter;
import com.example.qlbhcdio.R;

public class RegisterPage extends AppCompatActivity implements View.OnClickListener, ViewRegister.onListenRegister {
    EditText edtID, edtPassword, edtCPassword, edtEmail;
    CheckBox cbDieuKhoan;
    Button btnRegister;
    private RegisterPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        init();
        presenter = new RegisterPresenter(this);
        btnRegister.setOnClickListener(this);


    }

    private void init() {
        edtID = findViewById(R.id.edtDKTaiKhoan);
        edtPassword = findViewById(R.id.edtDKMatKhau);
        edtCPassword = findViewById(R.id.edtDKXacNhanMatKhau);
        edtEmail = findViewById(R.id.edtDKEmail);
        cbDieuKhoan = findViewById(R.id.cbChapNhanDK);
        btnRegister = findViewById(R.id.btnDKDangKy);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDKDangKy:
                Register();
                break;
        }
    }

    void Register() {
       if(presenter.CheckRegister(edtID.getText().toString()
                , edtPassword.getText().toString()
                , edtCPassword.getText().toString()
                , edtEmail.getText().toString()
                ,cbDieuKhoan.isSelected())) {
           Toast.makeText(RegisterPage.this,"Đăng ký thành công !",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onId(String s) {
        edtID.setError(s);
    }

    @Override
    public void onPassword(String s) {
        edtPassword.setError(s);
    }

    @Override
    public void onCPassword(String s) {
        edtCPassword.setError(s);
    }

    @Override
    public void onEmail(String s) {
        edtEmail.setError(s);
    }

    @Override
    public void onCb(String s) {
        Toast.makeText(RegisterPage.this, s, Toast.LENGTH_SHORT).show();
    }
}

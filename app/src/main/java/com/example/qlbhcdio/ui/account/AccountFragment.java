package com.example.qlbhcdio.ui.account;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.qlbhcdio.R;
import com.example.qlbhcdio.model.User;
import com.google.android.material.textfield.TextInputEditText;

public class AccountFragment extends Fragment implements View.OnClickListener{

    private AccountViewModel mViewModel;
    private User userCurrent;
    private TextView mName;
    private TextInputEditText mPassword,mAddress,mNumPhone;
    private Button btnEdit,btnSave;

    public AccountFragment(User user) {
        this.userCurrent = user;
    }

    public AccountFragment() {

    }

    public static AccountFragment newInstance() {
        return new AccountFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.account_fragment, container, false);
        mName = view.findViewById(R.id.tv_name_profile);
        mAddress = view.findViewById(R.id.edt_address);
        mPassword = view.findViewById(R.id.edt_password);
        mNumPhone = view.findViewById(R.id.edt_numPhone);
        btnEdit = view.findViewById(R.id.btn_edit);
        btnSave = view.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
        return view;
    }

    private void setup() {
        mName.setText(userCurrent.getName());
        mNumPhone.setText(userCurrent.getNumPhone());
        mPassword.setText(userCurrent.getPassword());
        mAddress.setText(userCurrent.getAddress());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AccountViewModel.class);
        setup();
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_edit :onEditAndSave(true) ;
                break;

            case R.id.btn_save : onEditAndSave(false) ;
                break;
        }
    }
    void onEditAndSave(boolean b){
        mNumPhone.setEnabled(b);
        mPassword.setEnabled(b);
        mAddress.setEnabled(b);
        if(b){
            // todo handle API
            btnSave.setVisibility(View.VISIBLE);
            btnEdit.setVisibility(View.INVISIBLE);
        }else {
            btnSave.setVisibility(View.INVISIBLE);
            btnEdit.setVisibility(View.VISIBLE);
        }

    }


}
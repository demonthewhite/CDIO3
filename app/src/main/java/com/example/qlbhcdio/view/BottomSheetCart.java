package com.example.qlbhcdio.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlbhcdio.Adapter.CartAdapter;
import com.example.qlbhcdio.R;
import com.example.qlbhcdio.model.MessengerRes;
import com.example.qlbhcdio.model.Product;
import com.example.qlbhcdio.model.User;
import com.example.qlbhcdio.retrofit.API;
import com.example.qlbhcdio.retrofit.DataClient;
import com.example.qlbhcdio.ui.account.AccountViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BottomSheetCart extends BottomSheetDialogFragment implements CartAdapter.setOnClickItemCart, View.OnClickListener {

    private RecyclerView recyclerView_Cart;
    private List<Product> mCart = new ArrayList<>();
    private CartAdapter mAdapter;
    private Button btn_delivery;
    private User userCurrent;

    public BottomSheetCart(User userCurrent) {
        this.userCurrent = userCurrent;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_bottomsheet, container, false);
        recyclerView_Cart = view.findViewById(R.id.rcl_cart);
        btn_delivery = view.findViewById(R.id.btn_delivery);
        btn_delivery.setOnClickListener(this);
        mAdapter = new CartAdapter(getContext(), mCart, this);
        recyclerView_Cart.setAdapter(mAdapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView_Cart.setLayoutManager(manager);
        return view;
    }

    public void setOnDataListener(Product product) {
        if (mCart.contains(product)) {
            int index = mCart.indexOf(product);
            mCart.get(index).incrementAmount();
        } else {
            mCart.add(product);
        }
    }

    @Override
    public void onClickDelete(int position) {
        mCart.remove(position);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_delivery:
                String json = new Gson().toJson(mCart);
                DataClient dataClient = API.getData();
                dataClient.newDetails(userCurrent.getName(), "2020-6-22", json).enqueue(new Callback<MessengerRes>() {
                    @Override
                    public void onResponse(Call<MessengerRes> call, Response<MessengerRes> response) {
                        Log.e("res",response.body().getMessage());
                    }

                    @Override
                    public void onFailure(Call<MessengerRes> call, Throwable t) {

                    }
                });
        }
    }
}

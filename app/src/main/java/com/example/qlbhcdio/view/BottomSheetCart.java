package com.example.qlbhcdio.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlbhcdio.Adapter.CartAdapter;
import com.example.qlbhcdio.R;
import com.example.qlbhcdio.model.Product;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetCart extends BottomSheetDialogFragment implements CartAdapter.setOnClickItemCart {

    private RecyclerView recyclerView_Cart;
    private List<Product> mCart = new ArrayList<>();
    private CartAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_bottomsheet, container, false);
        recyclerView_Cart = view.findViewById(R.id.rcl_cart);
        mAdapter = new CartAdapter(getContext(), mCart, this);
        recyclerView_Cart.setAdapter(mAdapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView_Cart.setLayoutManager(manager);
        return view;
    }

    public void setOnDataListener(HomePage homePage) {
        Product product = homePage.product;
        mCart.add(product);
    }


    @Override
    public void onClickDelete(int position) {
        mCart.remove(position);
        mAdapter.notifyDataSetChanged();
    }

}

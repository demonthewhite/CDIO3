package com.example.qlbhcdio.ui.shop;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qlbhcdio.Adapter.FavoriteAdapter;
import com.example.qlbhcdio.Adapter.GirdAdapter;
import com.example.qlbhcdio.Adapter.KindAdapter;
import com.example.qlbhcdio.R;
import com.example.qlbhcdio.model.Product;
import com.example.qlbhcdio.model.MyGirdView;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment implements GirdAdapter.SelectedItem {

    private ShopViewModel mViewModel;

    private RecyclerView mKindFish;
    private RecyclerView mFavorite;
    private MyGirdView mGirdView;

    private KindAdapter mKindAdapter;
    private FavoriteAdapter mFavoriteAdapter;
    private GirdAdapter mGirdAdapter;
    private List<Product> mProduct = new ArrayList<>();
    private SendItemToGirdAdapter sendItemToGirdAdapter;

    public ShopFragment(SendItemToGirdAdapter sendItemToGirdAdapter) {
        this.sendItemToGirdAdapter = sendItemToGirdAdapter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_fragment, container, false);
        listAdd();
        mKindFish = view.findViewById(R.id.rcl_kindfish);
        mFavorite = view.findViewById(R.id.rcl_favorite);
        mGirdView = view.findViewById(R.id.gird_sellFish);

        mKindAdapter = new KindAdapter(getContext());
        mFavoriteAdapter = new FavoriteAdapter(getContext());
        mGirdAdapter = new GirdAdapter(mProduct, getContext(), this);

        mKindFish.setAdapter(mKindAdapter);
        mFavorite.setAdapter(mFavoriteAdapter);
        mGirdView.setAdapter(mGirdAdapter);

        RecyclerView.LayoutManager mLayoutManagerKindFish = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, true);
        mKindFish.setLayoutManager(mLayoutManagerKindFish);
        RecyclerView.LayoutManager mLayoutManagerFavorite = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, true);
        mFavorite.setLayoutManager(mLayoutManagerFavorite);
        return view;
    }

    private void listAdd() {
        mProduct.add(new Product("1", "Cá Chim", "", 4));
        mProduct.add(new Product("2", "Cá Chuồng", "", 8));
        mProduct.add(new Product("3", "Cá Hồi", "", 6));
        mProduct.add(new Product("4", "Cá Ngừ", "", 5));
        mProduct.add(new Product("5", "Cá Lóc", "", 7));
        mProduct.add(new Product("6", "Tôm", "", 10));
        mProduct.add(new Product("7", "Cua Hoàng Đế", "", 50));
        mProduct.add(new Product("8", "Mực", "", 12));
        mProduct.add(new Product("9", "Bạch Tuộc", "", 10));
        mProduct.add(new Product("10", "Cá Cơm", "", 5));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShopViewModel.class);
        // TODO: Use the ViewModel;
    }


    @Override
    public void onSelect(int position) {
        //Todo add cart
        sendItemToGirdAdapter.OnSend(mGirdAdapter.getItem(position));
    }

    // gửi item tới girdViewAdapter
    public interface SendItemToGirdAdapter {
        void OnSend(Product fish);
    }
}
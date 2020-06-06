package com.example.qlbhcdio.Adapter.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlbhcdio.Adapter.Adapter.FavoriteAdapter;
import com.example.qlbhcdio.Adapter.Adapter.GirdViewSellAdapter;
import com.example.qlbhcdio.Adapter.Adapter.KindFishAdapter;
import com.example.qlbhcdio.Adapter.ui.component.MyGirdView;
import com.example.qlbhcdio.R;

public class ShopFragment extends Fragment {

    private ShopViewModel mViewModel;

    private RecyclerView mKindFish;
    private RecyclerView mFavorite;
    private MyGirdView mGridViewSell;

    private KindFishAdapter kindFishAdapter;
    private FavoriteAdapter favoriteAdapter;
    private GirdViewSellAdapter viewSellAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_fragment, container, false);

        mKindFish = view.findViewById(R.id.rcl_kindfish);
        mFavorite = view.findViewById(R.id.rcl_favorite);
        mGridViewSell =  view.findViewById(R.id.gird_sellFish);

        kindFishAdapter = new KindFishAdapter(getContext());
        favoriteAdapter = new FavoriteAdapter(getContext());
        viewSellAdapter = new GirdViewSellAdapter(getContext());

        mKindFish.setAdapter(kindFishAdapter);
        mFavorite.setAdapter(favoriteAdapter);
        mGridViewSell.setAdapter(viewSellAdapter);

        RecyclerView.LayoutManager mLayoutManagerKindFish = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, true);
        mKindFish.setLayoutManager(mLayoutManagerKindFish);
        RecyclerView.LayoutManager mLayoutManagerFavorite = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, true);
        mFavorite.setLayoutManager(mLayoutManagerFavorite);




        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShopViewModel.class);
        // TODO: Use the ViewModel


    }

    public static ShopFragment newInstance() {
        return new ShopFragment();
    }
}
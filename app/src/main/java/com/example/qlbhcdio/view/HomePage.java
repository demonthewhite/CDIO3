package com.example.qlbhcdio.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.qlbhcdio.Adapter.ViewPageAdapter;
import com.example.qlbhcdio.R;
import com.example.qlbhcdio.model.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomePage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
        , ViewPager.OnPageChangeListener
        , View.OnClickListener
        , ViewPageAdapter.SendItemToHomePage {

    private BottomNavigationView mBottomNav;
    private ViewPager mViewPager;
    private ViewPageAdapter adapter;
    private FloatingActionButton floatButton;
    private BottomSheetCart bottomSheetCart;
    public Product product;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
        mViewPager = findViewById(R.id.view_page);
        mBottomNav = findViewById(R.id.bottom_navigation);
        floatButton = findViewById(R.id.float_button_cart);

        bottomSheetCart = new BottomSheetCart();

        mBottomNav.setOnNavigationItemSelectedListener(this);
        mViewPager.setOnPageChangeListener(this);
        floatButton.setOnClickListener(this);

        adapter = new ViewPageAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(adapter);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_history:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.action_account:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.action_setting:
                mViewPager.setCurrentItem(3);
                break;
            case R.id.action_shop:
                mViewPager.setCurrentItem(0);
            default:
        }
        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                floatButton.setVisibility(View.VISIBLE);
                mBottomNav.setSelectedItemId(R.id.action_shop);
                break;
            case 1:
                floatButton.setVisibility(View.INVISIBLE);
                mBottomNav.setSelectedItemId(R.id.action_history);
                break;
            case 2:
                mBottomNav.setSelectedItemId(R.id.action_account);
                floatButton.setVisibility(View.INVISIBLE);
                break;
            case 3:
                floatButton.setVisibility(View.INVISIBLE);
                mBottomNav.setSelectedItemId(R.id.action_setting);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.float_button_cart:
                if (bottomSheetCart.isAdded()) {
                    return;
                }
                bottomSheetCart.show(getSupportFragmentManager(), "BottomSheetBuy");
                break;
        }
    }

    @Override
    public void onSend(Product fish) {
        //TOdo pass data to bottom sheet
        product = fish;
        bottomSheetCart.setOnDataListener(HomePage.this);
    }


}

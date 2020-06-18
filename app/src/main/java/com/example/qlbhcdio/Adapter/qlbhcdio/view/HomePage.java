package com.example.qlbhcdio.Adapter.qlbhcdio.view;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.qlbhcdio.Adapter.qlbhcdio.Adapter.ViewPageAdapter;
import com.example.qlbhcdio.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private BottomNavigationView mBottomNav;
    private ViewPager mViewPager;
    private ViewPageAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
        mViewPager = findViewById(R.id.view_page);
        mBottomNav = findViewById(R.id.bottom_navigation);

        mBottomNav.setOnNavigationItemSelectedListener(this);
        mViewPager.setOnPageChangeListener(this);

        adapter = new ViewPageAdapter(getSupportFragmentManager());
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
        Log.e("check",String.valueOf(position));
        switch (position){
            case 0: mBottomNav.setSelectedItemId(R.id.action_shop);  break;
            case 1: mBottomNav.setSelectedItemId(R.id.action_history); break;
            case 2: mBottomNav.setSelectedItemId(R.id.action_account); break;
            case 3: mBottomNav.setSelectedItemId(R.id.action_setting); break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

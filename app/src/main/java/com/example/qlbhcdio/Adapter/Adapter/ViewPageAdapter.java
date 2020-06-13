package com.example.qlbhcdio.Adapter.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.qlbhcdio.Adapter.ui.account.AccountFragment;
import com.example.qlbhcdio.Adapter.ui.history.HistoryFragment;
import com.example.qlbhcdio.Adapter.ui.home.ShopFragment;
import com.example.qlbhcdio.Adapter.ui.settings.SettingFragment;

public class ViewPageAdapter extends FragmentStatePagerAdapter {

    public ViewPageAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ShopFragment();
            case 1:
                return new HistoryFragment();
            case 2:
                return new AccountFragment();
            case 3:
                return new SettingFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

}

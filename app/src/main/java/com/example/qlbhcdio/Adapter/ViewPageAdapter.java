package com.example.qlbhcdio.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.qlbhcdio.model.Product;
import com.example.qlbhcdio.model.User;
import com.example.qlbhcdio.ui.account.AccountFragment;
import com.example.qlbhcdio.ui.history.HistoryFragment;
import com.example.qlbhcdio.ui.shop.ShopFragment;
import com.example.qlbhcdio.ui.settings.SettingFragment;

public class ViewPageAdapter extends FragmentStatePagerAdapter implements ShopFragment.SendItemToGirdAdapter {
    private SendItemToHomePage itemToHomePage;
    private User userCurrent;

    public ViewPageAdapter(@NonNull FragmentManager fm, SendItemToHomePage itemToHomePage,User userCurrent) {
        super(fm);
        this.itemToHomePage = itemToHomePage;
        this.userCurrent = userCurrent;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ShopFragment(this);
            case 1:
                return new HistoryFragment();
            case 2:
                return new AccountFragment(userCurrent);
            case 3:
                return new SettingFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public void OnSend(Product fish) {
        itemToHomePage.onSend(fish);
    }

    // gửi item tới Home
    public interface SendItemToHomePage {
        void onSend(Product fish);
    }
}

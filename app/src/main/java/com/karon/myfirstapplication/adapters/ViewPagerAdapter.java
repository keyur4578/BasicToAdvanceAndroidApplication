package com.karon.myfirstapplication.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.karon.myfirstapplication.fragments.HomeFragment;
import com.karon.myfirstapplication.fragments.SettingsFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0)
        {
            return new HomeFragment();
        }
        else
        {
            return new SettingsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

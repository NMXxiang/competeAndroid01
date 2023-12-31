package com.example.test.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] titleName;

    public ViewPagerAdapter(@NonNull FragmentManager fm,  List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return  fragments.get(position);

    }

    @Override
    public int getCount() {
        return  fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleName[position];
    }
}

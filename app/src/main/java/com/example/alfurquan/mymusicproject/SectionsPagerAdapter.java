package com.example.alfurquan.mymusicproject;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mfragmentList=new ArrayList<>();
    private final List<String> mtitles = new ArrayList<>();
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
         return mfragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mtitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mtitles.get(position);
    }

    public void addFragment(Fragment fragment,String titke){
        mfragmentList.add(fragment);
        mtitles.add(titke);
    }
}

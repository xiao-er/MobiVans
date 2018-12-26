package com.app.mobivans.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @author: 潇潇
 * @create on:  2018/12/12
 * @describe:DOTO
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int arg0) {

        return list.get(arg0);
    }


}
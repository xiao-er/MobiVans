package com.app.mobivans.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.mobivans.R;


/**
 * @author: 潇潇
 * @create on:  2018/12/7
 * @describe:发现页
 */

public class DiscoveryFragment extends BaseFragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_discovery, container, false);
        return view;
    }




}

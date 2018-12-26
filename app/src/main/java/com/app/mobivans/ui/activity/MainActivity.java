package com.app.mobivans.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.app.mobivans.R;
import com.app.mobivans.adapter.MyFragmentPagerAdapter;
import com.app.mobivans.customerview.MyViewPager;
import com.app.mobivans.ui.fragment.DiscoveryFragment;
import com.app.mobivans.ui.fragment.HomeFragment;
import com.app.mobivans.ui.fragment.MyFragment;
import com.app.mobivans.ui.fragment.ShoppingCartFragment;
import com.app.mobivans.utils.AppCommon;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout mainBarHome, mainBarDiscovery, mainBarShoppingCart, mainBarMy;
    private ImageView imgMainHome, imgMainDiscovery, imgMainShopCart, imgMainMy;
    private TextView txtMainHome, txtMainDiscovery, txtMainShopCart, txtMainMy;
    private HomeFragment fragmentHome;
    private DiscoveryFragment fragmentDiscovery;
    private ShoppingCartFragment fragmentShopCart;
    private MyFragment fragmentMy;
    private MyViewPager myViewpage;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    //默认选中的底部导航栏,默认选中首页
    private int currentItem = AppCommon.MainActivitys.PAGE_HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFindview();
        initObj();
        init();
        initViewPager();
        setListener();
    }


    /**
     * 初始化控件
     */
    private void myFindview() {
        mainBarHome = findViewById(R.id.main_bar_home);
        mainBarDiscovery = findViewById(R.id.main_bar_discovery);
        mainBarShoppingCart = findViewById(R.id.main_bar_shopping_cart);
        mainBarMy = findViewById(R.id.main_bar_my);
        imgMainHome = findViewById(R.id.img_main_home);
        imgMainDiscovery = findViewById(R.id.img_main_discovery);
        imgMainShopCart = findViewById(R.id.img_main_shop_cart);
        imgMainMy = findViewById(R.id.img_main_my);
        txtMainHome = findViewById(R.id.txt_main_home);
        txtMainDiscovery = findViewById(R.id.txt_main_discovery);
        txtMainShopCart = findViewById(R.id.txt_main_shop_cart);
        txtMainMy = findViewById(R.id.txt_main_my);
        myViewpage = findViewById(R.id.myViewpage);
    }

    /**
     * 设置监听事件
     */
    private void setListener() {
        mainBarHome.setOnClickListener(this);
        mainBarDiscovery.setOnClickListener(this);
        mainBarShoppingCart.setOnClickListener(this);
        mainBarMy.setOnClickListener(this);
    }


    /**
     * 初始化状态或者数据
     */
    private void init() {
        setTabTextColor(currentItem);
    }


    /**
     * 初始化对象
     */
    private void initObj() {
        fragmentHome = new HomeFragment();
        fragmentDiscovery = new DiscoveryFragment();
        fragmentShopCart = new ShoppingCartFragment();
        fragmentMy = new MyFragment();
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_bar_home://首页
                currentItem = AppCommon.MainActivitys.PAGE_HOME;
                break;
            case R.id.main_bar_discovery://发现
                currentItem = AppCommon.MainActivitys.PAGE_DISCOVERY;
                break;
            case R.id.main_bar_shopping_cart://购物车
                currentItem = AppCommon.MainActivitys.PAGE_SHOP_CART;
                break;
            case R.id.main_bar_my://我的
                currentItem = AppCommon.MainActivitys.PAGE_HMY;
                break;
        }
        setTabTextColor(currentItem);
        myViewpage.setCurrentItem(currentItem, false);
    }


    /**
     * 底部导航栏点击切换状态
     */
    private void setTabTextColor(int currentItem) {
        initTabTextColor();
        switch (currentItem) {
            case AppCommon.MainActivitys.PAGE_HOME://首页
                txtMainHome.setTextColor(getResources().getColor(R.color.color_d4237a));
                imgMainHome.setImageResource(R.mipmap.home2);
                break;
            case AppCommon.MainActivitys.PAGE_DISCOVERY://发现
                txtMainDiscovery.setTextColor(getResources().getColor(R.color.color_d4237a));
                imgMainDiscovery.setImageResource(R.mipmap.home2);
                break;
            case AppCommon.MainActivitys.PAGE_SHOP_CART://购物车
                txtMainShopCart.setTextColor(getResources().getColor(R.color.color_d4237a));
                imgMainShopCart.setImageResource(R.mipmap.home2);
                break;
            case AppCommon.MainActivitys.PAGE_HMY://我的
                txtMainMy.setTextColor(getResources().getColor(R.color.color_d4237a));
                imgMainMy.setImageResource(R.mipmap.home2);
                break;
        }
    }


    /**
     * 初始化底部导航栏
     */
    private void initTabTextColor() {
        //首页
        txtMainHome.setTextColor(getResources().getColor(R.color.color_2c2c2c));
        imgMainHome.setImageResource(R.mipmap.home1);
        //发现
        txtMainDiscovery.setTextColor(getResources().getColor(R.color.color_2c2c2c));
        imgMainDiscovery.setImageResource(R.mipmap.home1);
        //购物车
        txtMainShopCart.setTextColor(getResources().getColor(R.color.color_2c2c2c));
        imgMainShopCart.setImageResource(R.mipmap.home1);
        //我的
        txtMainMy.setTextColor(getResources().getColor(R.color.color_2c2c2c));
        imgMainMy.setImageResource(R.mipmap.home1);
    }


    /**
     * 绑定viewpager
     */
    private void initViewPager() {
        MyViewPager viewPager = (MyViewPager) findViewById(R.id.myViewpage);
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(fragmentHome);
        fragments.add(fragmentDiscovery);
        fragments.add(fragmentShopCart);
        fragments.add(fragmentMy);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager(), fragments);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setCurrentItem(currentItem);
        viewPager.setOffscreenPageLimit(4);
        setTabTextColor(currentItem);
    }


}

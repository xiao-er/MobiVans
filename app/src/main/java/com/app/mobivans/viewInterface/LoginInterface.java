package com.app.mobivans.viewInterface;

/**
 * @author: 潇潇
 * @create on:  2018/12/6
 * @describe:登录使用的接口
 */

public interface LoginInterface {


    interface View {
        void setData(String str);
    }


    interface Presenter {
        void loadData();
    }

}

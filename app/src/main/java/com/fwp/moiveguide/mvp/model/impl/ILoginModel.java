package com.fwp.moiveguide.mvp.model.impl;

import android.content.Context;

import com.fwp.moiveguide.bean.User;

/**
 * Created by Administrator on 2018/1/4.
 */
public interface ILoginModel {
    User login (String username, String password);

    boolean register(String username,String password);

    boolean saveLoginInfo(Context context,User user);
}

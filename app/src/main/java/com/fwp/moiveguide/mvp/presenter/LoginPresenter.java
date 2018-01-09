package com.fwp.moiveguide.mvp.presenter;

import android.content.Context;

import com.fwp.moiveguide.bean.User;
import com.fwp.moiveguide.mvp.model.LoginModel;
import com.fwp.moiveguide.mvp.model.impl.ILoginModel;

import org.xutils.DbManager;

/**
 * Created by Administrator on 2018/1/4.
 */
public class LoginPresenter {

    private ILoginModel loginModel;

    public LoginPresenter(DbManager.DaoConfig daoConfig){
        loginModel = new LoginModel(daoConfig);
    }

    public User login(String username, String password){
        return loginModel.login(username,password);
    }

    /**
     * 注册
     * @param username 账号
     * @param password 密码
     */
    public boolean register(String username,String password){
        return loginModel.register(username,password);
    }

    public boolean saveLoginInfo(Context context,User user){
        return loginModel.saveLoginInfo(context,user);
    }

}

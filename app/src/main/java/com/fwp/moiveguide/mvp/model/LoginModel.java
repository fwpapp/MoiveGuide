package com.fwp.moiveguide.mvp.model;

import android.content.Context;
import android.util.Log;

import com.fwp.moiveguide.bean.User;
import com.fwp.moiveguide.mvp.model.impl.ILoginModel;
import com.fwp.moiveguide.utils.SharedConfig;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2018/1/4.
 */
public class LoginModel implements ILoginModel {

    private DbManager dbManager;

    public LoginModel(DbManager.DaoConfig daoConfig){
        dbManager = x.getDb(daoConfig);
    }

    @Override
    public User login(String username, String password) {
        try {
            User user = dbManager.selector(User.class).where("username","=",username).and("password","=",password).findFirst();
            return user;
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean register(String username, String password) {
        try {
            List<User> list = dbManager.selector(User.class).where("username","=",username).findAll();
            if (list != null){
                if (list.size() > 0){
                    return false;
                }
            }else {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                dbManager.save(user);
                return true;
            }
        } catch (DbException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 保存登录后的信息
     * @param context
     * @param user 当前用户
     * @return
     */
    @Override
    public boolean saveLoginInfo(Context context,User user) {
        try {
            SharedConfig.getInstance(context).setIntValue("isLogin",1);
            SharedConfig.getInstance(context).setIntValue("userId",user.getId());
            SharedConfig.getInstance(context).setStringValue("username",user.getUsername());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}

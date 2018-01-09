package com.fwp.moiveguide.mvp.model;

import android.content.Context;

import com.fwp.moiveguide.mvp.model.impl.IUserDataModel;
import com.fwp.moiveguide.utils.SharedConfig;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by Administrator on 2018/1/9.
 */
public class UserDataModel implements IUserDataModel {

    private DbManager dbManager;
    private Context context;

    public UserDataModel(DbManager.DaoConfig daoConfig,Context context){
        dbManager = x.getDb(daoConfig);
        this.context = context;
    }

    @Override
    public boolean logout() {
        try {
            SharedConfig.getInstance(context).setIntValue("isLogin",0);
            SharedConfig.getInstance(context).setIntValue("userId",-1);
            SharedConfig.getInstance(context).setStringValue("username","");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}

package com.fwp.moiveguide.mvp.presenter;

import android.content.Context;

import com.fwp.moiveguide.mvp.model.UserDataModel;
import com.fwp.moiveguide.mvp.model.impl.IUserDataModel;

import org.xutils.DbManager;

/**
 * Created by Administrator on 2018/1/9.
 */
public class UserDataPresenter {

    private Context context;
    private DbManager.DaoConfig daoConfig;
    private IUserDataModel iUserDataModel;

    public UserDataPresenter(Context context,DbManager.DaoConfig daoConfig){
        this.context = context;
        iUserDataModel = new UserDataModel(daoConfig,context);
    }

    public boolean logout(){
        return iUserDataModel.logout();
    }

}

package com.fwp.moiveguide.mvp.presenter;

import android.content.Context;

import com.fwp.moiveguide.mvp.model.UserDataModel;
import com.fwp.moiveguide.mvp.model.impl.IUserDataModel;
import com.fwp.moiveguide.mvp.view.impl.IDataView;

import org.xutils.DbManager;

/**
 * Created by Administrator on 2018/1/9.
 */
public class UserDataPresenter {

    private Context context;
    private DbManager.DaoConfig daoConfig;
    private IUserDataModel iUserDataModel;
    private IDataView iDataView;

    public UserDataPresenter(Context context,DbManager.DaoConfig daoConfig,IDataView iDataView){
        this.context = context;
        iUserDataModel = new UserDataModel(daoConfig,context);
        this.iDataView = iDataView;
    }

    public boolean logout(){
        return iUserDataModel.logout();
    }

    public void showUserName(int id){
        String name =  iUserDataModel.findUserName(id);
        iDataView.showUserName(name);
    }

}

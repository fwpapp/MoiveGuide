package com.fwp.moiveguide.mvp.presenter;

import android.text.TextUtils;

import com.fwp.moiveguide.bean.User;
import com.fwp.moiveguide.mvp.model.MineModel;
import com.fwp.moiveguide.mvp.model.impl.IMineModel;
import com.fwp.moiveguide.mvp.view.impl.IMineView;

import org.xutils.DbManager;
import org.xutils.config.DbConfigs;

/**
 * Created by Administrator on 2018/1/8.
 */
public class MinePresenter {

    private IMineView iMineView;
    private IMineModel iMineModel;
    private DbManager.DaoConfig dbConfigs;

    public MinePresenter(DbManager.DaoConfig dbConfigs,IMineView iMineView){
        this.dbConfigs = dbConfigs;
        this.iMineView = iMineView;
        iMineModel = new MineModel(dbConfigs);
    }

    public void findCurrUesr(int id){
        User user = iMineModel.findCurrUser(id);
        if (user != null){
            if (TextUtils.isEmpty(user.getNickname())){
                iMineView.showCurrUser(user.getUsername());
            }else {
                iMineView.showCurrUser(user.getNickname());
            }
        }
    }

}

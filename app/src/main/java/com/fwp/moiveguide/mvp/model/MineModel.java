package com.fwp.moiveguide.mvp.model;

import com.fwp.moiveguide.bean.User;
import com.fwp.moiveguide.mvp.model.impl.IMineModel;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

/**
 * Created by Administrator on 2018/1/8.
 */
public class MineModel implements IMineModel {

    private DbManager dbManager;

    public MineModel(DbManager.DaoConfig daoConfig){
        dbManager = x.getDb(daoConfig);
    }

    @Override
    public User findCurrUser(int id) {
        try {
            return dbManager.selector(User.class).where("id","=",id).findFirst();
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }
}

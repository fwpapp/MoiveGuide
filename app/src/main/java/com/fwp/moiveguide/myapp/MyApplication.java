package com.fwp.moiveguide.myapp;

import android.app.Application;

import org.xutils.DbManager;

import java.io.File;

/**
 * Created by Administrator on 2018/1/4.
 */
public class MyApplication extends Application {

    private static DbManager.DaoConfig daoConfig;
    private DbManager dbManager;

    @Override
    public void onCreate() {
        super.onCreate();
        initDBConfig();
    }

    private void initDBConfig() {
        daoConfig = new DbManager.DaoConfig()
                .setDbName("moiveguide.db")
                .setDbVersion(1)
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        // TODO 数据库更新操作
                    }
                })
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        db.getDatabase().enableWriteAheadLogging();
                    }
                })
                .setDbDir(new File(getApplicationContext().getFilesDir().getAbsolutePath()+"/db_files"))
                .setAllowTransaction(true);
    }

    public static DbManager.DaoConfig getDbConfigs() {
        return daoConfig;
    }
}

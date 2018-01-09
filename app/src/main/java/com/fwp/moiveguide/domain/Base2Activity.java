package com.fwp.moiveguide.domain;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.fwp.moiveguide.R;
import com.fwp.moiveguide.myapp.MyApplication;

import org.xutils.DbManager;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by Administrator on 2018/1/3.
 */
public class Base2Activity extends SwipeBackActivity {

    MyApplication app;
    DbManager.DaoConfig daoConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.main_color));
        }

        app = (MyApplication) getApplication();
        daoConfig = app.getDbConfigs();
    }

    public void toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}

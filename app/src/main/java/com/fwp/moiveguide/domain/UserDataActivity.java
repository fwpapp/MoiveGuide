package com.fwp.moiveguide.domain;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fwp.moiveguide.R;
import com.fwp.moiveguide.bean.User;
import com.fwp.moiveguide.event.LoginEvent;
import com.fwp.moiveguide.mvp.presenter.UserDataPresenter;
import com.fwp.moiveguide.mvp.view.impl.IDataView;
import com.fwp.moiveguide.utils.SharedConfig;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2018/1/9.
 */
public class UserDataActivity extends Base2Activity implements View.OnClickListener,IDataView {

    private TextView tvLogout,tvName;
    private RelativeLayout rlBack,rlHeader;
    private UserDataPresenter userDataPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdata);
        init();
    }

    private void init() {
        tvLogout = (TextView) findViewById(R.id.tv_logout);
        rlBack = (RelativeLayout) findViewById(R.id.rl_back);
        rlHeader = (RelativeLayout) findViewById(R.id.rl_header);
        tvName = (TextView) findViewById(R.id.tv_name);

        tvLogout.setOnClickListener(this);
        rlBack.setOnClickListener(this);
        rlHeader.setOnClickListener(this);

        userDataPresenter = new UserDataPresenter(this,app.getDbConfigs(),this);

        try {
            userDataPresenter.showUserName(SharedConfig.getInstance(this).getIntValue("userId",-1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_logout:
                userDataPresenter.logout();
                User user = new User();
                user.setUsername("");
                user.setPassword("");
                EventBus.getDefault().post(new LoginEvent(user));
                finish();
                break;
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_header:
                // 点击可换头像
                break;
        }

    }

    @Override
    public void showUserName(String name) {
        tvName.setText(name);
    }
}

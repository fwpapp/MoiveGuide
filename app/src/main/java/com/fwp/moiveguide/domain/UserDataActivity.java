package com.fwp.moiveguide.domain;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fwp.moiveguide.R;
import com.fwp.moiveguide.bean.User;
import com.fwp.moiveguide.event.LoginEvent;
import com.fwp.moiveguide.mvp.presenter.UserDataPresenter;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2018/1/9.
 */
public class UserDataActivity extends Base2Activity implements View.OnClickListener {

    private TextView tvLogout;
    private UserDataPresenter userDataPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdata);
        init();
    }

    private void init() {
        tvLogout = (TextView) findViewById(R.id.tv_logout);

        tvLogout.setOnClickListener(this);

        userDataPresenter = new UserDataPresenter(this,app.getDbConfigs());
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
        }

    }
}

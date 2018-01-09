package com.fwp.moiveguide.domain;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.fwp.moiveguide.R;
import com.fwp.moiveguide.adapter.LoginPagerAdapter;
import com.fwp.moiveguide.event.LoginEvent;
import com.fwp.moiveguide.fragment.LoginFragment;
import com.fwp.moiveguide.fragment.RegisterFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/3.
 */
public class LoginActivity extends Base2Activity implements View.OnClickListener {

    private RelativeLayout rlBack;
    private ViewPager viewPager;

    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EventBus.getDefault().register(this);//订阅
        init();
    }

    private void init() {
        rlBack = (RelativeLayout) findViewById(R.id.rl_back);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        rlBack.setOnClickListener(this);

        loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();

        fragments = new ArrayList<>();
        fragments.add(loginFragment);
        fragments.add(registerFragment);

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        viewPager.setAdapter(new LoginPagerAdapter(getSupportFragmentManager(),fragments));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginEvent(LoginEvent loginEvent){
        viewPager.setCurrentItem(loginEvent.getIndex());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

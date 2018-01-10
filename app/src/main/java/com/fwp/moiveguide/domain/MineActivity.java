package com.fwp.moiveguide.domain;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fwp.moiveguide.R;
import com.fwp.moiveguide.event.LoginEvent;
import com.fwp.moiveguide.mvp.presenter.MinePresenter;
import com.fwp.moiveguide.mvp.view.impl.IMineView;
import com.fwp.moiveguide.utils.SharedConfig;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2018/1/3.
 */
public class MineActivity extends Base2Activity implements View.OnClickListener,IMineView {

    private ImageView ivBack,ivEdit;
    private LinearLayout llHeader;
    private TextView tvName;
    private MinePresenter minePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        EventBus.getDefault().register(this);
        init();
    }

    private void init() {
        ivBack = (ImageView) findViewById(R.id.iv_back);
        llHeader = (LinearLayout) findViewById(R.id.ll_header);
        tvName = (TextView) findViewById(R.id.tv_text);
        ivEdit = (ImageView) findViewById(R.id.iv_edit);

        llHeader.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        ivEdit.setOnClickListener(this);
        minePresenter = new MinePresenter(app.getDbConfigs(),this);

        try {
            if (SharedConfig.getInstance(this).getIntValue("isLogin",0) == 1){
                // 加载已登录的数据
                minePresenter.findCurrUesr(SharedConfig.getInstance(this).getIntValue("userId",-1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_header:
                try {
                    if (SharedConfig.getInstance(this).getIntValue("isLogin",-1) != 1){
                        startActivity(new Intent(this,LoginActivity.class));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.iv_edit:
                try {
                    if (SharedConfig.getInstance(this).getIntValue("isLogin",-1) == 1){
                        startActivity(new Intent(this,UserDataActivity.class));
                    }else {
                        toast("请先登录！");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginDataEvent(LoginEvent event){
        if (TextUtils.isEmpty(event.getNickname())){
            tvName.setText("点击登录");
        }else {
            tvName.setText(event.getNickname());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showCurrUser(String username) {
        tvName.setText(username);
    }
}

package com.fwp.moiveguide.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.fwp.moiveguide.R;
import com.fwp.moiveguide.event.LoginEvent;
import com.fwp.moiveguide.mvp.presenter.LoginPresenter;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2018/1/4.
 */
public class RegisterFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private TextView tvBackLogin,tvRegister;
    private EditText etUsername,etPwd1,etPwd2;

    private LoginPresenter loginPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register,null);
        init();
        return view;
    }

    private void init() {
        tvBackLogin = (TextView) view.findViewById(R.id.tv_back);
        tvRegister = (TextView) view.findViewById(R.id.tv_register);
        etUsername = (EditText) view.findViewById(R.id.et_username);
        etPwd1 = (EditText) view.findViewById(R.id.et_pwd1);
        etPwd2 = (EditText) view.findViewById(R.id.et_pwd2);

        tvBackLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);

        loginPresenter = new LoginPresenter(app.getDbConfigs());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_back:
                EventBus.getDefault().post(new LoginEvent(0));
                break;
            case R.id.tv_register:
                register();
                break;
        }
    }

    /**
     * 注册新用户
     */
    private void register() {
        String username = etUsername.getText().toString();
        String pwd1 = etPwd1.getText().toString();
        String pwd2 = etPwd2.getText().toString();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd1) || TextUtils.isEmpty(pwd2)){
            toast("请输入完整");
            return;
        }
        if (!TextUtils.equals(pwd1,pwd2)){
            toast("两次输入密码不一致！");
            return;
        }else {
            boolean isSuccess = loginPresenter.register(username,pwd1);
            if (isSuccess){
                toast("注册成功！");
                getActivity().finish();
            }else {
                toast("该用户名已被注册！");
            }
        }
    }
}

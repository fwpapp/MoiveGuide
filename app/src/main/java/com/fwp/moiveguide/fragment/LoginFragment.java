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
import com.fwp.moiveguide.bean.User;
import com.fwp.moiveguide.event.LoginEvent;
import com.fwp.moiveguide.mvp.presenter.LoginPresenter;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2018/1/4.
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private TextView tvRegister,tvLogin;
    private EditText etUsername,etPwd;
    private LoginPresenter loginPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login,null);
        init();
        return view;
    }

    private void init() {
        tvRegister = (TextView) view.findViewById(R.id.tv_register);
        tvLogin = (TextView) view.findViewById(R.id.tv_login);
        etUsername = (EditText) view.findViewById(R.id.et_username);
        etPwd = (EditText) view.findViewById(R.id.et_pwd);

        tvRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);

        loginPresenter = new LoginPresenter(app.getDbConfigs());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_register:
                EventBus.getDefault().post(new LoginEvent(1));
                break;
            case R.id.tv_login:
                login();
                break;
        }
    }

    private void login() {
        String username = etUsername.getText().toString();
        String pwd = etPwd.getText().toString();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd)){
            toast("请输入完整");
            return;
        }else {
            User user = loginPresenter.login(username,pwd);
            if (user == null){
                toast("用户名不存在或密码错误！");
                return;
            }else {
                if (loginPresenter.saveLoginInfo(getContext(),user)){
                    toast("登录成功！");
                    EventBus.getDefault().post(new LoginEvent(user));
                    getActivity().finish();
                }else{
                    toast("出错了！请重试");
                }

            }
        }
    }
}

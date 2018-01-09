package com.fwp.moiveguide.event;

import android.text.TextUtils;

import com.fwp.moiveguide.bean.User;

/**
 * Created by Administrator on 2018/1/4.
 */
public class LoginEvent {

    private int index;
    private User user;

    public LoginEvent(User user){
        this.user = user;
    }

    public LoginEvent(int index){
        this.index = index;
    }

    public String getNickname() {
        if (!TextUtils.isEmpty(user.getNickname())){
            return user.getNickname();
        }
        return user.getUsername();
    }

    public int getIndex() {
        return index;
    }
}

package com.fwp.moiveguide.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2018/1/4.
 */
@Table(name = "User")
public class User {

    @Column(name = "id",isId = true,autoGen = true,property = "NOT NULL")
    private int id;
    @Column(name = "username",autoGen = false,property = "NOT NULL")
    private String username;
    @Column(name = "password",autoGen = false,property = "NOT NULL")
    private String password;
    @Column(name = "nickname",autoGen = false)
    private String nickname;
    @Column(name = "sex",autoGen = false)
    private String sex;
    @Column(name = "address",autoGen = false)
    private String address;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

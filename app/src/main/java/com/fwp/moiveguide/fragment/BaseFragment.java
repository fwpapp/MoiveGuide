package com.fwp.moiveguide.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fwp.moiveguide.myapp.MyApplication;

import org.xutils.DbManager;

/**
 * Created by Administrator on 2018/1/4.
 */
public class BaseFragment extends Fragment {

    MyApplication app;
    DbManager.DaoConfig daoConfig;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        app = (MyApplication) getActivity().getApplication();
        daoConfig = app.getDbConfigs();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void toast(String msg){
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }
}

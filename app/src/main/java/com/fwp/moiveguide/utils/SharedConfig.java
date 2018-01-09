package com.fwp.moiveguide.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/10/21.
 */
public class SharedConfig {
    private Context mContext;
    private SharedPreferences mShare;

    public static final String SHARED_NAME = "moive_guide";

    public SharedConfig(Context context) throws Exception {

        if(context == null){
            throw new Exception("上下文参数不能为空");
        }
        mContext = context;
        mShare = mContext.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        if(mShare == null){
            throw new Exception("获取共享配置失败");
        }

    }

    private static SharedConfig sharedConfig;
    /**
     * 获取单体实例
     */
    public static SharedConfig getInstance(Context context) throws Exception {
        if(sharedConfig == null){
            sharedConfig = new SharedConfig(context);
        }
        return sharedConfig;
    }

    /**
     * 设置整数值
     * @param name
     * @param value
     */
    public void setIntValue(String name, int value){
        if(mShare == null){
            mShare = mContext.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        }
        if(mShare != null){
            SharedPreferences.Editor editor = mShare.edit();
            editor.putInt(name,value);
            editor.commit();
        }
    }

    /**
     * 获取整数值
     * @param keyName
     * @param defaultValue
     * @return
     */
    public int getIntValue(String keyName, int defaultValue){
        if(mShare == null){
            mShare = mContext.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        }
        if(mShare != null){
            defaultValue =  mShare.getInt(keyName,defaultValue);
        }
        return defaultValue;
    }

    /**
     * 设置字符串值
     * @param name
     * @param value
     */
    public void setStringValue(String name, String value){
        if(mShare == null){
            mShare = mContext.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        }
        if(mShare != null){
            SharedPreferences.Editor editor = mShare.edit();
            editor.putString(name,value);
            editor.commit();
        }
    }

    /**
     * 获取字符串值
     * @param keyName
     * @param defaultValue
     * @return
     */
    public String getStringValue(String keyName, String defaultValue){
        if(mShare == null){
            mShare = mContext.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        }
        if(mShare != null){
            defaultValue = mShare.getString(keyName,defaultValue);
        }
        return defaultValue;
    }

    /**
     * 删除字符串值
     * @param name
     */
    public boolean removeStringValue(String name){
        if(mShare == null){
            mShare = mContext.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        }
        if(mShare != null){
            SharedPreferences.Editor editor = mShare.edit();
            editor.remove(name);
            return editor.commit();
        }
        return false;
    }

    /**
     * 删除所有
     */
    public boolean removeAll(){
        if(mShare == null){
            mShare = mContext.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        }
        if(mShare != null){
            SharedPreferences.Editor editor = mShare.edit();
            editor.clear();
            return editor.commit();
        }
        return false;
    }

}

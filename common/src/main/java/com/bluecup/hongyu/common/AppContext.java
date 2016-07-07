package com.bluecup.hongyu.common;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Des:
 * Created by hongyu
 * Date:16/7/6_下午2:16
 */
public class AppContext extends Application {

    private static AppContext mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = (AppContext) getApplicationContext();
        initComponents();
    }

    private void initComponents() {
        // 初始化日志组件
        Logger.init("AndroidTips")
                .methodCount(3)
                .logLevel(LogLevel.FULL)
                .hideThreadInfo()
                .methodOffset(5);
    }

    public static String getResStr(int strId) {
        return mInstance.getResources().getString(strId);
    }
}

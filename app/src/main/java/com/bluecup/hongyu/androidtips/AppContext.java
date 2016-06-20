package com.bluecup.hongyu.androidtips;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;


/**
 * Des:
 * Created by hongyu
 * Date:16/6/2_下午7:39
 */
public class AppContext extends Application {

    private static AppContext mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
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

    public static AppContext getInstance() {
        return mInstance;
    }

    public static String getResStr(int strId) {
        return mInstance.getResources().getString(strId);
    }

}

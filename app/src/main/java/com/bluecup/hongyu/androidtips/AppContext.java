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

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("AndroidTips")
                .methodCount(3)
                .hideThreadInfo()
                .logLevel(LogLevel.FULL)
                .methodOffset(5);

    }
}

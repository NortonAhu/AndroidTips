package com.bluecup.hongyu.androidtips;

import com.bluecup.hongyu.common.AppContext;


/**
 * Des:
 * Created by hongyu
 * Date:16/6/2_下午7:39
 */
public class ATipsApp extends AppContext {

    private static ATipsApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

    }

    public static ATipsApp getInstance() {
        return mInstance;
    }


}

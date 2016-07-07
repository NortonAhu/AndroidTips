package com.bluecup.hongyu.common.ui;

import android.app.Activity;

import java.util.Stack;

/**
 * Des: App 中 Activity 的管理类
 * Created by hongyu
 * Date:16/7/6_下午2:34
 */
public final class BaseAppManager {

    private static String TAG = BaseAppManager.class.getSimpleName();

    private static BaseAppManager mInstance;

    private Stack<Activity> mActivities = new Stack<Activity>();

    private BaseAppManager() {
        // 禁止创建,单例模式
    }

    public static BaseAppManager getInstance() {
        if (mInstance == null) {
            synchronized (BaseAppManager.class) {
                if (mInstance == null) {
                    mInstance = new BaseAppManager();
                }
            }
        }
        return mInstance;
    }

    public int getSize() {
        return mActivities.size();
    }

    public synchronized Activity getLastActivity() {
        return getSize() > 0 ? mActivities.lastElement() : null;
    }

    public synchronized void addActivity(Activity activity) {
        mActivities.push(activity);
    }

    public synchronized void removeActivity(Activity activity) {
        if (mActivities.contains(activity)) {
            mActivities.remove(activity);
        }
    }

    public synchronized void clear() {
        while (mActivities.size() > 0) {
            Activity activity = mActivities.pop();
            activity.finish();
        }
    }

    public synchronized void clearToTop() {
        Activity activity = mActivities.pop();
        activity.finish();
    }

    public void AppExit() {
        try {
            clear();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

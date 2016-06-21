package com.bluecup.hongyu.uilibrary.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Des:
 * Created by hongyu
 * Date:16/6/21_下午2:09
 */
public abstract class BaseFragmentActivity extends AppCompatActivity {

    /**
     * 获取布局文件 ID
     * @return
     */
    protected abstract int getContentViewId();

    protected abstract int getFragmentContentId();

    protected void addFragment(BaseFragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();// Activity 销毁之后恢复不需要关注状态
        }
    }

    protected void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
            return;
        }
        super.onBackPressed();
    }
}

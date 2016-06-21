package com.bluecup.hongyu.uilibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bluecup.hongyu.uilibrary.base.BaseFragment;
import com.bluecup.hongyu.uilibrary.base.BaseFragmentActivity;

/**
 * Des:
 * Created by hongyu
 * Date:16/6/21_下午2:09
 */
public abstract class APPActivity extends BaseFragmentActivity {

    protected abstract BaseFragment getFirstFragment();

    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentViewId());

        if (null != getIntent()) {
            handleIntent(getIntent());
        }

        if (null != getSupportFragmentManager().getFragments()) {
            BaseFragment fragment = getFirstFragment();
            if (null != fragment) {
                addFragment(fragment);
            }
        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_base;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.fragment_container;
    }
}

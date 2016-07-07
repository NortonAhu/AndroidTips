package com.bluecup.hongyu.androidtips.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.bluecup.hongyu.androidtips.R;
import com.bluecup.hongyu.androidtips.ui.fragment.VectorFragment;
import com.bluecup.hongyu.common.ui.activity.BaseActivity;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Des: 空Activity 主要是用来执行显示相关item的
 * Created by hongyu
 * Date:16/7/6_下午1:53
 */
public final class EmptyActivity extends BaseActivity {
    public static final String KEY_CATEGORY_ID = "categoryid";

    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        ButterKnife.bind(this);
        initTitle("Vector", true);
        initFragmentManager();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }

        int id = intent.getIntExtra(KEY_CATEGORY_ID, 0);
        switch (id) {
            default:
                setFragment();
                break;
        }
    }

    private void initFragmentManager() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                // 打开一个新的Fragement 返回上一个也会 直到最后一个
                Logger.t("container").d("onBackStackChanged manager size = " + mFragmentManager.getBackStackEntryCount());
            }
        });
        mTransaction = mFragmentManager.beginTransaction();
    }

    @Override
    protected void setFragment() {
        VectorFragment fragment = VectorFragment.newInstance();
        if (mFragmentManager.findFragmentById(R.id.fragment_container) != null) {
            return;
        }
        mTransaction.add(R.id.fragment_container, fragment);
        mTransaction.commit();
    }
}

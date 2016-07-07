package com.bluecup.hongyu.common.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.bluecup.hongyu.common.R;
import com.bluecup.hongyu.common.ui.BaseAppManager;

/**
 * Des: Activity基类
 * Created by hongyu
 * Date:16/7/6_下午2:24
 */
public abstract class BaseActivity extends AppCompatActivity {
    Toolbar mToolBar;
    RelativeLayout rootLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        BaseAppManager.getInstance().addActivity(this);
        initToolbar();
    }

    protected void initTitle(String title, boolean isShowBack) {
        getSupportActionBar().setTitle(title);
        // 4.0 以下默认是true 4.0 以上默认是false 左上角的返回角标
        getSupportActionBar().setDisplayHomeAsUpEnabled(isShowBack);
    }

    private void initToolbar() {
        mToolBar = (Toolbar) findViewById(R.id.tool_bar);
        rootLayout = (RelativeLayout) findViewById(R.id.root_layout);
        if (mToolBar != null) {
            setSupportActionBar(mToolBar);
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(View.inflate(this, layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        if (rootLayout == null) return;
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lp.addRule(RelativeLayout.BELOW, R.id.tool_bar);
        setContentView(view, lp);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (rootLayout == null) return;
        rootLayout.addView(view, params);
        initToolbar();
    }

    @Override
    public void finish() {
        super.finish();
        BaseAppManager.getInstance().removeActivity(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void setFragment(){

    }
}

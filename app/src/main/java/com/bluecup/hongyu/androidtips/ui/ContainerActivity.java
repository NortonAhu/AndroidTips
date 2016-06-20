package com.bluecup.hongyu.androidtips.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.bluecup.hongyu.androidtips.AppContext;
import com.bluecup.hongyu.androidtips.R;
import com.bluecup.hongyu.androidtips.ui.activity.BaseActivity;
import com.bluecup.hongyu.androidtips.ui.fragment.AFragment;
import com.bluecup.hongyu.androidtips.ui.fragment.BFragment;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fragment 学习Tips
 * 1. Fragment实现集成
 * 2. Fragment事务的处理
 * 3. Fragment 过渡动画的实现
 * 4. Fragment 与 Activity,Fragment 与 Fragment 数据传递
 * 5. 一些常用的 Fragment 小技巧
 */
public class ContainerActivity extends BaseActivity implements AFragment.OnFragmentInteractionListener {

    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        ButterKnife.bind(this);
        initTitle(AppContext.getResStr(R.string.fragment_activity_title), true);

        initFragmentManager();
        addFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_fragment_activity, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        } else if (id == R.id.action_go_next) {
            replaceFragemnt();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initFragmentManager() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                // 打开一个新的Fragement 返回上一个也会 直到最后一个
                Logger.t("container").d("onBackStackChanged");
            }
        });
        mTransaction = mFragmentManager.beginTransaction();
    }

    protected void addFragment() {
        AFragment aFragment = AFragment.newInstance("add Fragment", "");
        mTransaction.add(R.id.fragment_container, aFragment);
        // 这里是第一个 Fragment 不需要使用后退栈不然会出现一个空白的界面
//        mTransaction.addToBackStack(null);
        mTransaction.commit();
    }

    public void removeFragment() {

    }

    /**
     * fix:java.lang.IllegalStateException: commit already called
     * reson:fragment的 commit 和事务是成对,mTransaction这个不能复用
     */
    public void replaceFragemnt() {
        BFragment bFragment = BFragment.newInstance("add B Fragment", "");
        mTransaction = mFragmentManager.beginTransaction();
        mTransaction.replace(R.id.fragment_container, bFragment);
        mTransaction.addToBackStack(null);
        mTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(String content) {
        // 感觉这是多个Fragement在一起的通信稍微鸡肋点
        BFragment bFragment;
        try {
            bFragment = (BFragment) mFragmentManager.findFragmentById(R.id.fragment_container);
        } catch (Exception e) {
            bFragment = null;
        }
        if (bFragment != null) {
            bFragment.setContent(content);
        } else {
            bFragment = BFragment.newInstance(content, "");
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, bFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}

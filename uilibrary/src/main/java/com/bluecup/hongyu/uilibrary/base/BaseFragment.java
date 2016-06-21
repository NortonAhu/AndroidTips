package com.bluecup.hongyu.uilibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Des:
 * Created by hongyu
 * Date:16/6/21_下午2:16
 */
public abstract class BaseFragment extends Fragment {

    private BaseFragmentActivity mActivity;

    protected abstract int getLayoutId();

    protected BaseFragmentActivity getHoldingActivity(){
        return mActivity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseFragmentActivity)context;
    }

    protected void addFragment(BaseFragment fragment) {
        getHoldingActivity().addFragment(fragment);
    }

    protected void removeFragment() {
        getHoldingActivity().removeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view, savedInstanceState);

        return view;
    }

    protected abstract void initView(View view, Bundle savedInstanceState);
}

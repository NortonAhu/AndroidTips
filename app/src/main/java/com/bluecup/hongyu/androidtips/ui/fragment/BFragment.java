package com.bluecup.hongyu.androidtips.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluecup.hongyu.androidtips.R;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Des:
 * Created by hongyu
 * Date:16/6/20_下午1:56
 */
public class BFragment extends Fragment {
    private static final String TAG = "BFragment";


    private static final String TAG_CONTENT = "content";
    private static final String TAG_TITLE = "title";
    @BindView(R.id.txt_des)
    TextView txtDes;
    private String mContent;
    private String mTitle;

    public static BFragment newInstance(String content, String title) {
        Logger.t(TAG, 0).t(TAG, 0).d("new newInstance");
        BFragment fragment = new BFragment();
        Bundle args = new Bundle();
        args.putString(TAG_CONTENT, content);
        args.putString(TAG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.t(TAG, 0).d("onCreate");
        if (getArguments() != null) {
            mContent = getArguments().getString(TAG_CONTENT);
            mTitle = getArguments().getString(TAG_TITLE);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Logger.t(TAG, 0).d("onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.t(TAG, 0).d("onActivityCreated");
        txtDes.setText(mContent);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logger.t(TAG, 0).d("onCreateView");
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.t(TAG, 0).d("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.t(TAG, 0).d("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.t(TAG, 0).d("onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.t(TAG, 0).d("onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.t(TAG, 0).d("onDestroyView");
    }

    public void setContent(String content) {
        txtDes.setText(content);
    }
    @Override
    public void onDetach() {
        super.onDetach();
        Logger.t(TAG, 0).d("onDetach");
    }
}

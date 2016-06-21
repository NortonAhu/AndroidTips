package com.bluecup.hongyu.androidtips.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bluecup.hongyu.androidtips.ui.ContainerActivity;

import java.util.Arrays;
import java.util.List;

/**
 * Des:
 * Created by hongyu
 * Date:16/6/20_下午5:20
 */
public class ListTitleFragment extends ListFragment {

    private static final String TAG_POSITION = "position";
    private List<String> mTitles = Arrays.asList("头条", "新闻热点", "轻松一刻","胖编怪谈");
    private ArrayAdapter<String> mAdpter;
    private int mCurrentPosition;


    public static ListTitleFragment newInstance(int position) {

        Bundle args = new Bundle();

        ListTitleFragment fragment = new ListTitleFragment();
        args.putInt(TAG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(mAdpter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mTitles));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mCurrentPosition = position;

        Intent intent = new Intent(getActivity(), ContainerActivity.class);
    }
}

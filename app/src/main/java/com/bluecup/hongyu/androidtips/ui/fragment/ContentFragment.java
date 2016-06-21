package com.bluecup.hongyu.androidtips.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Des:
 * Created by hongyu
 * Date:16/6/20_下午5:30
 */
public class ContentFragment extends Fragment {



    public static ContentFragment newInstance() {

        Bundle args = new Bundle();

        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(args);
        return fragment;
    }
}

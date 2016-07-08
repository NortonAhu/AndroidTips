package com.bluecup.hongyu.androidtips.ui.fragment;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bluecup.hongyu.androidtips.R;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Des:
 * Created by hongyu
 * Date:16/7/6_下午3:37
 */
public class VectorFragment extends Fragment {
    static String TAG = VectorFragment.class.getSimpleName();
    @BindView(R.id.img_static_icon)
    ImageView imgStaticIcon;
    @BindView(R.id.img_anim_vector)
    ImageView imgAnimVector;
    @BindView(R.id.img_anim_wrench)
    ImageView imgAnimWrench;
    @BindView(R.id.img_anim_mirror)
    ImageView imgAnimMirror;

    public static VectorFragment newInstance() {

        Bundle args = new Bundle();

        VectorFragment fragment = new VectorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vector, container, false);
        ButterKnife.bind(this, view);
        Logger.t(TAG).d("onCreateView");
        return view;
    }

    @OnClick({R.id.img_static_icon, R.id.img_anim_vector, R.id.img_anim_wrench, R.id.img_anim_mirror})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_static_icon:
                break;
            case R.id.img_anim_vector:
                anim(view);
//                AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(
//                        getActivity(), R.drawable.anim_arrow
//                );
//                ((ImageView) view).setImageDrawable(animatedVectorDrawableCompat);
//                ((Animatable) ((ImageView) view).getDrawable()).start();
                break;
            default:
                anim(view);
                break;
        }
    }

    private void anim(View view) {
        ImageView imageView = (ImageView) view;
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }
}

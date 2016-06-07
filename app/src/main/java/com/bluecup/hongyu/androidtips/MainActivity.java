package com.bluecup.hongyu.androidtips;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.img_1)
    ImageView img1;
    @BindView(R.id.img_2)
    ImageView img2;
    @BindView(R.id.img_3)
    ImageView img3;
    @BindView(R.id.img_4)
    ImageView img4;
    @BindView(R.id.img_5)
    ImageView img5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tintTestByCode(img4);
        Logger.d("test");
        selectTint(img5);
    }

    private void tintTestByCode(ImageView imageView) {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.btn);

        Drawable.ConstantState state = drawable.getConstantState();
        Drawable drawable1 = DrawableCompat.wrap(state == null ? drawable : state.newDrawable().mutate());

        drawable1.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        DrawableCompat.setTint(drawable1, Color.parseColor("#40FF65"));

        imageView.setImageDrawable(drawable1);

    }

    private void selectTint(ImageView imageView) {

        Drawable drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.btn);

        int[] colors = new int[]{ContextCompat.getColor(this, R.color.pink), ContextCompat.getColor(this, R.color.pink1)};

        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_pressed};
        states[1] = new int[]{};
        ColorStateList colorStateList = new ColorStateList(states, colors);

        StateListDrawable stateListDrawable = new StateListDrawable();

        stateListDrawable.addState(states[0], drawable);
        stateListDrawable.addState(states[1], drawable);

        Drawable.ConstantState state = stateListDrawable.getConstantState();


        drawable = DrawableCompat.wrap(state == null ? stateListDrawable : state.newDrawable().mutate());

        DrawableCompat.setTintList(drawable, colorStateList);
        imageView.setImageDrawable(drawable);
    }
}

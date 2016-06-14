package com.bluecup.hongyu.androidtips;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.bluecup.hongyu.androidtips.ui.activity.BaseActivity;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        
        initTitle();
//        tintTestByCode(img4);
//        Logger.d("test");
//        selectTint(img5);
    }

    private void initTitle() {
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name_ch));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_setting) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //    private void tintTestByCode(ImageView imageView) {
//        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.btn);
//
//        Drawable.ConstantState state = drawable.getConstantState();
//        Drawable drawable1 = DrawableCompat.wrap(state == null ? drawable : state.newDrawable().mutate());
//
//        drawable1.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//        DrawableCompat.setTint(drawable1, Color.parseColor("#40FF65"));
//
//        imageView.setImageDrawable(drawable1);
//
//    }
//
//    private void selectTint(ImageView imageView) {
//
//        Drawable drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.btn);
//
//        int[] colors = new int[]{ContextCompat.getColor(this, R.color.pink), ContextCompat.getColor(this, R.color.pink1)};
//
//        int[][] states = new int[2][];
//        states[0] = new int[]{android.R.attr.state_pressed};
//        states[1] = new int[]{};
//        ColorStateList colorStateList = new ColorStateList(states, colors);
//
//        StateListDrawable stateListDrawable = new StateListDrawable();
//
//        stateListDrawable.addState(states[0], drawable);
//        stateListDrawable.addState(states[1], drawable);
//
//        Drawable.ConstantState state = stateListDrawable.getConstantState();
//
//
//        drawable = DrawableCompat.wrap(state == null ? stateListDrawable : state.newDrawable().mutate());
//
//        DrawableCompat.setTintList(drawable, colorStateList);
//        imageView.setImageDrawable(drawable);
//    }
}

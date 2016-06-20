package com.bluecup.hongyu.androidtips;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.bluecup.hongyu.androidtips.adapter.NormalAdapter;
import com.bluecup.hongyu.androidtips.ui.ContainerActivity;
import com.bluecup.hongyu.androidtips.ui.activity.BaseActivity;

public class MainActivity extends BaseActivity {


    RecyclerView mTipsRecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTitle(getResources().getString(R.string.app_name_ch), false);
        initView();
//        tintTestByCode(img4);
//        Logger.d("test");
//        selectTint(img5);
    }

    private void initView() {
        mTipsRecycle = (RecyclerView) findViewById(R.id.recycle_items);
        mTipsRecycle.setLayoutManager(new GridLayoutManager(this, 2));
        mTipsRecycle.setAdapter(new NormalAdapter(this));
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
        } else if (id == R.id.action_testing){
            Intent intent = new Intent(MainActivity.this, ContainerActivity.class);
            startActivity(intent);
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

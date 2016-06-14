package com.bluecup.hongyu.androidtips.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Des:
 * Created by hongyu
 * Date:16/6/7_下午7:36
 */
public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.NormalTextViewHolder> {

    public NormalAdapter(Context context) {

    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder{

        public NormalTextViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}

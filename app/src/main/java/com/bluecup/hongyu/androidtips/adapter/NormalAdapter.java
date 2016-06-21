package com.bluecup.hongyu.androidtips.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluecup.hongyu.androidtips.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Des:
 * Created by hongyu
 * Date:16/6/7_下午7:36
 */
public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.NormalTextViewHolder> implements View.OnClickListener {

    private final String[] mTitles;
    private final LayoutInflater mInflate;
    private final Context mContext;
    private OnRecycleViewItemClickListener mListener;

    public NormalAdapter(Context context) {
        mTitles = context.getResources().getStringArray(R.array.main_item);
        mInflate = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflate.inflate(R.layout.item_text, parent, false);
        view.setOnClickListener(this);
        NormalTextViewHolder viewHolder = new NormalTextViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        holder.mTextView.setText(mTitles[position]);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public Object getData(int position) {
        return mTitles == null ? null : mTitles[position];
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) mListener.onItemClickListener(v, (Integer) v.getTag());
    }

    public void setOnRecycleViewClickListener(OnRecycleViewItemClickListener listener) {
        this.mListener = listener;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_item_content)
        TextView mTextView;
        View itemView;

        public NormalTextViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }
    }

}

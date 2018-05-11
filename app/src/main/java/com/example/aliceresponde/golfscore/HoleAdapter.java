package com.example.aliceresponde.golfscore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class HoleAdapter extends BaseAdapter {
    private Hole[] mHoles;
    private Context mContext;

    public HoleAdapter(Hole[] mHoles, Context context) {
        this.mHoles = mHoles;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int position) {
        return mHoles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0; // no implement
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.score_item, null);
            holder = new ViewHolder();
            holder.tvLabel = (TextView) convertView.findViewById(R.id.hole_label);
            holder.tvScore = (TextView) convertView.findViewById(R.id.score_counter);
            holder.btnAdd = (Button) convertView.findViewById(R.id.btn_add);
            holder.btnRemove = (Button) convertView.findViewById(R.id.btn_remove);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvLabel.setText(mHoles[position].getLabel());
        holder.tvScore.setText(Integer.toString(mHoles[position].getScoreValue()));

        holder.btnAdd.setOnClickListener(v -> {
                    int newScore = mHoles[position].getScoreValue() + 1;
                    mHoles[position].setScoreValue(newScore);
                    holder.tvScore.setText(Integer.toString(newScore));
                }
        );

        holder.btnRemove.setOnClickListener(v -> {
            int newScore = mHoles[position].getScoreValue() - 1;
            if (newScore < 0) {
                newScore = 0;
            }
            mHoles[position].setScoreValue(newScore);
            holder.tvScore.setText(Integer.toString(newScore));
        });
        return convertView;
    }

    private static class ViewHolder {
        private TextView tvLabel;
        private TextView tvScore;
        private Button btnAdd;
        private Button btnRemove;
    }
}

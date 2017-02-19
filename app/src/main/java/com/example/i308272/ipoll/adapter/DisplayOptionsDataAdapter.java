package com.example.i308272.ipoll.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.i308272.ipoll.R;

import java.util.ArrayList;

/**
 * Created by I308272 on 2/17/2017.
 */

public class DisplayOptionsDataAdapter extends RecyclerView.Adapter<DisplayOptionsDataAdapter.ViewHolder> {

    ArrayList<String> mDataSet;

    public DisplayOptionsDataAdapter(ArrayList<String> dataSet) {

        this.mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_option_item,
                parent,false );
        return (new DisplayOptionsDataAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cbOption.setText(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View mItem;
        public CheckBox cbOption;

        public ViewHolder(View itemView) {
            super(itemView);
            mItem = itemView;
            cbOption = (CheckBox) itemView.findViewById(R.id.display_options_item);
        }
    }
}

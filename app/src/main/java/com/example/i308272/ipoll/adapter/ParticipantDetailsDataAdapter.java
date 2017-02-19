package com.example.i308272.ipoll.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.i308272.ipoll.R;
import com.example.i308272.ipoll.createPoll.model.ParticipantDetailListItem;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by I308272 on 2/16/2017.
 */

public class ParticipantDetailsDataAdapter extends RecyclerView.Adapter<ParticipantDetailsDataAdapter.ViewHolder> {

    ArrayList<ParticipantDetailListItem> participantDetailListItems;



    public ParticipantDetailsDataAdapter(
            ArrayList<ParticipantDetailListItem> participantDetailListItems)
    {
        this.participantDetailListItems = participantDetailListItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crt_option_details,
                parent,false );
        return (new ViewHolder(view));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cbDetailName.setText(participantDetailListItems.get(position).getDetailText());
        holder.isOptions.setText("Optional");
    }

    @Override
    public int getItemCount() {
        return participantDetailListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View mItem;
        public CheckBox cbDetailName;
        public CheckBox isOptions;

        public ViewHolder(View itemView) {
            super(itemView);

            mItem = itemView;
            cbDetailName = (CheckBox) itemView.findViewById(R.id.crt_option_cb_detail);
            isOptions = (CheckBox) itemView.findViewById(R.id.crt_option_cb_optional);
        }

    }
}

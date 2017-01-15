package com.example.i308272.ipoll.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.i308272.ipoll.PollFragment.OnListFragmentInteractionListener;
import com.example.i308272.ipoll.R;
import com.example.i308272.ipoll.model.DisplayList.DisplayListItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DisplayListItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<DisplayListItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<DisplayListItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mQuestion.setText(mValues.get(position).question);
        holder.mDescription.setText(mValues.get(position).description);
        holder.mLikes.setText(String.valueOf(mValues.get(position).likes));
        holder.mComments.setText(String.valueOf(mValues.get(position).comments));
        holder.mVotes.setText(String.valueOf(mValues.get(position).votes));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        public final TextView mQuestion;
        public final TextView mDescription;
        public final TextView mLikes;
        public final TextView mComments;
        public final TextView mVotes;
        public DisplayListItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mQuestion = (TextView) view.findViewById(R.id.tvQuery);
            mDescription = (TextView) view.findViewById(R.id.edDescription);
            mLikes = (TextView) view.findViewById(R.id.tvLikes);
            mComments = (TextView) view.findViewById(R.id.tvComments);
            mVotes  = (TextView) view.findViewById(R.id.tvVotes);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mQuestion.getText() + "'";
        }
    }
}

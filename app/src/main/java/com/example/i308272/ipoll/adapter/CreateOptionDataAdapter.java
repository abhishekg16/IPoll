package com.example.i308272.ipoll.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.i308272.ipoll.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by I308272 on 2/11/2017.
 */

public class CreateOptionDataAdapter extends RecyclerView.Adapter<CreateOptionDataAdapter.ViewHolder>{


    // THis field denotes the number of options view had been created till now.
    //private int numOptions;

    private ArrayList<String> optionTextList = null;
    private OnItemRemovedListener mListener =null;

    public CreateOptionDataAdapter(ArrayList<String> optionTextList,OnItemRemovedListener mListener) {
        this.optionTextList = optionTextList;
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crt_option_layout,
                parent,false );
        return (new ViewHolder(view));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.etOptionText.setText("");
        holder.etOptionText.setText(optionTextList.get(position));
    }

    @Override
    public int getItemCount() {
        return optionTextList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public final View mView;
        public final EditText etOptionText;
        public final ImageButton imgBtDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            etOptionText =  (EditText) itemView.findViewById(R.id.ct_option_etOptionText);

            imgBtDelete =  (ImageButton)itemView.findViewById(R.id.ct_option_ibtDelete);
            imgBtDelete.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // Create the Content in the EditText View
                    // So if the same view is recyclered then it
                    // should be clean
                    mListener.onItemRemoved();
                    etOptionText.setText("");
                    removeItem(getAdapterPosition());

                }
            });
        }
    }

    public void removeItem(int position){
        optionTextList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, optionTextList.size());
    }

    public interface OnItemRemovedListener{
        void onItemRemoved();
    }

    public void updateOptionText(String text,int position){
        if (text.isEmpty())
            optionTextList.set(position,"");
        else
            optionTextList.set(position,text);
    }
}

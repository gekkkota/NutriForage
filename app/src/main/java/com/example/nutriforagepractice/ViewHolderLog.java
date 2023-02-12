package com.example.nutriforagepractice;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderLog extends RecyclerView.ViewHolder {

    TextView mlogItem, mlogDescription;
    View mView;

    public ViewHolderLog(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        //item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

        //item long click listener
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view, getAdapterPosition());
                return true;
            }
        });

        //initialize views with model_layout.xml
        mlogItem = itemView.findViewById(R.id.logItem);
        mlogDescription = itemView.findViewById(R.id.logDescription);

    }

    private  ViewHolderLog.ClickListener mClickListener;
    //interface for click listener
    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
    public void setOnClickListener(ViewHolderLog.ClickListener clickListener){
        mClickListener = clickListener;
    }
}

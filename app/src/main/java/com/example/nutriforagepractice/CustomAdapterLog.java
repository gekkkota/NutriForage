package com.example.nutriforagepractice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapterLog extends RecyclerView.Adapter<ViewHolderLog> {

    FoodLogActivity logActivity;
    List<ModelLog> modelLog;
    Context context;

    ViewHolder viewHolder;



    public CustomAdapterLog(FoodLogActivity logActivity, List<ModelLog> modelLog) {
        this.logActivity = logActivity;
        this.modelLog = modelLog;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderLog onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflate layout
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.model_layout_log, viewGroup, false);
        ViewHolderLog viewHolder = new ViewHolderLog(itemView);
        //handle item clicks here
        viewHolder.setOnClickListener(new ViewHolderLog.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //this will be called when user click item

                //show data in toast on clicking
                String title = modelLog.get(position).getTile();
                String descr = modelLog.get(position).getDescription();
                Toast.makeText(logActivity, title+"\n"+descr, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                //this will be called when user long clicks item

                //Creating AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(logActivity);
                //options to display in dialog
                String[] options = {"Update", "Delete"};
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            //update is clicked
                            //get data
                            String id = modelLog.get(position).getId();
                            String title = modelLog.get(position).getTile();
                            String description = modelLog.get(position).getDescription();

                            //intent to start activity
                            Intent intent = new Intent(logActivity, FoodLogging.class);
                            //put data in intent
                            intent.putExtra("pId", id);
                            intent.putExtra("pTitle", title);
                            intent.putExtra("pDescription", description);
                            //start activity
                            logActivity.startActivity(intent);

                        }
                        if (which == 1){
                            // delete is clicked
                            logActivity.deleteData(position);
                        }

                    }
                }).create().show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLog viewholder, int i) {
        //bind views / set data

        //TextView viewHolder1 = viewHolder.mlistItem;
        //TextView viewHolder2 = viewHolder.mlistDescription;


        //viewHolder.mlistItem.setText(modelList.get(i).getTile());
        //viewHolder.mlistDescription.setText(modelList.get(i).getDescription());

    }

    @Override
    public int getItemCount() {
        return modelLog.size();
    }
}

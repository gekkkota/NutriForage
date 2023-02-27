package com.example.nutriforagepractice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DescriptionsAdapter extends RecyclerView.Adapter<DescriptionsAdapter.DescriptionsVH> {

    List<HelpCenter_Description> descriptionsList;

    public DescriptionsAdapter(List<HelpCenter_Description> descriptionsList) {
        this.descriptionsList = descriptionsList;
    }

    @NonNull
    @Override
    public DescriptionsAdapter.DescriptionsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.help_center_rows, parent, false);
        return new DescriptionsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DescriptionsAdapter.DescriptionsVH holder, int position) {
        HelpCenter_Description helpCenter_description = descriptionsList.get(position);
        holder.nameText.setText(helpCenter_description.getName());
        holder.descText.setText(helpCenter_description.getDescription());

        boolean isExpandable = descriptionsList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);


    }

    @Override
    public int getItemCount() {
        return descriptionsList.size();
    }

    public class DescriptionsVH extends RecyclerView.ViewHolder {

        TextView nameText, descText;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        public DescriptionsVH(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.name);
            descText = itemView.findViewById(R.id.description);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HelpCenter_Description helpCenter_description = descriptionsList.get(getAdapterPosition());
                    helpCenter_description.setExpandable(!helpCenter_description.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}

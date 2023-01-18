package com.example.nutriforagepractice.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutriforagepractice.R;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{

    ArrayList<FoodHelperClass> foodCategory;

    public FoodAdapter(ArrayList<FoodHelperClass> foodCategory) {
        this.foodCategory = foodCategory;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
      FoodViewHolder foodViewHolder = new FoodViewHolder(view);
        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

       FoodHelperClass foodHelperClass = foodCategory.get(position);

        holder.image.setImageResource(foodHelperClass.getImage());
        holder.title.setText(foodHelperClass.getTitle());
        holder.desc.setText(foodHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {



        return foodCategory.size();
    }

    public static class  FoodViewHolder extends RecyclerView.ViewHolder{


        ImageView image;
        TextView title, desc;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.fc_img);
            title = itemView.findViewById(R.id.fc_text);
            desc = itemView.findViewById(R.id.fc_desc);


        }
    }


}




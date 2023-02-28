package com.example.nutriforagepractice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HelpCenter extends AppCompatActivity {
    RecyclerView recyclerView;
    List<HelpCenter_Description> descriptionList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_help_center);

        recyclerView = findViewById(R.id.help_recyclerView);

        initData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        DescriptionsAdapter descriptionsAdapter = new DescriptionsAdapter(descriptionList);
        recyclerView.setAdapter(descriptionsAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {

        descriptionList = new ArrayList<>();

        descriptionList.add(new HelpCenter_Description("Getting Started", "Description1"));
        descriptionList.add(new HelpCenter_Description("FAQs", "Description2"));
        descriptionList.add(new HelpCenter_Description("Privacy and Security", "Description3"));
        descriptionList.add(new HelpCenter_Description("Tips and Tricks", "Description4"));
        
    }

}

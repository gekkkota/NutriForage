package com.example.nutriforagepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class AllCategories extends AppCompatActivity {

    ImageView backBtn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_all_categories);

        //Hooks

        backBtn = findViewById(R.id.back_pressed_categories);




        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AllCategories.super.onBackPressed();

            }
        });
    }
}
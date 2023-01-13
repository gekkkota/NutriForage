package com.example.nutriforagepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SignUp2 extends AppCompatActivity {

    TextInputEditText editAge, editHeight, editWeight;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        editAge = findViewById(R.id.input_age);
        editHeight = findViewById(R.id.input_height);
        editWeight = findViewById(R.id.input_weight);
        btnSignup = findViewById(R.id.submit_signup);
    }
}
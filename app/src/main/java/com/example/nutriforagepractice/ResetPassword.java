package com.example.nutriforagepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    ImageView backBtnPassword;

    TextInputEditText editEmail;
    Button btnSubmit;
    ProgressBar progressBar;

    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_reset_password);

        //Hooks

        backBtnPassword = findViewById(R.id.back_pressed_reset_password);
        editEmail = findViewById(R.id.email_reset);
        btnSubmit = findViewById(R.id.submit_reset);
        progressBar = findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();

        backBtnPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), SignIn.class);
                    startActivity(intent);
                    finish();

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = String.valueOf(editEmail.getText());

                if(TextUtils.isEmpty(email)){
                    editEmail.setError("Email field is empty.");
                    editEmail.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    editEmail.setError("Entered email is not valid.");
                    editEmail.requestFocus();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ResetPassword.this, "Check your email to reset your password.", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ResetPassword.this, "Something went wrong.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
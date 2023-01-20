package com.example.nutriforagepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    TextInputEditText editFullname, editEmail, editPassword;
    Button btnNext;
    ProgressBar progressBar;
    TextView toSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editFullname = findViewById(R.id.input_fullname);
        editEmail = findViewById(R.id.input_email);
        editPassword = findViewById(R.id.input_password);
        btnNext = findViewById(R.id.next);
        progressBar = findViewById(R.id.progressBar);
        toSignIn = findViewById(R.id.to_login);

        toSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);
                finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname, email, password;
                fullname = String.valueOf(editFullname.getText());
                email = String.valueOf(editEmail.getText());
                password = String.valueOf(editPassword.getText());

                if(TextUtils.isEmpty(fullname)){
                    editFullname.setError("Full Name field is empty.");
                    editFullname.requestFocus();
                    return;
                }
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
                if(TextUtils.isEmpty(password)){
                    editPassword.setError("Password field is empty.");
                    editPassword.requestFocus();
                    return;
                }
                if(password.length() < 6){
                    editPassword.setError("Password must be 6 or more characters.");
                    editPassword.requestFocus();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), SignUp2.class);
                intent.putExtra("keyfullname", fullname);
                intent.putExtra("keyemail", email);
                intent.putExtra("keypassword", password);
                startActivity(intent);
                finish();
            }
        });
    }
}
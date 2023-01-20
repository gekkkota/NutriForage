package com.example.nutriforagepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp2 extends AppCompatActivity {

    TextInputEditText editAge, editHeight, editWeight;
    Button btnSignup;
    ProgressBar progressBar;

    FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://nutriforage-3799b-default-rtdb.asia-southeast1.firebasedatabase.app/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        editAge = findViewById(R.id.input_age);
        editHeight = findViewById(R.id.input_height);
        editWeight = findViewById(R.id.input_weight);
        btnSignup = findViewById(R.id.submit_signup);
        progressBar = findViewById(R.id.progressBar);

        String fullname = getIntent().getStringExtra("keyfullname");
        String email = getIntent().getStringExtra("keyemail");
        String password = getIntent().getStringExtra("keypassword");

        mAuth = FirebaseAuth.getInstance();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String age = String.valueOf(editAge.getText());
                String height = String.valueOf(editHeight.getText());
                String weight = String.valueOf(editWeight.getText());

                if(TextUtils.isEmpty(age)){
                    editAge.setError("Age field is empty.");
                    editAge.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(height)){
                    editHeight.setError("Height field is empty.");
                    editHeight.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(weight)){
                    editWeight.setError("Weight field is empty.");
                    editWeight.requestFocus();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Users users = new Users(fullname, email, age, height, weight);

                                    database.getReference("Users")
                                            .child(mAuth.getCurrentUser().getUid())
                                            .setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if(task.isSuccessful()){
                                                        Toast.makeText(SignUp2.this, "Sign Up Successful.",
                                                                Toast.LENGTH_SHORT).show();
                                                        progressBar.setVisibility(View.GONE);

                                                        Intent intent = new Intent(getApplicationContext(), SignIn.class);
                                                        startActivity(intent);
                                                        finish();
                                                    } else {
                                                        Toast.makeText(SignUp2.this, "Authentication failed.",
                                                                Toast.LENGTH_SHORT).show();
                                                        progressBar.setVisibility(View.GONE);
                                                    }
                                                }
                                            });
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(SignUp2.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
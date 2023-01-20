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
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

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
                    Toast.makeText(SignUp2.this, "Age field is empty.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(height)){
                    Toast.makeText(SignUp2.this, "Height field is empty.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(weight)){
                    Toast.makeText(SignUp2.this, "Weight field is empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                myRef.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //check if email is already registered
                        if(snapshot.hasChild(email)){
                            Toast.makeText(SignUp2.this, "Email is already registered.", Toast.LENGTH_SHORT).show();
                        } else {
                            //send data to firebase realtime database
                            myRef.child("Users").child(email).child("Full Name").setValue(fullname);
                            myRef.child("Users").child(email).child("Password").setValue(password);
                            myRef.child("Users").child(email).child("Age").setValue(age);
                            myRef.child("Users").child(email).child("Weight").setValue(height);
                            myRef.child("Users").child(email).child("Height").setValue(weight);

                            //sending data success
                            Toast.makeText(SignUp2.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(SignUp2.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignUp2.this, "Sign Up Successful.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), SignIn.class);
                                    startActivity(intent);
                                    finish();
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
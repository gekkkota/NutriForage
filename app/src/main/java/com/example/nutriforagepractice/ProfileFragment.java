package com.example.nutriforagepractice;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragment extends AppCompatActivity {

    LinearLayout profile_settings, profile_help , profile_logout;
    TextView  disp_age, disp_height, disp_weight, disp_email, disp_name;
    String userID, age, height, weight, fullName;

    ImageView backBtnProfile;

    FirebaseAuth mAuth;

    FirebaseUser user;

    DatabaseReference reference;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://nutriforage-3799b-default-rtdb.asia-southeast1.firebasedatabase.app/");

    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        profile_settings = findViewById(R.id.profile_settings);
        profile_help = findViewById(R.id.profile_helpcenter);
        profile_logout = findViewById(R.id.profile_logOut);
        backBtnProfile = findViewById(R.id.back_pressed_profile);

        disp_age = findViewById(R.id.profile_age);
        disp_height = findViewById(R.id.profile_height);
        disp_weight = findViewById(R.id.profile_weight);
        disp_email = findViewById(R.id.textView_email);
        disp_name = findViewById(R.id.textView_name);

        mAuth = FirebaseAuth.getInstance();
        reference = database.getReference("Users");
        user = mAuth.getCurrentUser();
        userID = user.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Users userProfile = snapshot.getValue(Users.class);

                age = userProfile.age;
                fullName = userProfile.fullname;
                height = userProfile.height;
                weight = userProfile.weight;

                disp_email.setText(user.getEmail());
                disp_age.setText(age);
                disp_height.setText(height);
                disp_weight.setText(weight);
                disp_name.setText(fullName);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfileFragment.this, "Something went wrong!", Toast.LENGTH_LONG).show();

            }
        });

        backBtnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent);
                finish();

            }
        });

        profile_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Settings.class));

            }
        });

        profile_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Settings.class));

            }
        });

        profile_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(), "Log Out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);
                finish();

            }
        });





    }







}
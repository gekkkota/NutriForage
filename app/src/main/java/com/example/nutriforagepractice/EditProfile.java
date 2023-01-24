package com.example.nutriforagepractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class EditProfile extends Activity {

    EditText fullName, email, password;
    Button save, back;
    String string_fullname, string_email, string_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        save = findViewById(R.id.save);
        back = findViewById(R.id.back_button);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditProfile.this, "Saved!", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Settings.class));
                Toast.makeText(EditProfile.this, "Back", Toast.LENGTH_SHORT).show();
            }
        });


    }
}

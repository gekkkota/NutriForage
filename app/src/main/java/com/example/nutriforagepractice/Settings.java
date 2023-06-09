package com.example.nutriforagepractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class Settings extends AppCompatActivity {

    String[] languages = {"English"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapter;
    SwitchCompat switchCompat;
    Button editProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);

        adapter = new ArrayAdapter<String>(this,R.layout.list_language,languages);

        autoCompleteTextView.setAdapter(adapter);

        /*switchCompat = (SwitchCompat) findViewById(R.id.toggle_switch);*/

        editProfile = findViewById(R.id.edit_profile);

        /*switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(getApplicationContext(),"Notifications are turned ON",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Notifications are turned OFF",Toast.LENGTH_SHORT).show();
                }

            }
        });*/



        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String language = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Language is set to " + language,Toast.LENGTH_SHORT).show();
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Edit Profile", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), EditProfile.class));

            }
        });


    }



}

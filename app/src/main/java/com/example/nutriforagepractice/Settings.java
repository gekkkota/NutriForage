package com.example.nutriforagepractice;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class Settings extends AppCompatActivity {

    String[] languages = {"English", "Language1", "Language2"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapter;
    SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);

        adapter = new ArrayAdapter<String>(this,R.layout.list_language,languages);

        autoCompleteTextView.setAdapter(adapter);

        switchCompat = (SwitchCompat) findViewById(R.id.toggle_switch);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(getApplicationContext(),"Notifications are turned ON",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Notifications are turned OFF",Toast.LENGTH_SHORT).show();
                }

            }
        });



        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String language = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Language is set to " + language,Toast.LENGTH_SHORT).show();
            }
        });


    }



}

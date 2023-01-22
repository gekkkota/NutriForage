package com.example.nutriforagepractice;



import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;





import java.util.ArrayList;


public class Search extends AppCompatActivity {


    private ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    AutoCompleteTextView autoCompleteTextView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SearchView searchView = findViewById(R.id.searchView);
        searchView.clearFocus();

        listView = findViewById(R.id.listView);
        listView.setVisibility(View.GONE);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);


        arrayList = new ArrayList<>();

        arrayList.add("Item 1");
        arrayList.add("Item 2");
        arrayList.add("Item 3");
        arrayList.add("Item 4");
        arrayList.add("Item 5");
        arrayList.add("Item 6");
        arrayList.add("Item 7");
        arrayList.add("Item 8");

        adapter = new ArrayAdapter<>(this , R.layout.list_searchitem, arrayList);

        listView.setAdapter(adapter);
        autoCompleteTextView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                listView.setVisibility(View.VISIBLE);
                adapter.getFilter().filter(s);
                return false;
            }
        });

        autoCompleteTextView.setOnItemClickListener((adapterView, view, i, l) -> {
            String language = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(getApplicationContext(), "Language is set to " + language,Toast.LENGTH_SHORT).show();
        });






    }
}

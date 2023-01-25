package com.example.nutriforagepractice;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ShoppingList extends AppCompatActivity {

    //Views
    EditText mItemSL, mDescriptionSL;
    Button mSaveBtnSL, mListBtnSL;

    ImageView backBtnList;

    //progress dialog
    ProgressDialog pd;

    //Firestore instance
    FirebaseFirestore db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        //actionbar and its title


        //initialize views with its xml
        backBtnList = findViewById(R.id.back_pressed_list);
        mItemSL = findViewById(R.id.itemSL);
        mDescriptionSL = findViewById(R.id.desc_itemSL);
        mSaveBtnSL = findViewById(R.id.saveBtnSL);
        mListBtnSL = findViewById(R.id.listBtnSL);

        //progress dialog
        pd = new ProgressDialog(this);

        //firestore
        db = FirebaseFirestore.getInstance();

        //click button to upload data
        mSaveBtnSL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //input data
                String title = mItemSL.getText().toString().trim();
                String description = mDescriptionSL.getText().toString().trim();
                //function call to upload data
                uploadData(title, description);
            }
        });

        //click btn to start ListActivity
        mListBtnSL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShoppingList.this, ListActivity.class));
                finish();
            }
        });

        backBtnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent);
                finish();

            }
        });
    }


    private void uploadData(String title, String description) {
        //set title of progress bar
        pd.setTitle("Adding Data to Firestore");
        //show progress bar when user click save button
        pd.show();
        //rando id for each data to be stored
        String id= UUID.randomUUID().toString();

        Map<String, Object> doc=new HashMap<>();
        doc.put("id", id); //id of data
        doc.put("title", title);
        doc.put("description", description);

        //add this data
        db.collection("Documents").document().set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //this will be called when data is added successfully

                        pd.dismiss();
                        Toast.makeText(ShoppingList.this, "Saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //this will be called if there is any error while uploading

                        pd.dismiss();
                        //get and show error message
                        Toast.makeText(ShoppingList.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


    }

}

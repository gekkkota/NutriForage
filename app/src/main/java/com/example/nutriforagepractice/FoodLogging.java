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

public class FoodLogging extends AppCompatActivity {

    //Views
    EditText mItemLog, mDescriptionLog;
    Button mSaveBtnLog, mLogBtnLog;

    ImageView backBtnLog;

    //progress dialog
    ProgressDialog pd;

    //Firestore instance
    FirebaseFirestore db;

    String pId, pTitle, pDescription;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_logging);

        //actionbar and its title



        //initialize views with its xml
        backBtnLog = findViewById(R.id.back_pressed_log);
        mItemLog = findViewById(R.id.itemLOG);
        mDescriptionLog = findViewById(R.id.desc_itemLOG);
        mSaveBtnLog = findViewById(R.id.saveBtnLOG);
        mLogBtnLog = findViewById(R.id.listBtnLOG);

        Bundle bundle = getIntent().getExtras();
        if (bundle !=null){
            //Update data
            //actionBar.setTitle("Update");
            mSaveBtnLog.setText("Update");
            //get data
            pId = bundle.getString("pId");
            pTitle = bundle.getString("pTitle");
            pDescription = bundle.getString("pDescription");
            //set data
            mItemLog.setText(pTitle);
            mDescriptionLog.setText(pDescription);
        }
        else {
            //New Data
            //actionBar.setTitle("Add Data")
            mSaveBtnLog.setText("Save");
        }

        //progress dialog
        pd = new ProgressDialog(this);

        //firestore
        db = FirebaseFirestore.getInstance();

        //click button to upload data
        mSaveBtnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle1 = getIntent().getExtras();
                if (bundle != null){
                    //updating
                    //input data
                    String id = pId;
                    String title = mItemLog.getText().toString().trim();
                    String description = mDescriptionLog.getText().toString().trim();
                    //function call to update data
                    updateData(id, title, description);

                }
                else {
                    //adding new
                    //input data
                    String title = mItemLog.getText().toString().trim();
                    String description = mDescriptionLog.getText().toString().trim();
                    //function call to upload data
                    uploadData(title, description);
                }

            }
        });

        //click btn to start ListActivity
        mLogBtnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodLogging.this, FoodLogActivity.class));
                finish();
            }
        });

        backBtnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void updateData(String id, String title, String description) {

        //set title of progress bar
        pd.setTitle("Updating Item...");
        //show progress bar when user click save button
        pd.show();

        db.collection("Food Log").document(id)
                .update("title", title, "description", description)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //called when updated successfully
                        pd.dismiss();
                        Toast.makeText(FoodLogging.this, "Updated...", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //called when there is any error
                        pd.dismiss();
                        //get and show error message
                        Toast.makeText(FoodLogging.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }


    private void uploadData(String title, String description) {
        //set title of progress bar
        pd.setTitle("Adding Meal to your List");
        //show progress bar when user click save button
        pd.show();
        //random id for each data to be stored
        String id= UUID.randomUUID().toString();

        Map<String, Object> doc=new HashMap<>();
        doc.put("id", id); //id of data
        doc.put("title", title);
        doc.put("description", description);

        //add this data
        db.collection("Food Log").document(id).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //this will be called when data is added successfully

                        pd.dismiss();
                        Toast.makeText(FoodLogging.this, "Saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //this will be called if there is any error while uploading

                        pd.dismiss();
                        //get and show error message
                        Toast.makeText(FoodLogging.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


    }

}

package com.example.nutriforagepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FoodLogActivity extends AppCompatActivity {

    List<ModelLog> modelLog = new ArrayList<>();
    RecyclerView mRecyclerViewLog;
    //layout manager for recyclerview
    RecyclerView.LayoutManager layoutManagerLog;

    FloatingActionButton maddBtnLog;

    //firestore instance
    FirebaseFirestore db;

    CustomAdapterLog adapter;

    ProgressDialog pd;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_log);

        //init fire-store
        db = FirebaseFirestore.getInstance();

        //initialize views
        mRecyclerViewLog = findViewById(R.id.log_recycler_view);
        maddBtnLog = findViewById(R.id.addBtnLog);

        //set recycler view properties
        mRecyclerViewLog.setHasFixedSize(true);
        layoutManagerLog = new LinearLayoutManager(this);
        mRecyclerViewLog.setLayoutManager(layoutManagerLog);

        //init Progress Dialog
        pd=new ProgressDialog(this);

        //show data in recyclerView
        showData();

        //handle FloatingAction button click (Go to List)
        maddBtnLog.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodLogActivity.this, FoodLogging.class));
                finish();
            }
        });
    }

    private void showData() {
        //set title of progress dialog
        pd.setTitle("Loading Data...");
        //show progress dialog
        pd.show();

        db.collection("Food Log")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        modelLog.clear();
                        //called when data is retrieved
                        pd.dismiss();
                        //show data
                        for (DocumentSnapshot doc: task.getResult()){
                            ModelLog model = new ModelLog(doc.getString("id"),
                                    doc.getString("title"),
                                    doc.getString("description"));
                            modelLog.add(model);
                        }
                        //adapter
                        adapter = new CustomAdapterLog(FoodLogActivity.this, modelLog);
                        //set adapter to recyclerview
                        mRecyclerViewLog.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //called when there is any error while retrieving
                        pd.dismiss();

                        Toast.makeText(FoodLogActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void deleteData(int index){
        //set title of progress dialog
        pd.setTitle("Deleting Item...");
        //show progress dialog
        pd.show();

        db.collection("Food Log").document(modelLog.get(index).getId())
                .delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        //called when deleted successfully
                        Toast.makeText(FoodLogActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                        //update data
                        showData();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //called when there is any error
                        //get and show error message
                        Toast.makeText(FoodLogActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
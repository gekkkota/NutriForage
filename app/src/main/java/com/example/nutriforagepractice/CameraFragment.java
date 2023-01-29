package com.example.nutriforagepractice;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;



import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.Manifest;



public class CameraFragment extends AppCompatActivity{
    private static final int CAMERA_PERM_CODE = 10001, CAMERA_REQUEST_CODE = 100  ;
    ImageView imageView, backBtnCamera;
    Button cameraBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_camera);

        imageView = findViewById(R.id.imageview1);
        cameraBtn = findViewById(R.id.btncamera_id);
        backBtnCamera= findViewById(R.id.back_pressed_camera);

        cameraBtn.setOnClickListener(view -> askCameraPermissions());

        backBtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent);
                finish();

            }
        });
    }




    private void askCameraPermissions() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
        }
        else {
            openCamera();

        }
    }

    @Override
    public void onRequestPermissionsResult (int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERM_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();

            } else {
                Toast.makeText(this, "Camera permission is Required to use Camera", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void openCamera() {
        Toast.makeText(this, "Camera Opened", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST_CODE);

    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            assert data != null;
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(image);

        }
    }
}
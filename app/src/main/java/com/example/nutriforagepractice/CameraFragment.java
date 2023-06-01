package com.example.nutriforagepractice;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;

import com.example.nutriforagepractice.ml.Mymodel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.objects.DetectedObject;
import com.google.mlkit.vision.objects.ObjectDetection;
import com.google.mlkit.vision.objects.ObjectDetector;
import com.google.mlkit.vision.objects.defaults.ObjectDetectorOptions;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;


public class CameraFragment extends AppCompatActivity{
    private static final int CAMERA_PERM_CODE = 10001, CAMERA_REQUEST_CODE = 100  ;
    ImageView imageView, backBtnCamera;
    Button cameraBtn, galleryBtn;

    TextView result, confidence;
    int imageSize = 224;

    private ObjectDetector objectDetector;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_camera);

        imageView = findViewById(R.id.imageview1);
        cameraBtn = findViewById(R.id.btncamera_id);
        galleryBtn = findViewById(R.id.btncamera_id2);
        backBtnCamera= findViewById(R.id.back_pressed_camera);
        result = findViewById(R.id.textView6);


        //cameraBtn.setOnClickListener(view -> askCameraPermissions());

        cameraBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, 3 );
                    }
                    else{
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);

                    }
                }
            }
        });

        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 1);
            }
        });



        backBtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent);
                finish();

            }
        });
    }

    public void classifyImage(Bitmap image) {

        try {
            Mymodel model = Mymodel.newInstance(getApplicationContext());

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3 );
            byteBuffer.order(ByteOrder.nativeOrder());

            int[] intValues = new int[imageSize * imageSize];
            image.getPixels(intValues, 0, image.getWidth(), 0,0,image.getWidth(),image.getHeight());

            int pixel = 0;

            //iterate over each pixel and extract R, G, and B values
            for (int i  = 0; i < imageSize; i ++){
                for (int j  = 0 ; j < imageSize; j++){
                    int val  = intValues[pixel++];
                    byteBuffer.putFloat((((val >> 16) & 0xFF)* 1.f /1 ));
                    byteBuffer.putFloat((((val >> 8) & 0xFF)* 1.f /1 ));
                    byteBuffer.putFloat((val & 0xFF) * (1.f /1 ));
                }
            }


            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            Mymodel.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] confidence = outputFeature0.getFloatArray();
            // find the index of the class with the biggest confidence
            int maxPos = 0;
            float maxConfidence = 0;
            for (int i = 0; i < confidence.length; i++){
                if (confidence[i] > maxConfidence){
                    maxConfidence = confidence[i];
                    maxPos = i;
                }
            }
            String[] classes = {"chicken", "fruits and vegetables", "fish", "pork", "beef", "burger", "pizza", "salad", "dessert"};
            result.setText(classes[maxPos]);

            // Releases model resources if no longer used.
            model.close();
        } catch (IOException e) {
            // TODO Handle the exception
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == 3){
                Bitmap image = (Bitmap) data.getExtras().get("data");
                int dimension = Math.min(image.getWidth(), image.getHeight());
                image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);
                imageView.setImageBitmap(image);

                image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
                classifyImage(image);
            } else {
                Uri dat = data.getData();
                Bitmap image = null;
                try {
                    image = MediaStore.Images.Media.getBitmap(this. getContentResolver(), dat);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                imageView.setImageBitmap(image);

                image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    /* private void askCameraPermissions() {
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
        if (requestCode == 1 && resultCode == RESULT_OK) {
            assert data != null;
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(image);

        }
    }*/
}
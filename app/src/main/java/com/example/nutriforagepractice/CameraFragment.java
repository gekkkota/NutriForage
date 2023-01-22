package com.example.nutriforagepractice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import android.provider.MediaStore;

import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.ViewGroup;


public class CameraFragment extends Fragment {
    public static final String EXTRA_INFO = "default";
    private Button btnpicture;
    private ImageView imageView;
    private static final int Image_Capture_Code = 1;
    private static final int RESULT_OK = -1;
    private static final int RESULT_CANCELED = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);
        btnpicture = (Button) view.findViewById(R.id.btncamera_id);
        imageView = (ImageView) view.findViewById(R.id.imageview1);
        btnpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cInt,Image_Capture_Code);
            }
        });

        return view;


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Image_Capture_Code) {
            if (resultCode == RESULT_OK) {
                Bitmap bp = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bp);
            }
            else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_LONG).show();
            }


        }
}
}
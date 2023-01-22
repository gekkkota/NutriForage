package com.example.nutriforagepractice;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


public class ProfileFragment extends Fragment {

    LinearLayout profile_settings, profile_help , profile_logout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profile_settings = view.findViewById(R.id.profile_settings);
        profile_help = view.findViewById(R.id.profile_helpcenter);
        profile_logout = view.findViewById(R.id.profile_logOut);

        profile_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Settings", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),Settings.class);
                startActivity(intent);
            }
        });

        profile_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Help Center", Toast.LENGTH_SHORT).show();

            }
        });

        profile_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Logout", Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }


}
package com.example.nutriforagepractice;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Camera;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutriforagepractice.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.nutriforagepractice.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.nutriforagepractice.HelperClasses.HomeAdapter.FoodAdapter;
import com.example.nutriforagepractice.HelperClasses.HomeAdapter.FoodHelperClass;
import com.example.nutriforagepractice.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.nutriforagepractice.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {

    BottomNavigationView navigationView;
    RecyclerView featuredRecycler;
    RecyclerView mostViewedRecycler;
    RecyclerView foodRecycler;
    RecyclerView.Adapter adapter;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        navigationView = findViewById(R.id.bottom_navigation);


        navigationView.setSelectedItemId(R.id.nav_home);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){

                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                        overridePendingTransition(0,0);
                        finish();

                    case R.id.nav_log:
                        fragment = new LogFragment();
                        break;

                    case R.id.nav_camera:
                        fragment = new CameraFragment();
                        break;

                    case R.id.nav_list:
                        fragment = new ListFragment();
                        break;

                    case R.id.nav_profile:
                        fragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
                return true;
            }

        });

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);

        featuredRecycler();

        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);

        mostViewedRecycler();

        foodRecycler = findViewById(R.id.food_recycler);

        foodRecycler();
    }

    private void foodRecycler() {

        foodRecycler.setHasFixedSize(true);
        foodRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FoodHelperClass> foodCategory = new ArrayList<>();

        foodCategory.add(new FoodHelperClass(R.drawable.logo_black, "Vegan Foods", "Authentic chicken adobo is usually made with chicken thighs and legs, or a cut-up whole chicken served over white rice."));
        foodCategory.add(new FoodHelperClass(R.drawable.meat_food, "Pork Meat Foods", "A ground pork and green bean dish cooked in coconut milk. Shrimp paste (bagoong) is used to enhance the flavor."));
        foodCategory.add(new FoodHelperClass(R.drawable.chicken_food, "Chciken Meat Foods", "Savoury ginger-based broth soup, filled with sauteed tofu, green papaya and nutritious chilli pepper leaves."));


        adapter = new FoodAdapter(foodCategory);
        foodRecycler.setAdapter(adapter);

        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});
    }

    private void mostViewedRecycler() {


            mostViewedRecycler.setHasFixedSize(true);
            mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

            ArrayList<MostViewedHelperClass> mostViewedRecipes = new ArrayList<>();

            mostViewedRecipes.add(new MostViewedHelperClass(R.drawable.adobo_img, "Healthier Chicken Adobo Recipe", "Authentic chicken adobo is usually made with chicken thighs and legs, served over white rice."));
            mostViewedRecipes.add(new MostViewedHelperClass(R.drawable.gising_img, "Gising-gising Recipe", "A ground pork and green bean dish cooked in coconut milk. Shrimp paste (bagoong) is used to enhance the flavor."));
            mostViewedRecipes.add(new MostViewedHelperClass(R.drawable.tofu_tinola_img, "Tofu Tinola Recipe", "Savoury ginger-based broth soup, filled with sauteed tofu, green papaya and nutritious chilli pepper leaves."));


            adapter = new MostViewedAdapter(mostViewedRecipes);
            mostViewedRecycler.setAdapter(adapter);

            GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }

    //Recipes CardView

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredRecipes = new ArrayList<>();

        featuredRecipes.add(new FeaturedHelperClass(R.drawable.adobo_img, "Chicken Adobo Recipe", "Authentic chicken adobo is usually made with chicken thighs and legs, or a cut-up whole chicken served over white rice."));
        featuredRecipes.add(new FeaturedHelperClass(R.drawable.gising_img, "Gising-gising Recipe", "A ground pork and green bean dish cooked in coconut milk. Shrimp paste (bagoong) is used to enhance the flavor."));
        featuredRecipes.add(new FeaturedHelperClass(R.drawable.tofu_tinola_img, "Tofu Tinola Recipe", "Savoury ginger-based broth soup, filled with sauteed tofu, green papaya and nutritious chilli pepper leaves."));


        adapter = new FeaturedAdapter(featuredRecipes);
        featuredRecycler.setAdapter(adapter);

        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }


}
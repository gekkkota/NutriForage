package com.example.nutriforagepractice;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Camera;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutriforagepractice.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.nutriforagepractice.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.nutriforagepractice.HelperClasses.HomeAdapter.FoodAdapter;
import com.example.nutriforagepractice.HelperClasses.HomeAdapter.FoodHelperClass;
import com.example.nutriforagepractice.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.nutriforagepractice.HelperClasses.HomeAdapter.MostViewedHelperClass;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    //Variables
    static final float END_SCALE = 0.7f;


    RecyclerView featuredRecycler, mostViewedRecycler, foodRecycler;
    RecyclerView.Adapter adapter;
    ImageView menuIcon;
    LinearLayout contentView;
    RelativeLayout searchBar;

    TextView viewAllCategories, viewAllRecipes;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationViewbar;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);


        //Search Bar
        searchBar = findViewById(R.id.search_bar);




        viewAllRecipes= findViewById(R.id.view_all_recipes);



        viewAllRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AllRecipes.class);
                startActivity(intent);
                finish();
            }
        });





        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);

        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);



        menuIcon = findViewById(R.id.menu_icon);

        contentView = findViewById(R.id.content);

        //Recycler Views Function Calls
        featuredRecycler();
        mostViewedRecycler();

        //Search Bar
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserDashboard.this, "Search", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserDashboard.this, Search.class));
            }
        });



        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationViewbar = findViewById(R.id.navigation_view_bar);

        navigationDrawer();

    }

    //Navigation Drawer Functions
    private void navigationDrawer() {

        //Navigation Drawer
        navigationViewbar.bringToFront();
        navigationViewbar.setNavigationItemSelectedListener(this);
        navigationViewbar.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        //Optional for bg color
        drawerLayout.setScrimColor(getResources().getColor(R.color.navdrawer1));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaleOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaleOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaleOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);

            }
        });

    }

    @SuppressLint("SuspiciousIndentation")
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){

            case R.id.drawer_recipes:
                startActivity(new Intent(getApplicationContext(),AllRecipes.class));
                break;

            case R.id.drawer_log:
                startActivity(new Intent(getApplicationContext(),FoodLogging.class));
                break;

            case R.id.drawer_home:
                startActivity(new Intent(getApplicationContext(),UserDashboard.class));
                break;

            case R.id.drawer_list:
                startActivity(new Intent(getApplicationContext(),ShoppingList.class));
                break;


            case R.id.drawer_camera:
                startActivity(new Intent(getApplicationContext(),CameraFragment.class));
                break;

            case R.id.drawer_profile:
                startActivity(new Intent(getApplicationContext(),ProfileFragment.class));
                break;

            case R.id.drawer_search:
                startActivity(new Intent(getApplicationContext(),Search.class));
                break;

            case R.id.drawer_login:

            case R.id.drawer_logout:
                startActivity(new Intent(getApplicationContext(),SignIn.class));
                break;
        }
        return true;
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
    private void mostViewedRecycler() {


        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedRecipes = new ArrayList<>();

        mostViewedRecipes.add(new MostViewedHelperClass(R.drawable.r_lemon_garlic_shrimp, "Lemon-Garlic Shrimp and Grits", "Shrimp and grits is an iconic Southern dish and easy to make at home."));
        mostViewedRecipes.add(new MostViewedHelperClass(R.drawable.r_bacon_egg_cups, "Whole30 Bacon and Egg Cups", "Everything you've ever craved from a diner breakfast is present in this Whole30-friendly recipe, which is easy to prepare for a crowd."));
        mostViewedRecipes.add(new MostViewedHelperClass(R.drawable.r_pork_tacos, "Slow-Cooker Pork Tacos", "It's impossible to resist flavorful and tender pork shoulder after it's been slowly simmered in chicken broth and aromatic spices."));


        adapter = new MostViewedAdapter(mostViewedRecipes);
        mostViewedRecycler.setAdapter(adapter);

        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }


    public void callRetailerScreens(View view) {

        startActivity(new Intent(getApplicationContext(), SignIn.class));

    }
}

package com.example.nutriforagepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    private TextView mRecipeName;
    private TextView mRecipeIngredients;
    private TextView mRecipeMethodTitle;
    private TextView mRecipe;

    ImageView backBtnRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        backBtnRecipes = findViewById(R.id.back_pressed_recipes);
        mRecipeName = (TextView)findViewById(R.id.text_recipe);
        mRecipeIngredients = (TextView)findViewById(R.id.ingredients);
        mRecipeMethodTitle = (TextView)findViewById(R.id.method);
        mRecipe = (TextView)findViewById(R.id.recipe);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("RecipeName");
        String Ingredients = intent.getExtras().getString("RecipeIngredients");
        String MethodTitle = intent.getExtras().getString("RecipeMethodTitle");
        String Recipe = intent.getExtras().getString("Recipe");

        mRecipeName.setText(Title);
        mRecipeIngredients.setText(Ingredients);
        mRecipeMethodTitle.setText(MethodTitle);
        mRecipe.setText(Recipe);


        backBtnRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AllRecipes.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
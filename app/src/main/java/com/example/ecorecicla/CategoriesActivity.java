package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_activity);

        findViewById(R.id.btnPlastic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterMaterialActivity("Plástico");
            }
        });

        findViewById(R.id.btnPaper).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterMaterialActivity("Papel");
            }
        });
    }

    private void openRegisterMaterialActivity(String material) {
        Intent intent = new Intent(CategoriesActivity.this, RegisterMaterialActivity.class);
        intent.putExtra("material", material);
        startActivity(intent);
    }
}


package com.example.ecorecicla;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterMaterialActivity extends AppCompatActivity {

    private TextView tvMaterial;
    private EditText etQuantity;
    private EditText etValue;
    private EditText etMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_material_activity);

        tvMaterial = findViewById(R.id.tvMaterial);
        etQuantity = findViewById(R.id.etQuantity);
        etValue = findViewById(R.id.etValue);
        etMonth = findViewById(R.id.etMonth);

        // Obtén el material seleccionado desde el intent
        String material = getIntent().getStringExtra("material");
        tvMaterial.setText(material);

        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerMaterial();
            }
        });
    }

    private void registerMaterial() {
        String quantity = etQuantity.getText().toString();
        String value = etValue.getText().toString();
        String month = etMonth.getText().toString();

        if (!quantity.isEmpty() && !value.isEmpty() && !month.isEmpty()) {
            // Aquí puedes agregar la lógica para registrar el material (e.g., guardar en una base de datos)
            Toast.makeText(this, "Material registrado exitosamente", Toast.LENGTH_SHORT).show();
            finish(); // Finaliza la actividad y vuelve a la actividad anterior
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}

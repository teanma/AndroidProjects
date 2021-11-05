package com.example.spinnerfruits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static final String[] fruits = {"Aguacates", "Cerezas", "Fresas", "Manzanas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarFrutas();
    }

    public void cargarFrutas() {
        ArrayAdapter<String> adapterFruits = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fruits);

        Spinner spinFruits = (Spinner) findViewById(R.id.spin_fruits);

        spinFruits.setAdapter(adapterFruits);
    }

    public void showFruits(View v) {
        
    }
}
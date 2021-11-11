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

    Spinner spinFruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] fruits = {"Frutas", "Aguacates", "Cerezas", "Fresas", "Manzanas"};

        ArrayAdapter<String> adapterFruits = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, fruits);

        spinFruits = (Spinner) findViewById(R.id.spin_fruits);

        spinFruits.setAdapter(adapterFruits);
    }

    public void showFruits(View v) {

        ImageView ivFruits = (ImageView) findViewById(R.id.iv_fruta);

        switch (spinFruits.getSelectedItem().toString()) {
            case "Frutas":
                ivFruits.setImageResource(R.drawable.fruta);
                Toast.makeText(this, "Cargando frutas", Toast.LENGTH_SHORT).show();
                break;
            case "Aguacates":
                ivFruits.setImageResource(R.drawable.aguacates);
                Toast.makeText(this, "Cargando aguacates", Toast.LENGTH_SHORT).show();
                break;
            case "Cerezas":
                ivFruits.setImageResource(R.drawable.cerezas);
                Toast.makeText(this, "Cargando cerezas", Toast.LENGTH_SHORT).show();
                break;
            case "Fresas":
                ivFruits.setImageResource(R.drawable.fresas);
                Toast.makeText(this, "Cargando fresas", Toast.LENGTH_SHORT).show();
                break;
            case "Manzanas":
                ivFruits.setImageResource(R.drawable.manzanas);
                Toast.makeText(this, "Cargando manzanas", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
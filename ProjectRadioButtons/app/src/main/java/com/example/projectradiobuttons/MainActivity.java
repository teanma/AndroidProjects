package com.example.projectradiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cargarResolucion1080(View v) {
        RadioButton rb1080p = findViewById(R.id.rb_1080p);

        if (rb1080p.isChecked()) {
            Toast.makeText(this, "Cargando vídeo en 1080p...", Toast.LENGTH_SHORT).show();
        }
    }

    public void cargarResolucion(View v) {
        RadioGroup rg_resolucion = (RadioGroup) findViewById(R.id.rg_resoluciones);
        switch (rg_resolucion.getCheckedRadioButtonId()) {
            case R.id.rb_480p:
                Toast.makeText(this, "Has seleccionado 480p", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_720p:
                Toast.makeText(this, "Has seleccionado 720p", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_1080p:
                Toast.makeText(this, "Has seleccionado 1080p", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void cargarSexo(View v) {

    }
}
package com.example.formulariodeportivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent pantallaPrincipal = getIntent();

        String name = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_NAME);
        String surname = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_SURNAME);
        String phone = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_PHONE);
        String email = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_EMAIL);
        String portero = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_PORTERO);
        String defensa = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_DEFENSA);
        String medio = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_MEDIO);
        String delantero = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_DELANTERO);
        String base = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_BASE);
        String escolta = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_ESCOLTA);
        String alero = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_ALERO);
        String pivot = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_PIVOT);


    }
}
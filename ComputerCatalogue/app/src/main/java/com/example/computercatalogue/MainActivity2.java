package com.example.computercatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    protected static final String MAINACTIVITY2_PORTATILES_10000 = "com.example.computercatalogue.portatiles_10000";
    protected static final String MAINACTIVITY2_PORTATIL_ASUS_10000_1 = "com.example.computercatalogue.portatil_asus_10000_1";
    protected static final String MAINACTIVITY2_PORTATIL_THOMSON_10000_2 = "com.example.computercatalogue.portatil_thomson_10000_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void volver(View v) {
        Intent pantallaPrincipal = new Intent(this, MainActivity.class);
        startActivity(pantallaPrincipal);
    }

    public void verDetalleAsus(View v) {

        String portatilAsus = "10000_1";
        String portatiles = "10000";

        Intent pantallaDetalleAsus = new Intent(this, MainActivity4.class);
        pantallaDetalleAsus.putExtra(MAINACTIVITY2_PORTATIL_ASUS_10000_1, portatilAsus);
        pantallaDetalleAsus.putExtra(MAINACTIVITY2_PORTATILES_10000, portatiles);
        startActivity(pantallaDetalleAsus);
    }

    public void verDetalleThomson(View v) {

        String portatilThomson = "10000_2";
        String portatiles = "10000";

        Intent pantallaDetalleThomson = new Intent(this, MainActivity4.class);
        pantallaDetalleThomson.putExtra(MAINACTIVITY2_PORTATIL_THOMSON_10000_2, portatilThomson);
        pantallaDetalleThomson.putExtra(MAINACTIVITY2_PORTATILES_10000, portatiles);
        startActivity(pantallaDetalleThomson);
    }
}
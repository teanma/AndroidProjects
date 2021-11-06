package com.example.computercatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    protected static final String MAINACTIVITY_PORTATILES_10000 = "com.example.computercatalogue.portatiles_10000";
    protected static final String MAINACTIVITY2_PORTATIL_ASUS_10000_1 = "com.example.computercatalogue.codigo_portatil";
    protected static final String MAINACTIVITY2_PORTATIL_THOMSON_10000_2 = "com.example.computercatalogue.codigo_portatil";

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

        String codigoAsus = "10000_1";
        String codigoPortatil = "10000";

        Intent pantallaDetalleAsus = new Intent(this, MainActivity4.class);

        pantallaDetalleAsus.putExtra(MAINACTIVITY2_PORTATIL_ASUS_10000_1, codigoAsus);
        pantallaDetalleAsus.putExtra(MAINACTIVITY_PORTATILES_10000, codigoPortatil);

        startActivity(pantallaDetalleAsus);
    }

    public void verDetalleThomson(View v) {

        String codigoThomson = "10000_2";
        String codigoPortatil = "10000";

        Intent pantallaDetalleThomson = new Intent(this, MainActivity4.class);

        pantallaDetalleThomson.putExtra(MAINACTIVITY2_PORTATIL_THOMSON_10000_2, codigoThomson);
        pantallaDetalleThomson.putExtra(MAINACTIVITY_PORTATILES_10000, codigoPortatil);

        startActivity(pantallaDetalleThomson);
    }
}
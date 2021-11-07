package com.example.computercatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LaptopCatalogue extends AppCompatActivity {

    protected static final String COMPUTERCATALOGUE_PORTATILES_10000 = "com.example.computercatalogue.portatiles_10000";
    protected static final String COMPUTERCATALOGUE_CATEGORIA_PORTATILES = "com.example.computercatalogue.categoria_portatiles";
    protected static final String LAPTOPCATALOGUE_PORTATIL_ASUS_10000_1 = "com.example.computercatalogue.codigo_portatil";
    protected static final String LAPTOPCATALOGUE_PORTATIL_THOMSON_10000_2 = "com.example.computercatalogue.codigo_portatil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laptop_catalogue);
    }

    public void volver(View v) {
        Intent pantallaPrincipal = new Intent(this, ComputerCatalogue.class);
        startActivity(pantallaPrincipal);
    }

    public void verDetalleAsus(View v) {

        String categoria = "Portátiles";
        String codigoAsus = "10000_1";
        String codigoPortatil = "10000";

        Intent pantallaDetalleAsus = new Intent(this, LaptopDetail.class);

        pantallaDetalleAsus.putExtra(COMPUTERCATALOGUE_CATEGORIA_PORTATILES, categoria);
        pantallaDetalleAsus.putExtra(LAPTOPCATALOGUE_PORTATIL_ASUS_10000_1, codigoAsus);
        pantallaDetalleAsus.putExtra(COMPUTERCATALOGUE_PORTATILES_10000, codigoPortatil);

        startActivity(pantallaDetalleAsus);
    }

    public void verDetalleThomson(View v) {

        String categoria = "Portátiles";
        String codigoThomson = "10000_2";
        String codigoPortatil = "10000";

        Intent pantallaDetalleThomson = new Intent(this, LaptopDetail.class);

        pantallaDetalleThomson.putExtra(COMPUTERCATALOGUE_CATEGORIA_PORTATILES, categoria);
        pantallaDetalleThomson.putExtra(LAPTOPCATALOGUE_PORTATIL_THOMSON_10000_2, codigoThomson);
        pantallaDetalleThomson.putExtra(COMPUTERCATALOGUE_PORTATILES_10000, codigoPortatil);

        startActivity(pantallaDetalleThomson);
    }
}
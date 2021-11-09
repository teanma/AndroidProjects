package com.example.computercatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ComputerCatalogue extends AppCompatActivity {

    protected static final String COMPUTERCATALOGUE_PORTATILES_10000 = "com.example.computercatalogue.portatiles_10000";
    protected static final String COMPUTERCATALOGUE_CATEGORIA_PORTATILES = "com.example.computercatalogue.categoria_portatiles";
    protected static final String COMPUTERCATALOGUE_SOBREMESAS_20000 = "com.example.computercatalogue.sobremesas_20000";
    protected static final String COMPUTERCATALOGUE_CATEGORIA_SOBREMESAS = "com.example.computercatalogue.categoria_sobremesas";

    ImageButton ib_ordenadores;
    ImageButton ib_portatiles, ib_sobremesas;
    Button btn_ver_portatiles, btn_ver_sobremesas;

    protected boolean isCategoryVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.computer_catalogue);

        inicializar();

        ib_portatiles.setVisibility(View.GONE);
        btn_ver_portatiles.setVisibility(View.GONE);
        ib_sobremesas.setVisibility(View.GONE);
        btn_ver_sobremesas.setVisibility(View.GONE);

        isCategoryVisible = false;
    }

    public void inicializar() {
        ib_ordenadores = (ImageButton) findViewById(R.id.ib_ordenadores);
        ib_portatiles = (ImageButton) findViewById(R.id.ib_portatiles);
        ib_sobremesas = (ImageButton) findViewById(R.id.ib_sobremesas);
        btn_ver_portatiles = (Button) findViewById(R.id.btn_ver_portatiles);
        btn_ver_sobremesas = (Button) findViewById(R.id.btn_ver_sobremesas);
    }

    public void mostrarCategoria(View v) {
        if (isCategoryVisible) {
            ib_portatiles.setVisibility(View.GONE);
            btn_ver_portatiles.setVisibility(View.GONE);
            ib_sobremesas.setVisibility(View.GONE);
            btn_ver_sobremesas.setVisibility(View.GONE);
            Toast.makeText(this, "Has ocultado los catálogos", Toast.LENGTH_SHORT).show();
            isCategoryVisible = false;
        } else {
            ib_portatiles.setVisibility(View.VISIBLE);
            btn_ver_portatiles.setVisibility(View.VISIBLE);
            ib_sobremesas.setVisibility(View.VISIBLE);
            btn_ver_sobremesas.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Has mostrado los catálogos", Toast.LENGTH_SHORT).show();
            isCategoryVisible = true;
        }
    }

    public void mostrarPortatiles(View v) {

        String codigoPortatil = "10000";
        String categoria = "Portátiles";

        Intent pantallaPortatiles = new Intent(this, LaptopCategory.class);
        pantallaPortatiles.putExtra(COMPUTERCATALOGUE_PORTATILES_10000, codigoPortatil);
        pantallaPortatiles.putExtra(COMPUTERCATALOGUE_CATEGORIA_PORTATILES, categoria);
        startActivity(pantallaPortatiles);
    }

    public void mostrarSobremesas(View v) {

        String codigoSobremesa = "20000";
        String categoria = "Sobremesas";

        Intent pantallaSobremesas = new Intent(this, DesktopCategory.class);
        pantallaSobremesas.putExtra(COMPUTERCATALOGUE_SOBREMESAS_20000, codigoSobremesa);
        pantallaSobremesas.putExtra(COMPUTERCATALOGUE_CATEGORIA_SOBREMESAS, categoria);
        startActivity(pantallaSobremesas);
    }
}
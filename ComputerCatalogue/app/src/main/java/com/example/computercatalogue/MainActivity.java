package com.example.computercatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static final String MAINACTIVITY_PORTATILES_10000 = "com.example.computercatalogue.portatiles_10000";
    protected static final String MAINACTIVITY_CATEGORIA_PORTATILES = "com.example.computercatalogue.categoria_portatiles";
    protected static final String MAINACTIVITY_SOBREMESAS_20000 = "com.example.computercatalogue.sobremesas_20000";
    protected static final String MAINACTIVITY_CATEGORIA_SOBREMESAS = "com.example.computercatalogue.categoria_sobremesas";

    ImageButton ib_ordenadores;
    ImageView iv_portatiles, iv_sobremesas;
    Button btn_ver_portatiles, btn_ver_sobremesas;

    protected boolean isCategoryVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();

        iv_portatiles.setVisibility(View.GONE);
        btn_ver_portatiles.setVisibility(View.GONE);
        iv_sobremesas.setVisibility(View.GONE);
        btn_ver_sobremesas.setVisibility(View.GONE);

        isCategoryVisible = false;
    }

    public void inicializar() {
        ib_ordenadores = (ImageButton) findViewById(R.id.ib_ordenadores);
        iv_portatiles = (ImageView) findViewById(R.id.iv_portatiles);
        iv_sobremesas = (ImageView) findViewById(R.id.iv_sobremesas);
        btn_ver_portatiles = (Button) findViewById(R.id.btn_ver_portatiles);
        btn_ver_sobremesas = (Button) findViewById(R.id.btn_ver_sobremesas);
    }

    public void mostrarCategoria(View v) {
        if (isCategoryVisible) {
            iv_portatiles.setVisibility(View.GONE);
            btn_ver_portatiles.setVisibility(View.GONE);
            iv_sobremesas.setVisibility(View.GONE);
            btn_ver_sobremesas.setVisibility(View.GONE);
            Toast.makeText(this, "Has ocultado los catálogos", Toast.LENGTH_SHORT).show();
            isCategoryVisible = false;
        } else {
            iv_portatiles.setVisibility(View.VISIBLE);
            btn_ver_portatiles.setVisibility(View.VISIBLE);
            iv_sobremesas.setVisibility(View.VISIBLE);
            btn_ver_sobremesas.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Has mostrado los catálogos", Toast.LENGTH_SHORT).show();
            isCategoryVisible = true;
        }
    }

    public void mostrarPortatiles(View v) {

        String codigoPortatil = "10000";
        String categoria = "Portátiles";

        Intent pantallaSecundaria = new Intent(this, MainActivity2.class);
        pantallaSecundaria.putExtra(MAINACTIVITY_PORTATILES_10000, codigoPortatil);
        pantallaSecundaria.putExtra(MAINACTIVITY_CATEGORIA_PORTATILES, categoria);
        startActivity(pantallaSecundaria);
    }

    public void mostrarSobremesas(View v) {

        String codigoSobremesa = "20000";
        String categoria = "Sobremesas";

        Intent pantallaTernaria = new Intent(this, MainActivity3.class);
        pantallaTernaria.putExtra(MAINACTIVITY_SOBREMESAS_20000, codigoSobremesa);
        pantallaTernaria.putExtra(MAINACTIVITY_CATEGORIA_SOBREMESAS, categoria);
        startActivity(pantallaTernaria);
    }
}
package com.example.computercatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    protected static final String MAINACTIVITY_SOBREMESAS_20000 = "com.example.computercatalogue.sobremesas_20000";
    protected static final String MAINACTIVITY_CATEGORIA_SOBREMESAS = "com.example.computercatalogue.categoria_sobremesas";
    protected static final String MAINACTIVITY3_SOBREMESA_DELL_20000_1 = "com.example.computercatalogue.codigo_sobremesa";
    protected static final String MAINACTIVITY3_SOBREMESA_HP_20000_2 = "com.example.computercatalogue.codigo_sobremesa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void volver(View v) {
        Intent pantallaPrincipal = new Intent(this, MainActivity.class);
        startActivity(pantallaPrincipal);
    }

    public void verDetalleDell(View v) {

        String categoria = "Sobremesas";
        String sobremesaDell = "20000_1";
        String sobremesas = "20000";

        Intent pantallaDetalleDell = new Intent(this, MainActivity5.class);
        pantallaDetalleDell.putExtra(MAINACTIVITY_CATEGORIA_SOBREMESAS, categoria);
        pantallaDetalleDell.putExtra(MAINACTIVITY3_SOBREMESA_DELL_20000_1, sobremesaDell);
        pantallaDetalleDell.putExtra(MAINACTIVITY_SOBREMESAS_20000, sobremesas);
        startActivity(pantallaDetalleDell);
    }

    public void verDetalleHp(View v) {

        String categoria = "Sobremesas";
        String sobremesaHp = "20000_2";
        String sobremesas = "20000";

        Intent pantallaDetalleHp = new Intent(this, MainActivity5.class);
        pantallaDetalleHp.putExtra(MAINACTIVITY_CATEGORIA_SOBREMESAS, categoria);
        pantallaDetalleHp.putExtra(MAINACTIVITY3_SOBREMESA_HP_20000_2, sobremesaHp);
        pantallaDetalleHp.putExtra(MAINACTIVITY_SOBREMESAS_20000, sobremesas);
        startActivity(pantallaDetalleHp);
    }
}
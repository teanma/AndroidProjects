package com.example.computercatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DesktopCatalogue extends AppCompatActivity {

    protected static final String COMPUTERCATALOGUE_SOBREMESAS_20000 = "com.example.computercatalogue.sobremesas_20000";
    protected static final String COMPUTERCATALOGUE_CATEGORIA_SOBREMESAS = "com.example.computercatalogue.categoria_sobremesas";
    protected static final String DESKTOPCATALOGUE_SOBREMESA_DELL_20000_1 = "com.example.computercatalogue.codigo_sobremesa";
    protected static final String DESKTOPCATALOGUE_SOBREMESA_HP_20000_2 = "com.example.computercatalogue.codigo_sobremesa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desktop_catalogue);
    }

    public void volver(View v) {
        Intent pantallaPrincipal = new Intent(this, ComputerCatalogue.class);
        startActivity(pantallaPrincipal);
    }

    public void verDetalleDell(View v) {

        String categoria = "Sobremesas";
        String sobremesaDell = "20000_1";
        String sobremesas = "20000";

        Intent pantallaDetalleDell = new Intent(this, DesktopDetail.class);
        pantallaDetalleDell.putExtra(COMPUTERCATALOGUE_CATEGORIA_SOBREMESAS, categoria);
        pantallaDetalleDell.putExtra(DESKTOPCATALOGUE_SOBREMESA_DELL_20000_1, sobremesaDell);
        pantallaDetalleDell.putExtra(COMPUTERCATALOGUE_SOBREMESAS_20000, sobremesas);
        startActivity(pantallaDetalleDell);
    }

    public void verDetalleHp(View v) {

        String categoria = "Sobremesas";
        String sobremesaHp = "20000_2";
        String sobremesas = "20000";

        Intent pantallaDetalleHp = new Intent(this, DesktopDetail.class);
        pantallaDetalleHp.putExtra(COMPUTERCATALOGUE_CATEGORIA_SOBREMESAS, categoria);
        pantallaDetalleHp.putExtra(DESKTOPCATALOGUE_SOBREMESA_HP_20000_2, sobremesaHp);
        pantallaDetalleHp.putExtra(COMPUTERCATALOGUE_SOBREMESAS_20000, sobremesas);
        startActivity(pantallaDetalleHp);
    }
}
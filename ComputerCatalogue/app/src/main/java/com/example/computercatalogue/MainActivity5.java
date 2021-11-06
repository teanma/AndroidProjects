package com.example.computercatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    Button btn_home, btn_sobremesas;
    TextView tv_nombre, tv_precio, tv_res_marca, tv_res_codigo, tv_res_cantidad;
    ImageView iv_detalle_sobremesa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        inicializar();

        Intent intent = getIntent();

        String codigoDell = intent.getStringExtra(MainActivity3.MAINACTIVITY3_SOBREMESA_DELL_20000_1);
        String codigoHp = intent.getStringExtra(MainActivity3.MAINACTIVITY3_SOBREMESA_HP_20000_2);

        if(codigoDell.equals("20000_1")) {
            String nombre = "Dell Ordenador Sobremesa CGRR2 i3-10105/8GB/256GB SSD";
            String precio = "547.99$";
            String marca = "Dell";
            String cantidad = "1";

            tv_nombre.setText(nombre);
            tv_precio.setText(precio);
            tv_res_marca.setText(marca);
            tv_res_codigo.setText(codigoDell);
            tv_res_cantidad.setText(cantidad);
        }
        if(codigoHp.equals("20000_2")) {
            String nombre = "HP Ordenador Sobremesa 290 G3 SFF i5-10500/8GB/256GB SSD";
            String precio = "637.99$";
            String marca = "HP";
            String cantidad = "1";

            tv_nombre.setText(nombre);
            tv_precio.setText(precio);
            tv_res_marca.setText(marca);
            tv_res_codigo.setText(codigoHp);
            tv_res_cantidad.setText(cantidad);
        }
    }

    public void inicializar() {

        btn_home = (Button) findViewById(R.id.btn_home_sobremesa);
        btn_sobremesas = (Button) findViewById(R.id.btn_sobremesas);

        tv_nombre = (TextView) findViewById(R.id.tv_nombre_sobremesa);
        tv_precio = (TextView) findViewById(R.id.tv_precio_sobremesa);
        tv_res_marca = (TextView) findViewById(R.id.tv_res_marca_sobremesa);
        tv_res_codigo = (TextView) findViewById(R.id.tv_res_codigo_sobremesa);
        tv_res_cantidad = (TextView) findViewById(R.id.tv_res_cantidad_sobremesa);

        iv_detalle_sobremesa = (ImageView) findViewById(R.id.iv_detalle_sobremesa);
    }

    public void volverAHome(View v) {
        Intent pantallaPrincipal = new Intent(this, MainActivity.class);
        startActivity(pantallaPrincipal);
    }

    public void volverASobremesas(View v) {
        Intent pantallaSobremesas = new Intent(this, MainActivity3.class);
        startActivity(pantallaSobremesas);
    }
}
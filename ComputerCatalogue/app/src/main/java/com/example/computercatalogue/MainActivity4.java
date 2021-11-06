package com.example.computercatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    Button btn_home, btn_portatiles;
    TextView tv_nombre, tv_precio, tv_res_marca, tv_res_codigo, tv_res_cantidad;
    ImageView iv_detalle_portatil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        inicializar();

        Intent intent = getIntent();

        String codigoAsus = intent.getStringExtra(MainActivity2.MAINACTIVITY2_PORTATIL_ASUS_10000_1);
        String codigoThomson = intent.getStringExtra(MainActivity2.MAINACTIVITY2_PORTATIL_THOMSON_10000_2);

        if(codigoAsus.equals("10000_1")) {
            String nombre = "Asus E410MA-EK007TS, 14'' FHD, Intel® Celeron® N4020, 4 GB RAM, 64 GB eMMC, Graphics 600, W10S";
            String precio = "284$";
            String marca = "Asus";
            String cantidad = "1";

            tv_nombre.setText(nombre);
            tv_precio.setText(precio);
            tv_res_marca.setText(marca);
            tv_res_codigo.setText(codigoAsus);
            tv_res_cantidad.setText(cantidad);
        }
        if(codigoThomson.equals("10000_2")) {
            String nombre = "Thomson NEO Z3, 12.5 pulgadas FHD, LTE 4G, Qualcomm® Snapdragon™ 850, 8GB RAM, 256GB Flash, Adreno 630, W10";
            String precio = "399$";
            String marca = "Thomson";
            String cantidad = "1";

            tv_nombre.setText(nombre);
            tv_precio.setText(precio);
            tv_res_marca.setText(marca);
            tv_res_codigo.setText(codigoThomson);
            tv_res_cantidad.setText(cantidad);
        }
    }

    public void inicializar() {

        btn_home = (Button) findViewById(R.id.btn_home_portatil);
        btn_portatiles = (Button) findViewById(R.id.btn_portatiles);

        tv_nombre = (TextView) findViewById(R.id.tv_nombre_portatil);
        tv_precio = (TextView) findViewById(R.id.tv_precio_portatil);
        tv_res_marca = (TextView) findViewById(R.id.tv_res_marca_portatil);
        tv_res_codigo = (TextView) findViewById(R.id.tv_res_codigo_portatil);
        tv_res_cantidad = (TextView) findViewById(R.id.tv_res_cantidad_portatil);

        iv_detalle_portatil = (ImageView) findViewById(R.id.iv_detalle_portatil);
    }

    public void volverAHome(View v) {
        Intent pantallaPrincipal = new Intent(this, MainActivity.class);
        startActivity(pantallaPrincipal);
    }

    public void volverAPortatiles(View v) {
        Intent pantallaPortatiles = new Intent(this, MainActivity2.class);
        startActivity(pantallaPortatiles);
    }
}
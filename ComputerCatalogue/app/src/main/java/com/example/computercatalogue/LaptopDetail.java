package com.example.computercatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LaptopDetail extends AppCompatActivity {

    Button btn_home, btn_portatiles;
    TextView tv_nombre, tv_precio, tv_res_categoria, tv_res_codigo, tv_res_codigo_producto, tv_res_modelo, tv_res_stock;
    ImageView iv_detalle_portatil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laptop_detail);
        inicializar();
        mostrarDetalle();
    }

    public void inicializar() {

        btn_home = (Button) findViewById(R.id.btn_home_portatil);
        btn_portatiles = (Button) findViewById(R.id.btn_portatiles);

        tv_nombre = (TextView) findViewById(R.id.tv_nombre_portatil);
        tv_precio = (TextView) findViewById(R.id.tv_precio_portatil);
        tv_res_categoria = (TextView) findViewById(R.id.tv_res_categoria_portatil);
        tv_res_codigo = (TextView) findViewById(R.id.tv_res_codigo_portatil);
        tv_res_codigo_producto = (TextView) findViewById(R.id.tv_res_codigo_producto_portatil);
        tv_res_modelo = (TextView) findViewById(R.id.tv_res_modelo_portatil);
        tv_res_stock = (TextView) findViewById(R.id.tv_res_stock_portatil);

        iv_detalle_portatil = (ImageView) findViewById(R.id.iv_detalle_portatil);
    }

    public void mostrarDetalle() {

        Intent intent = getIntent();

        String codigoPortatil = intent.getStringExtra(ComputerCatalogue.COMPUTERCATALOGUE_PORTATILES_10000);
        String categoriaPortatil = intent.getStringExtra(ComputerCatalogue.COMPUTERCATALOGUE_CATEGORIA_PORTATILES);
        String codigoAsus = intent.getStringExtra(LaptopCategory.LAPTOPCATEGORY_PORTATIL_ASUS_10000_1);
        String codigoThomson = intent.getStringExtra(LaptopCategory.LAPTOPCATEGORY_PORTATIL_THOMSON_10000_2);

        if(codigoAsus.equals("10000_1")) {
            iv_detalle_portatil.setImageResource(R.drawable.portatil_asus);
            String nombre = "Asus E410MA-EK007TS, 14'' FHD, Intel® Celeron® N4020, 4 GB RAM, 64 GB eMMC, Graphics 600, W10S";
            String precio = "284$";
            String modelo = "E410MA-EK007TS";
            String stock = "3";

            tv_nombre.setText(nombre);
            tv_precio.setText(precio);
            tv_res_categoria.setText(categoriaPortatil);
            tv_res_codigo.setText(codigoPortatil);
            tv_res_codigo_producto.setText(codigoAsus);
            tv_res_modelo.setText(modelo);
            tv_res_stock.setText(stock);
        }
        if(codigoThomson.equals("10000_2")) {
            iv_detalle_portatil.setImageResource(R.drawable.portatil_thomson);
            String nombre = "Thomson NEO Z3, 12.5 pulgadas FHD, LTE 4G, Qualcomm® Snapdragon™ 850, 8GB RAM, 256GB Flash, Adreno 630, W10";
            String precio = "399$";
            String modelo = "NEO Z3";
            String stock = "4";

            tv_nombre.setText(nombre);
            tv_precio.setText(precio);
            tv_res_categoria.setText(categoriaPortatil);
            tv_res_codigo.setText(codigoPortatil);
            tv_res_codigo_producto.setText(codigoThomson);
            tv_res_modelo.setText(modelo);
            tv_res_stock.setText(stock);
        }
    }

    public void volverAHome(View v) {
        Intent pantallaPrincipal = new Intent(this, ComputerCatalogue.class);
        startActivity(pantallaPrincipal);
    }

    public void volverAPortatiles(View v) {
        Intent pantallaPortatiles = new Intent(this, LaptopCategory.class);
        startActivity(pantallaPortatiles);
    }
}
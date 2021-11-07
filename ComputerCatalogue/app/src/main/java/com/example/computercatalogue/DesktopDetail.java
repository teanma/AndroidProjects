package com.example.computercatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DesktopDetail extends AppCompatActivity {

    Button btn_home, btn_sobremesas;
    TextView tv_nombre, tv_precio, tv_res_categoria, tv_res_codigo, tv_res_codigo_producto, tv_res_modelo, tv_res_stock;
    ImageView iv_detalle_sobremesa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.computer_detail);
        inicializar();
        mostrarDetalle();
    }

    public void inicializar() {

        btn_home = (Button) findViewById(R.id.btn_home_sobremesa);
        btn_sobremesas = (Button) findViewById(R.id.btn_sobremesas);

        tv_nombre = (TextView) findViewById(R.id.tv_nombre_sobremesa);
        tv_precio = (TextView) findViewById(R.id.tv_precio_sobremesa);
        tv_res_categoria = (TextView) findViewById(R.id.tv_res_categoria_sobremesa);
        tv_res_codigo = (TextView) findViewById(R.id.tv_res_codigo_sobremesa);
        tv_res_codigo_producto = (TextView) findViewById(R.id.tv_res_codigo_producto_sobremesa);
        tv_res_modelo = (TextView) findViewById(R.id.tv_res_modelo_sobremesa);
        tv_res_stock = (TextView) findViewById(R.id.tv_res_stock_sobremesa);

        iv_detalle_sobremesa = (ImageView) findViewById(R.id.iv_detalle_sobremesa);
    }

    public void mostrarDetalle() {

        Intent intent = getIntent();

        String codigoSobremesa = intent.getStringExtra(ComputerCatalogue.COMPUTERCATALOGUE_SOBREMESAS_20000);
        String categoriaSombremesa = intent.getStringExtra(ComputerCatalogue.COMPUTERCATALOGUE_CATEGORIA_SOBREMESAS);
        String codigoDell = intent.getStringExtra(DesktopCatalogue.DESKTOPCATALOGUE_SOBREMESA_DELL_20000_1);
        String codigoHp = intent.getStringExtra(DesktopCatalogue.DESKTOPCATALOGUE_SOBREMESA_HP_20000_2);

        if(codigoDell.equals("20000_1")) {
            iv_detalle_sobremesa.setImageResource(R.drawable.sobremesa_dell);
            String nombre = "Dell Ordenador Sobremesa CGRR2 i3-10105/8GB/256GB SSD";
            String precio = "547.99$";
            String modelo = "CGRR2";
            String stock = "5";

            tv_nombre.setText(nombre);
            tv_precio.setText(precio);
            tv_res_categoria.setText(categoriaSombremesa);
            tv_res_codigo.setText(codigoSobremesa);
            tv_res_codigo_producto.setText(codigoDell);
            tv_res_modelo.setText(modelo);
            tv_res_stock.setText(stock);
        }
        if(codigoHp.equals("20000_2")) {
            iv_detalle_sobremesa.setImageResource(R.drawable.sobremesa_hp);
            String nombre = "HP Ordenador Sobremesa 290 G3 SFF i5-10500/8GB/256GB SSD";
            String precio = "637.99$";
            String modelo = "290 G3 SFF";
            String stock = "6";

            tv_nombre.setText(nombre);
            tv_precio.setText(precio);
            tv_res_categoria.setText(categoriaSombremesa);
            tv_res_codigo.setText(codigoSobremesa);
            tv_res_codigo_producto.setText(codigoHp);
            tv_res_modelo.setText(modelo);
            tv_res_stock.setText(stock);
        }
    }

    public void volverAHome(View v) {
        Intent pantallaPrincipal = new Intent(this, ComputerCatalogue.class);
        startActivity(pantallaPrincipal);
    }

    public void volverASobremesas(View v) {
        Intent pantallaSobremesas = new Intent(this, DesktopCatalogue.class);
        startActivity(pantallaSobremesas);
    }
}
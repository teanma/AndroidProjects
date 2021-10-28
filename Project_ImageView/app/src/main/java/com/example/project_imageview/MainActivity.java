package com.example.project_imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cambiarImagen(View v) {
        ImageView iv_frutas = (ImageView) findViewById(R.id.iv_frutas);
        switch (v.getId()) {
            case (R.id.btn_aguacates):
            iv_frutas.setImageResource(R.drawable.aguacates);
            break;
            case (R.id.btn_cerezas):
            iv_frutas.setImageResource(R.drawable.cerezas);
            break;
            case (R.id.btn_manzanas):
            iv_frutas.setImageResource(R.drawable.manzanas);
            break;
        }
    }
}
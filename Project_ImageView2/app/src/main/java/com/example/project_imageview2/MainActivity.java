package com.example.project_imageview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cargarImagen(View v) {
        ImageView iv_frutas = (ImageView) findViewById(R.id.iv_frutas);
        EditText et_frutas = (EditText) findViewById(R.id.et_frutas);
        switch (et_frutas.getText().toString()) {
            case "a":
                Toast.makeText(this, "Se ha cargado la imagen de los aguacates", Toast.LENGTH_SHORT).show();
                iv_frutas.setImageResource(R.drawable.aguacates);
                break;
            case "c":
                Toast.makeText(this, "Se ha cargado la imagen de las cerezas", Toast.LENGTH_SHORT).show();
                iv_frutas.setImageResource(R.drawable.cerezas);
                break;
            case "m":
                Toast.makeText(this, "Se ha cargado la imagen de las manzanas", Toast.LENGTH_SHORT).show();
                iv_frutas.setImageResource(R.drawable.manzanas);
                break;
            default:
                Toast.makeText(this, "Se ha cargado la imagen de las frutas", Toast.LENGTH_SHORT).show();
                iv_frutas.setImageResource(R.drawable.fruta);
                break;
        }
    }
}
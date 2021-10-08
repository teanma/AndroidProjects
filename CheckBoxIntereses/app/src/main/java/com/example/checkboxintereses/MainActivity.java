package com.example.checkboxintereses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CheckBox cb_belleza, cb_lib_lit, cb_carreras,
            cb_educacion, cb_eventos, cb_familia, cb_com_beb,
            cb_videojuegos, cb_deportes, cb_arte;
    private TextView tv_mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb_belleza = (CheckBox) findViewById(R.id.cb_belleza);
        cb_lib_lit = (CheckBox) findViewById(R.id.cb_lib_lit);
        cb_carreras = (CheckBox) findViewById(R.id.cb_carreras);
        cb_educacion = (CheckBox) findViewById(R.id.cb_educacion);
        cb_eventos = (CheckBox) findViewById(R.id.cb_eventos);
        cb_familia = (CheckBox) findViewById(R.id.cb_familia);
        cb_com_beb = (CheckBox) findViewById(R.id.cb_com_beb);
        cb_videojuegos = (CheckBox) findViewById(R.id.cb_videojuegos);
        cb_deportes = (CheckBox) findViewById(R.id.cb_deportes);
        cb_arte = (CheckBox) findViewById(R.id.cb_arte);
        tv_mensaje = (TextView) findViewById(R.id.tv_mensaje);
    }

    public void cargar(View v) {

        List<String> intereses = new ArrayList<>();

        if (cb_belleza.isChecked()) {
            intereses.add(cb_belleza.getText().toString());
        }
        if (cb_lib_lit.isChecked()) {
            intereses.add(cb_lib_lit.getText().toString());
        }
        if (cb_carreras.isChecked()) {
            intereses.add(cb_carreras.getText().toString());
        }
        if (cb_educacion.isChecked()) {
            intereses.add(cb_carreras.getText().toString());
        }
        if (cb_eventos.isChecked()) {
            intereses.add(cb_eventos.getText().toString());
        }
        if (cb_familia.isChecked()) {
            intereses.add(cb_familia.getText().toString());
        }
        if (cb_com_beb.isChecked()) {
            intereses.add(cb_com_beb.getText().toString());
        }
        if (cb_videojuegos.isChecked()) {
            intereses.add(cb_videojuegos.getText().toString());
        }
        if (cb_deportes.isChecked()) {
            intereses.add(cb_deportes.getText().toString());
        }
        if (cb_arte.isChecked()) {
            intereses.add(cb_arte.getText().toString());
        }
        tv_mensaje.setText("Tus gustos son: " + intereses.toString());
    }
}
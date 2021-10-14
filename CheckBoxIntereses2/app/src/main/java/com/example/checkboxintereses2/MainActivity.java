package com.example.checkboxintereses2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CheckBox cb_tv, cb_radio, cb_periodico, cb_amigo, cb_otros;
    private EditText et_otros;
    private TextView tv_mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb_tv = (CheckBox) findViewById(R.id.cb_tv);
        cb_radio = (CheckBox) findViewById(R.id.cb_radio);
        cb_periodico = (CheckBox) findViewById(R.id.cb_periodico);
        cb_amigo = (CheckBox) findViewById(R.id.cb_amigo);
        cb_otros = (CheckBox) findViewById(R.id.cb_otros);
        et_otros = (EditText) findViewById(R.id.et_otros);
        tv_mensaje = (TextView) findViewById(R.id.tv_mensaje);
        et_otros.setVisibility(View.GONE);
    }

    public void showEditText(View v) {
        if(cb_otros.isChecked()) {
            et_otros.setVisibility(View.VISIBLE);
        } else {
            et_otros.setVisibility(View.GONE);
        }
    }

    public void cargar(View v) {

        List<String> opciones = new ArrayList<>();

        if(cb_tv.isChecked()) {
            opciones.add(cb_tv.getText().toString());
        }
        if(cb_radio.isChecked()) {
            opciones.add(cb_radio.getText().toString());
        }
        if(cb_periodico.isChecked()) {
            opciones.add(cb_periodico.getText().toString());
        }
        if(cb_amigo.isChecked()) {
            opciones.add(cb_amigo.getText().toString());
        }
        if(cb_otros.isChecked()) {
            opciones.add(et_otros.getText().toString());
        }
        tv_mensaje.setText("Gracias por escuchar sobre nosotros en " + opciones.toString());
    }
}
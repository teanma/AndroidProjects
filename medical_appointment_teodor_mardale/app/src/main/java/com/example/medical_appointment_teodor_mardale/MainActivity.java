package com.example.medical_appointment_teodor_mardale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_cita, tv_dia, tv_hora;
    EditText et_dia, et_hora;
    Button btn_guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        tv_cita = (TextView) findViewById(R.id.tv_cita);
        tv_dia = (TextView) findViewById(R.id.tv_dia);
        tv_hora = (TextView) findViewById(R.id.tv_hora);

        et_dia = (EditText) findViewById(R.id.et_dia);
        et_hora = (EditText) findViewById(R.id.et_hora);

        btn_guardar = (Button) findViewById(R.id.btn_guardar);
    }

    public void guardar(View v) {

        String dia = et_dia.getText().toString();
        String hora = et_hora.getText().toString();

        if (dia.isEmpty() || hora.isEmpty()) {
            Toast.makeText(this, "Los campos son obligatorios", Toast.LENGTH_SHORT).show();
        } else {
            Intent secondaryScreen = new Intent(this, MainActivity2.class);
            SharedPreferences pref = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString(getString(R.string.pref_day), dia);
            editor.putString(getString(R.string.pref_hour), hora);
            editor.commit();
            startActivity(secondaryScreen);
        }
    }
}
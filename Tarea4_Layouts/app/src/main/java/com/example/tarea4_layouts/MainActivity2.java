package com.example.tarea4_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    protected static final String MAINACTIVITY2_RESPUESTA = "com.example.tarea4_layouts.respuesta";
    protected static final String MAINACTIVITY_NICK = "com.example.tarea4_layouts.nick";

    TextView tv_pregunta, tv_num_preguntas, tv_pagina_web, tv_pin_juego, tv_pin;
    ImageView iv_contador, iv_test;
    Button btn_omitir, btn_respuesta1, btn_respuesta2, btn_respuesta3, btn_respuesta4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    public void init() {
        tv_pregunta = (TextView) findViewById(R.id.tv_pregunta);
        tv_num_preguntas = (TextView) findViewById(R.id.tv_num_preguntas);
        tv_pagina_web = (TextView) findViewById(R.id.tv_pagina_web);
        tv_pin_juego = (TextView) findViewById(R.id.tv_pin_juego);
        tv_pin = (TextView) findViewById(R.id.tv_pin);

        iv_contador = (ImageView) findViewById(R.id.iv_contador);
        iv_test = (ImageView) findViewById(R.id.iv_test);

        btn_omitir = (Button) findViewById(R.id.btn_omitir);
        btn_respuesta1 = (Button) findViewById(R.id.btn_respuesta1);
        btn_respuesta2 = (Button) findViewById(R.id.btn_respuesta2);
        btn_respuesta3 = (Button) findViewById(R.id.btn_respuesta3);
        btn_respuesta4 = (Button) findViewById(R.id.btn_respuesta4);
    }

    public void respuesta1(View v) {
        Intent pantallaPrincipal = getIntent();
        String respuesta1 = "Java Development KIt";
        String nick = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_NICK);
        Intent pantallaTernaria = new Intent(this, MainActivity3.class);
        pantallaTernaria.putExtra(MAINACTIVITY_NICK, nick);
        pantallaTernaria.putExtra(MAINACTIVITY2_RESPUESTA, respuesta1);
        startActivity(pantallaTernaria);
    }

    public void respuesta2(View v) {
        Intent pantallaPrincipal = getIntent();
        String respuesta2 = "Opensource Framework, usado para escribir y ejecutar tests";
        String nick = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_NICK);
        Intent pantallaTernaria = new Intent(this, MainActivity3.class);
        pantallaTernaria.putExtra(MAINACTIVITY_NICK, nick);
        pantallaTernaria.putExtra(MAINACTIVITY2_RESPUESTA, respuesta2);
        startActivity(pantallaTernaria);
    }

    public void respuesta3(View v) {
        Intent pantallaPrincipal = getIntent();
        String respuesta3 = "Opensource Framework, el cual traduce bytecode a código binario";
        String nick = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_NICK);
        Intent pantallaTernaria = new Intent(this, MainActivity3.class);
        pantallaTernaria.putExtra(MAINACTIVITY_NICK, nick);
        pantallaTernaria.putExtra(MAINACTIVITY2_RESPUESTA, respuesta3);
        startActivity(pantallaTernaria);
    }

    public void respuesta4(View v) {
        Intent pantallaPrincipal = getIntent();
        String respuesta4 = "Ninguno de los anteriores";
        String nick = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_NICK);
        Intent pantallaTernaria = new Intent(this, MainActivity3.class);
        pantallaTernaria.putExtra(MAINACTIVITY_NICK, nick);
        pantallaTernaria.putExtra(MAINACTIVITY2_RESPUESTA, respuesta4);
        startActivity(pantallaTernaria);
    }
}
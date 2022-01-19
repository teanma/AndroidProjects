package com.example.tarea4_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    protected static final String MAINACTIVITY2_RESPUESTA = "com.example.tarea4_layouts.respuesta";
    protected static final String MAINACTIVITY_NICK = "com.example.tarea4_layouts.nick";

    TextView tv_pregunta_junit, tv_respuesta_jugador, tv_respuesta_correcta, tv_mensaje_respuesta;
    Button btn_respuesta_incorrecta, btn_respuesta_correcta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();

        Intent pantallaSecundaria = getIntent();

        String nick = pantallaSecundaria.getStringExtra(MainActivity.MAINACTIVITY_NICK);
        String respuesta = pantallaSecundaria.getStringExtra(MainActivity2.MAINACTIVITY2_RESPUESTA);

        if (respuesta.equals("Opensource Framework, usado para escribir y ejecutar tests")) {
            btn_respuesta_correcta = (Button) findViewById(R.id.btn_respuesta_correcta);
            btn_respuesta_correcta.setText(respuesta);
            tv_mensaje_respuesta.setText("Enhorabuena, " + nick + ", has acertado");
            btn_respuesta_incorrecta.setVisibility(View.GONE);
            tv_respuesta_correcta.setVisibility(View.GONE);
        } else {
            btn_respuesta_incorrecta = (Button) findViewById(R.id.btn_respuesta_incorrecta);
            btn_respuesta_incorrecta.setText(respuesta);
            tv_mensaje_respuesta.setText("Lo sentimos, " + nick + ", has fallado");
        }
    }

    public void init() {
        tv_pregunta_junit = (TextView) findViewById(R.id.tv_pregunta_junit);
        tv_respuesta_jugador = (TextView) findViewById(R.id.tv_respuesta_jugador);
        tv_respuesta_correcta = (TextView) findViewById(R.id.tv_respuesta_correcta);
        tv_mensaje_respuesta = (TextView) findViewById(R.id.tv_mensaje_respuesta);

        btn_respuesta_incorrecta = (Button) findViewById(R.id.btn_respuesta_incorrecta);
        btn_respuesta_correcta = (Button) findViewById(R.id.btn_respuesta_correcta);
    }
}
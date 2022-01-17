package com.example.tarea4_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static final String MAINACTIVITY_NICK = "com.example.tarea4_layouts.nick";

    ImageView iv_kahoot;
    EditText et_nick;
    Button btn_iniciar_juego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        iv_kahoot = (ImageView) findViewById(R.id.iv_kahoot);
        et_nick = (EditText) findViewById(R.id.et_nick);
        btn_iniciar_juego = (Button) findViewById(R.id.btn_iniciar_juego);
    }

    public void iniciarJuego(View v) {

        String nick = et_nick.getText().toString();

        if(nick.isEmpty()) {
            Toast.makeText(this, "Debe introducir un nick", Toast.LENGTH_SHORT).show();
        } else {
            Intent pantallaSecundaria = new Intent(this, MainActivity2.class);
            pantallaSecundaria.putExtra(MAINACTIVITY_NICK, nick);
            startActivity(pantallaSecundaria);
        }
    }
}
package com.example.controlescheckbox2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CheckBox cb_futbol, cb_baloncesto, cb_hockey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb_futbol = (CheckBox) findViewById(R.id.cb_futbol);
        cb_baloncesto = (CheckBox) findViewById(R.id.cb_baloncesto);
        cb_hockey = (CheckBox) findViewById(R.id.cb_hockey);
    }
    
    public void showToast(View v) {

        List<String> intereses = new ArrayList<>();

        if (cb_futbol.isChecked()) {
            intereses.add(cb_futbol.getText().toString());
        }
        if (cb_baloncesto.isChecked()) {
            intereses.add(cb_baloncesto.getText().toString());
        }
        if (cb_hockey.isChecked()) {
            intereses.add(cb_hockey.getText().toString());
        }
        if (intereses.isEmpty()) {
            Toast.makeText(this, "Selecciona un valor", Toast.LENGTH_SHORT).show();
        }

        String aviso = intereses.toString();
        String mensaje = aviso.replace("[", "");
        String mensajeFinal = mensaje.replace("]", "");
        Toast intSeleccionados = Toast.makeText(this, mensajeFinal, Toast.LENGTH_SHORT);
        intSeleccionados.show();
    }
}
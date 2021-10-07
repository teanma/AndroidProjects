package com.example.controlescheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton tb_activacion = (ToggleButton) findViewById(R.id.tb_activacion);
        // Cambiar el texto que muestra el botón dependiendo del estado
        tb_activacion.setTextOff("Desactivado");
        tb_activacion.setTextOn("Activado");

        // Activamos el botón al iniciar la app
        tb_activacion.setChecked(false);

        // Ocultamos el textview
        TextView tv_activacion = (TextView) findViewById(R.id.tv_prueba);
        tb_activacion.setVisibility(View.INVISIBLE);
    }

    public void cargar(View v) {
        ToggleButton tb_activacion = (ToggleButton) findViewById(R.id.tb_activacion);
        TextView tv_activacion = (TextView) findViewById(R.id.tv_prueba);

        if (tb_activacion.isChecked()) {
            // Si está activado
            tv_activacion.setText("ToggleButton activado");

        }
        if (!tb_activacion.isChecked()) {
            // Si está desactivado
            tv_activacion.setText("ToggleButton desactivaddo");
        }
    }
}
package com.example.ejercicioformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cargar(View v) {
        EditText etNombre = (EditText)findViewById(R.id.etNombre);
        EditText etApellido = (EditText)findViewById(R.id.etApellido);

        TextView tvValorNombreIntroducido = (TextView)findViewById(R.id.tvValorNombreIntroducido);
        TextView tvValorApellidoIntroducido = (TextView)findViewById(R.id.tvValorApellidoIntroducido);

        //Dos formas de recuperar y mostrar información de objetos

        String nombre = etNombre.getText().toString();
        tvValorNombreIntroducido.setText(nombre);

        tvValorApellidoIntroducido.setText(etApellido.getText().toString());
    }
}
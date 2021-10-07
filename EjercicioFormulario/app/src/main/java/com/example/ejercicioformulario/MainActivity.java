package com.example.ejercicioformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton tb_activacion = (ToggleButton) findViewById(R.id.tb_activacion);

        tb_activacion.setTextOff("Desactivado");
        tb_activacion.setTextOn("Activado");
    }

    public void cargar(View v) {
        EditText etNombre = (EditText)findViewById(R.id.etNombre);
        EditText etApellido = (EditText)findViewById(R.id.etApellido);
        EditText etEmail = (EditText)findViewById(R.id.etEmail);
        EditText etMovil = (EditText)findViewById(R.id.etMovil);
        EditText etObservaciones = (EditText)findViewById(R.id.etObservaciones);

        TextView tvValorNombreIntroducido = (TextView)findViewById(R.id.tvValorNombreIntroducido);
        TextView tvValorApellidoIntroducido = (TextView)findViewById(R.id.tvValorApellidoIntroducido);
        TextView tvValorEmailIntroducido = (TextView)findViewById(R.id.tvValorEmailIntroducido);
        TextView tvValorMovilIntroducido = (TextView)findViewById(R.id.tvValorMovilIntroducido);
        TextView tvValorObservacionIntroducido = (TextView)findViewById(R.id.tvValorObservacionIntroducido);

        tvValorNombreIntroducido.setText(etNombre.getText().toString());
        tvValorApellidoIntroducido.setText(etApellido.getText().toString());
        tvValorEmailIntroducido.setText(etEmail.getText().toString());
        tvValorMovilIntroducido.setText(etMovil.getText().toString());
        tvValorObservacionIntroducido.setText(etObservaciones.getText().toString());
    }

    public void desactivar(View v) {
        ToggleButton tb_activacion = (ToggleButton) findViewById(R.id.tb_activacion);
        TextView tv_Observaciones = (TextView)findViewById(R.id.tvObservaciones);
        EditText etObservaciones = (EditText)findViewById(R.id.etObservaciones);

        if (tb_activacion.isChecked()) {
            tv_Observaciones.setVisibility(View.GONE);
            etObservaciones.setVisibility(View.GONE);
        } else {
            tv_Observaciones.setVisibility(View.VISIBLE);
            etObservaciones.setVisibility(View.VISIBLE);
        }
    }
}
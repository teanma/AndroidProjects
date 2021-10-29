package com.example.projectactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static final String MAINACTIVITY_NAME = "com.example.projectactivities.name";
    protected static final String MAINACTIVITY_SURNAME = "com.example.projectactivities.surname";
    protected static final String MAINACTIVITY_AGE = "com.example.projectactivities.age";
    protected static final String MAINACTIVITY_LICENSE = "com.example.projectactivities.license";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cargarDatos(View v) {

        Intent pantallaSecundaria = new Intent(this, MainActivity2.class);
        EditText et_name = (EditText) findViewById(R.id.et_nombre);
        EditText et_surname = (EditText) findViewById(R.id.et_apellidos);
        EditText et_age = (EditText) findViewById(R.id.et_edad);
        CheckBox cb_license = (CheckBox) findViewById(R.id.cb_carnet);

        String message = null;
        boolean start = false;
        if (et_name.getText().toString().isEmpty()) {
            message = "Introduce tu nombre";
        } else {
            String name = et_name.getText().toString();
            pantallaSecundaria.putExtra(MAINACTIVITY_NAME, name);
        }
        if (et_surname.getText().toString().isEmpty()) {
            message += " Introduce tu apellido";
        } else {
            String surname = et_surname.getText().toString();
            pantallaSecundaria.putExtra(MAINACTIVITY_SURNAME, surname);
        }
        if (et_age.getText().toString().isEmpty()) {
            message += " Introduce tu edad";
        } else {
            String age = et_age.getText().toString();
            pantallaSecundaria.putExtra(MAINACTIVITY_AGE, age);
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        boolean license = cb_license.isChecked();
        pantallaSecundaria.putExtra(MAINACTIVITY_LICENSE, license);

        if (!et_name.getText().toString().isEmpty() || !et_surname.getText().toString().isEmpty() || !et_age.getText().toString().isEmpty()) {
            startActivity(pantallaSecundaria);
        } else {
            message = null;
        }

    }
}
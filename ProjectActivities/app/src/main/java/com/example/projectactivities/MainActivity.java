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

    EditText et_name, et_surname, et_age;
    CheckBox cb_license;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    public void inicializar() {
        et_name = (EditText) findViewById(R.id.et_nombre);
        et_surname = (EditText) findViewById(R.id.et_apellidos);
        et_age = (EditText) findViewById(R.id.et_edad);
        cb_license = (CheckBox) findViewById(R.id.cb_carnet);
    }

    public void cargarDatos(View v) {

        String name = et_name.getText().toString();
        String surname = et_surname.getText().toString();
        String age = et_age.getText().toString();
        String license = "Sí";
        String notLicense = "No";


        if (name.isEmpty() || surname.isEmpty() || age.isEmpty()) {
            Toast.makeText(this, "Rellene los campos", Toast.LENGTH_SHORT).show();
        } else {
            Intent pantallaSecundaria = new Intent(this, MainActivity2.class);
            if (cb_license.isChecked()) {
                pantallaSecundaria.putExtra(MAINACTIVITY_LICENSE, license);
            } else {
                pantallaSecundaria.putExtra(MAINACTIVITY_LICENSE, notLicense);
            }
            pantallaSecundaria.putExtra(MAINACTIVITY_NAME, name);
            pantallaSecundaria.putExtra(MAINACTIVITY_SURNAME, surname);
            pantallaSecundaria.putExtra(MAINACTIVITY_AGE, age);
            startActivity(pantallaSecundaria);
        }
    }
}
package com.example.projectactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent pantallaPrincipal = getIntent();
        String name = getIntent().getStringExtra(MainActivity.MAINACTIVITY_NAME);
        String surname = getIntent().getStringExtra(MainActivity.MAINACTIVITY_SURNAME);
        String age = getIntent().getStringExtra(MainActivity.MAINACTIVITY_AGE);
        String license = getIntent().getStringExtra(MainActivity.MAINACTIVITY_LICENSE);

        TextView tv_name_result = (TextView) findViewById(R.id.tv_nom_resultado);
        tv_name_result.setText(name);
        TextView tv_sur_result = (TextView) findViewById(R.id.tv_ap_resultado);
        tv_sur_result.setText(surname);
        TextView tv_age_result = (TextView) findViewById(R.id.tv_edad_resultado);
        tv_age_result.setText(age);
        TextView tv_license_result = (TextView) findViewById(R.id.tv_carnet_resultado);
        tv_license_result.setText(license);
    }

    public void cambiarActividad(View v) {
        Intent pantallaPrincipal = new Intent(this, MainActivity.class);
        startActivity(pantallaPrincipal);
    }
}
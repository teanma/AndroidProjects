package com.example.formulariodeportivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent pantallaPrincipal = getIntent();

        String name = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_NAME);
        String surname = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_SURNAME);
        String phone = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_PHONE);
        String email = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_EMAIL);
        String football = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_FOOTBALL);
        String basketball = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_BASKETBALL);
        String portero = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_PORTERO);
        String defensa = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_DEFENSA);
        String medio = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_MEDIO);
        String delantero = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_DELANTERO);
        String base = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_BASE);
        String escolta = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_ESCOLTA);
        String alero = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_ALERO);
        String pivot = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_PIVOT);

        TextView tv_name_result = (TextView) findViewById(R.id.tv_name_result);
        tv_name_result.setText(name);
        TextView tv_surname_result = (TextView) findViewById(R.id.tv_surname_result);
        tv_surname_result.setText(surname);
        TextView tv_phone_result = (TextView) findViewById(R.id.tv_phone_result);
        tv_phone_result.setText(phone);
        TextView tv_email_result = (TextView) findViewById(R.id.tv_email_result);
        tv_email_result.setText(email);
        TextView tv_football_result = (TextView) findViewById(R.id.tv_res_football);
        tv_football_result.setText(football);
        TextView tv_basketball_result = (TextView) findViewById(R.id.tv_res_basketball);
        tv_basketball_result.setText(basketball);
        TextView tv_portero_result = (TextView) findViewById(R.id.tv_portero);
        tv_portero_result.setText(portero);
        TextView tv_defensa_result = (TextView) findViewById(R.id.tv_defensa);
        tv_defensa_result.setText(defensa);
        TextView tv_medio_result = (TextView) findViewById(R.id.tv_medio);
        tv_medio_result.setText(medio);
        TextView tv_delantero_result = (TextView) findViewById(R.id.tv_delantero);
        tv_delantero_result.setText(delantero);
        TextView tv_base_result = (TextView) findViewById(R.id.tv_base);
        tv_base_result.setText(base);
        TextView tv_escolta_result = (TextView) findViewById(R.id.tv_escolta);
        tv_escolta_result.setText(escolta);
        TextView tv_alero_result = (TextView) findViewById(R.id.tv_alero);
        tv_alero_result.setText(alero);
        TextView tv_pivot_result = (TextView) findViewById(R.id.tv_pivot);
        tv_pivot_result.setText(pivot);
    }

    public void returnToMainActivity(View v) {
        Intent pantallaPrincipal = new Intent(this, MainActivity.class);
        startActivity(pantallaPrincipal);
    }
}
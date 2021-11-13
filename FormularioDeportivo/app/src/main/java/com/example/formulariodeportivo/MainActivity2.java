package com.example.formulariodeportivo;

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

        String name = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_NAME);
        String surname = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_SURNAME);
        String selected_contact = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_SELECTED_CONTACT);
        String contact = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_CONTACT);
        String sport = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_SPORT);
        String position = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_POSITION);

        TextView tv_name_result = (TextView) findViewById(R.id.tv_name_result);
        tv_name_result.setText(name);
        TextView tv_surname_result = (TextView) findViewById(R.id.tv_surname_result);
        tv_surname_result.setText(surname);
        TextView tv_selected_contact_result = (TextView) findViewById(R.id.tv_res_contact);
        tv_selected_contact_result.setText(selected_contact);
        TextView tv_contact_result = (TextView) findViewById(R.id.tv_contact_result);
        tv_contact_result.setText(contact);
        TextView tv_sport_result = (TextView) findViewById(R.id.tv_sport_result);
        tv_sport_result.setText(sport);
        TextView tv_position_result = (TextView) findViewById(R.id.tv_position_result);
        tv_position_result.setText(position);
    }

    public void returnToMainActivity(View v) {
        Intent pantallaPrincipal = new Intent(this, MainActivity.class);
        startActivity(pantallaPrincipal);
    }
}
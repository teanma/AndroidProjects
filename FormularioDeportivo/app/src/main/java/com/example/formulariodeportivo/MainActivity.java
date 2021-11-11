package com.example.formulariodeportivo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_name, tv_surname, tv_phone, tv_email, tv_sport, tv_position, tv_obligatory_field;
    EditText et_name, et_surname, et_phone, et_email;
    Spinner spinContact, spinSport;
    CheckBox cb_position1_football, cb_position2_football, cb_position3_football, cb_position4_football, cb_position1_basketball, cb_position2_basketball, cb_position3_basketball, cb_position4_basketball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_surname = (TextView) findViewById(R.id.tv_surname);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_sport = (TextView) findViewById(R.id.tv_sport);
        tv_position = (TextView) findViewById(R.id.tv_position);
        tv_obligatory_field = (TextView) findViewById(R.id.tv_obligatory_field_name);
        tv_obligatory_field = (TextView) findViewById(R.id.tv_obligatory_field_surname);
        tv_obligatory_field = (TextView) findViewById(R.id.tv_obligatory_field_spinContact);
        tv_obligatory_field = (TextView) findViewById(R.id.tv_obligatory_field_phone);
        tv_obligatory_field = (TextView) findViewById(R.id.tv_obligatory_field_email);
        tv_obligatory_field = (TextView) findViewById(R.id.tv_obligatory_field_spinSport);

        et_name = (EditText) findViewById(R.id.et_name);
        et_surname = (EditText) findViewById(R.id.et_surname);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_email = (EditText) findViewById(R.id.et_email);

        spinContact = (Spinner) findViewById(R.id.spinContact);
        spinSport = (Spinner) findViewById(R.id.spinSport);

        cb_position1_football = (CheckBox) findViewById(R.id.cb_position1_football);
        cb_position2_football = (CheckBox) findViewById(R.id.cb_position2_football);
        cb_position3_football = (CheckBox) findViewById(R.id.cb_position3_football);
        cb_position4_football = (CheckBox) findViewById(R.id.cb_position4_football);
        cb_position1_basketball = (CheckBox) findViewById(R.id.cb_position1_basketball);
        cb_position2_basketball = (CheckBox) findViewById(R.id.cb_position2_basketball);
        cb_position3_basketball = (CheckBox) findViewById(R.id.cb_position3_basketball);
        cb_position4_basketball = (CheckBox) findViewById(R.id.cb_position4_basketball);
    }
}
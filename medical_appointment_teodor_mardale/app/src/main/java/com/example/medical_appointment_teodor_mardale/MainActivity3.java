package com.example.medical_appointment_teodor_mardale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView tv_intro_dia, tv_intro_hora, tv_intro_modalidad;

    DBHelper dbHelperAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();

        SharedPreferences pref = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE);
        String dia = pref.getString(getString(R.string.pref_day), getString(R.string.pref_default));
        tv_intro_dia.setText(dia);
        String hora = pref.getString(getString(R.string.pref_hour), getString(R.string.pref_default));
        tv_intro_hora.setText(hora);
        String modalidad = pref.getString(getString(R.string.pref_modality), getString(R.string.pref_default));
        tv_intro_modalidad.setText(modalidad);

        dbHelperAppointment = new DBHelper(this);

        Toast.makeText(this, "Creando la base de datos...", Toast.LENGTH_SHORT).show();

        SQLiteDatabase database = dbHelperAppointment.getWritableDatabase();

        Toast.makeText(this, "Base de datos creada", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "Creando tabla appointment...", Toast.LENGTH_SHORT).show();

        String appointment = "CREATE TABLE IF NOT EXISTS medical_appointment(_id INTEGER PRIMARY KEY AUTOINCREMENT, day INTEGER, hour INTEGER, modality VARCHAR(20))";
        database.execSQL(appointment);

        Toast.makeText(this, "Tabla appointment creada", Toast.LENGTH_SHORT).show();

        insertar();
    }

    public void init() {

        tv_intro_dia = (TextView) findViewById(R.id.tv_intro_dia);
        tv_intro_hora = (TextView) findViewById(R.id.tv_intro_hora);
        tv_intro_modalidad = (TextView) findViewById(R.id.tv_intro_modalidad);

    }

    public void insertar() {

        DBHelper dbHelperCustom = new DBHelper(this, "appointment.sqlite", null, 1);

        SQLiteDatabase database = dbHelperCustom.getWritableDatabase();

        SharedPreferences pref = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE);

        String day = pref.getString(getString(R.string.pref_day), getString(R.string.pref_default));
        String hour = pref.getString(getString(R.string.pref_hour), getString(R.string.pref_default));
        String modality = pref.getString(getString(R.string.pref_modality), getString(R.string.pref_default));

        ContentValues insertAppointment = new ContentValues();
        insertAppointment.put("day", day);
        insertAppointment.put("hour", hour);
        insertAppointment.put("modality", modality);

        database.insert("medical_appointment", null, insertAppointment);
        Toast.makeText(this, "Elementos insertados", Toast.LENGTH_SHORT).show();
    }

}
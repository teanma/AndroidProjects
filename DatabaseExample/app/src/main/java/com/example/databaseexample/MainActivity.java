package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Permite envio de datos personalizados
        //DBHelper dbHelper = new DBHelper(this, "test.db", null, 1);

        DBHelper dbHelperLawyer = new DBHelper(this);

        Toast.makeText(this, "Creando la base de datos lawyers.sqlite", Toast.LENGTH_SHORT).show();

        SQLiteDatabase database = dbHelperLawyer.getWritableDatabase();

        Toast.makeText(this, "Creando la tabla alumnos...", Toast.LENGTH_SHORT).show();

        String alumnos = "CREATE TABLE IF NOT EXISTS alumnos(code INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(50))";
        database.execSQL(alumnos);

        Toast.makeText(this, "Tabla alumnos creada.", Toast.LENGTH_SHORT).show();

        String comments = "CREATE TABLE IF NOT EXISTS comments(_id INTEGER PRIMARY KEY AUTOINCREMENT, user VARCHAR(50), comment VARCHAR(100))";
        database.execSQL(comments);

        Toast.makeText(this, "Tabla comentarios creada.", Toast.LENGTH_SHORT).show();

        //database.close();
    }

    public void createDB(View vista) {

        EditText et_db_name = (EditText) findViewById(R.id.et_db_name);

        if(!et_db_name.getText().toString().equals("")) {
            String db = et_db_name.getText().toString();
            DBHelper dbHelperCustom = new DBHelper(this, db + ".sqlite", null, 1);
            dbHelperCustom.getWritableDatabase();
            Toast.makeText(this, "Base de datos creada.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Introduce un nombre para la base de datos.", Toast.LENGTH_SHORT).show();
        }

    }
}
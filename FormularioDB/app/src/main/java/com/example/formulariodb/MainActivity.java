package com.example.formulariodb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_nombre, tv_edad, tv_direccion, tv_email, tv_movil;
    EditText et_nombre, et_edad, et_direccion, et_email, et_movil;
    Button btn_guardar_datos;

    DBHelper dbHelperFormulary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        dbHelperFormulary = new DBHelper(this);

        Toast.makeText(this, "Creando la base de datos formulary.sqlite", Toast.LENGTH_SHORT).show();

        SQLiteDatabase database = dbHelperFormulary.getWritableDatabase();

        Toast.makeText(this, "Creando la tabla usuarios...", Toast.LENGTH_SHORT).show();

        String usuarios = "CREATE TABLE IF NOT EXISTS usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(50), edad INT(3), direccion VARCHAR(50), email VARCHAR(50), movil INT(9))";
        database.execSQL(usuarios);
        /*ContentValues insertUsers = new ContentValues();
        insertUsers.put("name", "nombre");
        insertUsers.put("age", "edad");
        insertUsers.put("address", "direccion");
        insertUsers.put("mail", "email");
        insertUsers.put("phone", "movil");
        database.insert("usuarios", null, insertUsers);*/

        Toast.makeText(this, "Tabla usuarios creada.", Toast.LENGTH_SHORT).show();
    }

    public void init() {

        tv_nombre = (TextView) findViewById(R.id.tv_nombre);
        tv_edad = (TextView) findViewById(R.id.tv_edad);
        tv_direccion = (TextView) findViewById(R.id.tv_direccion);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_movil = (TextView) findViewById(R.id.tv_movil);

        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_edad = (EditText) findViewById(R.id.et_edad);
        et_direccion = (EditText) findViewById(R.id.et_direccion);
        et_email = (EditText) findViewById(R.id.et_email);
        et_movil = (EditText) findViewById(R.id.et_movil);

        btn_guardar_datos = (Button) findViewById(R.id.btn_guardar_datos);
    }

    public void guardarDatos(View v) {

        DBHelper dbHelperCustom = new DBHelper(this, "formulary.sqlite", null, 1);

        SQLiteDatabase database = dbHelperCustom.getWritableDatabase();

        String nombre = et_nombre.getText().toString();
        String edad = et_edad.getText().toString();
        String direccion = et_direccion.getText().toString();
        String email = et_email.getText().toString();
        String movil = et_movil.getText().toString();

        /*String sentence = "INSERT INTO usuarios (nombre, edad, direccion, email, movil) VALUES (name, age, address, mail, phone)";
        database.execSQL(sentence);*/
        ContentValues insertUsers = new ContentValues();
        insertUsers.put("nombre", nombre);
        insertUsers.put("edad", edad);
        insertUsers.put("direccion", direccion);
        insertUsers.put("email", email);
        insertUsers.put("movil", movil);

        if(!nombre.isEmpty() && !edad.isEmpty() && !direccion.isEmpty() && !email.isEmpty() && !movil.isEmpty()) {
            database.insert("usuarios", null, insertUsers);
            Toast.makeText(this, "Datos guardados en la tabla usuarios", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        }
    }
}
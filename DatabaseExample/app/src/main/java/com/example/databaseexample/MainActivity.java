package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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

        // Opción 1: Insert mediante execSQL
        String insertComments = "INSERT INTO comments (user, comment) VALUES ('admin', 'Administrador del sistema')";
        database.execSQL(insertComments);

        // Opción 2: Insert mediante contentValues
        ContentValues insertCommentsV2 = new ContentValues();
        insertCommentsV2.put("user", "usuario");
        insertCommentsV2.put("comment", "Usuario normal del sistema");
        database.insert("comments", null, insertCommentsV2);

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

    public void executeSentence(View vista) {

        EditText et_sentence = (EditText) findViewById(R.id.et_sentence);

        DBHelper dbHelperCustom = new DBHelper(this, "lawyers.sqlite", null, 1);

        SQLiteDatabase database = dbHelperCustom.getWritableDatabase();

        String sentence = et_sentence.getText().toString();

        if(!et_sentence.getText().toString().equals("")) {
            database.execSQL(sentence);
            Toast.makeText(this, "Sentencia añadida a la base de datos", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Introduce una sentencia", Toast.LENGTH_SHORT).show();
        }
    }
}
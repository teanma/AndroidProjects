package com.example.repasoexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView tv_info, tv_user, tv_user_number;
    EditText et_user, et_user_number;
    Button btn_insertar;

    DBHelper dbHelperUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        dbHelperUser = new DBHelper(this);

        Toast.makeText(this, "Creando la base de datos users.sqlite", Toast.LENGTH_SHORT).show();

        SQLiteDatabase database = dbHelperUser.getWritableDatabase();

        Toast.makeText(this, "Creado la tabla newusers", Toast.LENGTH_SHORT).show();

        String newusers = "CREATE TABLE IF NOT EXISTS newusers (_id INTEGER PRIMARY KEY AUTOINCREMENT, user VARCHAR(50), user_number INT(10))";
        database.execSQL(newusers);

        Toast.makeText(this, "Tabla creada", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu2, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.mi2_volver:
                Intent mainScreen = new Intent(this, MainActivity.class);
                startActivity(mainScreen);
                return true;
            case R.id.mi2_siguiente:
                Intent thirdScreen = new Intent(this, MainActivity3.class);
                startActivity(thirdScreen);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void init() {

        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_user = (TextView) findViewById(R.id.tv_user);
        tv_user_number = (TextView) findViewById(R.id.tv_user_number);

        et_user = (EditText) findViewById(R.id.et_user);
        et_user_number = (EditText) findViewById(R.id.et_user_numb);

        btn_insertar = (Button) findViewById(R.id.btn_guardar);
    }

    public void insertar(View v) {

        DBHelper dbHelperCustom = new DBHelper(this, "users.sqlite", null, 1);

        SQLiteDatabase database = dbHelperCustom.getWritableDatabase();

        String user = et_user.getText().toString();
        String user_number = et_user_number.getText().toString();

        ContentValues insertNewUsers = new ContentValues();
        insertNewUsers.put("user", user);
        insertNewUsers.put("user_number", user_number);

        if (user.isEmpty() && user_number.isEmpty()) {
            Toast.makeText(this, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
        } else {
            database.insert("newusers", null, insertNewUsers);
            Toast.makeText(this, "Valores insertados", Toast.LENGTH_SHORT).show();
        }
    }
}
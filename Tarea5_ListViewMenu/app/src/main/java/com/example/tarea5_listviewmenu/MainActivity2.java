package com.example.tarea5_listviewmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    protected final static String MAINACTIVITY_SELECTED_ITEM = "com.example.tarea5_listviewmenu.selected_item";
    protected final static String MAINACTIVITY2_NAME = "com.example.tarea5_listviewmenu.name";
    protected final static String MAINACTIVITY2_SURNAME = "com.example.tarea5_listviewmenu.surname";
    protected final static String MAINACTIVITY2_AGE = "com.example.tarea5_listviewmenu.age";

    TextView tv_nombre, tv_apellido, tv_edad;

    EditText et_nombre_introducido, et_apellido_introducido, et_edad_introducida;

    Button btn_guardar;

    Intent mainScreen, thirdScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, 1, Menu.NONE,"Guardar");
        menu.add(Menu.NONE, 2, Menu.NONE,"Anterior");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                mainScreen = getIntent();

                String elemento_seleccionado = mainScreen.getStringExtra(MainActivity.MAINACTIVITY_SELECTED_ITEM);

                String nombre = et_nombre_introducido.getText().toString();
                String apellido = et_apellido_introducido.getText().toString();
                String edad = et_edad_introducida.getText().toString();
                //int edad = Integer.parseInt(edad_introducida);

                if (nombre.isEmpty()) {
                    Toast.makeText(this, "El campo nombre es obligatorio", Toast.LENGTH_SHORT).show();
                } else {
                    thirdScreen = new Intent(this, MainActivity3.class);
                    thirdScreen.putExtra(MAINACTIVITY_SELECTED_ITEM, elemento_seleccionado);
                    thirdScreen.putExtra(MAINACTIVITY2_NAME, nombre);
                    thirdScreen.putExtra(MAINACTIVITY2_SURNAME, apellido);
                    thirdScreen.putExtra(MAINACTIVITY2_AGE, edad);
                    SharedPreferences prefItem = getSharedPreferences("configItem", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editorItem = prefItem.edit();
                    editorItem.putString("name", nombre);
                    editorItem.putString("surname", apellido);
                    editorItem.putString("age", edad);
                    editorItem.commit();
                    startActivity(thirdScreen);
                }
                return true;
            case 2:
                mainScreen = new Intent(this, MainActivity.class);
                startActivity(mainScreen);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void init() {

        tv_nombre = (TextView) findViewById(R.id.tv_nombre);
        tv_apellido = (TextView) findViewById(R.id.tv_apellido);
        tv_edad = (TextView) findViewById(R.id.tv_edad);

        et_nombre_introducido = (EditText) findViewById(R.id.et_nombre_introducido);
        et_apellido_introducido = (EditText) findViewById(R.id.et_apellido_introducido);
        et_edad_introducida = (EditText) findViewById(R.id.et_edad_introducida);

        btn_guardar = (Button) findViewById(R.id.btn_guardar);
    }

    public void guardar(View v) {

        mainScreen = getIntent();

        String elemento_seleccionado = mainScreen.getStringExtra(MainActivity.MAINACTIVITY_SELECTED_ITEM);
        
        String nombre = et_nombre_introducido.getText().toString();
        String apellido = et_apellido_introducido.getText().toString();
        String edad = et_edad_introducida.getText().toString();
        
        if (nombre.isEmpty()) {
            Toast.makeText(this, "El campo nombre es obligatorio", Toast.LENGTH_SHORT).show();
        } else {
            thirdScreen = new Intent(this, MainActivity3.class);
            thirdScreen.putExtra(MAINACTIVITY_SELECTED_ITEM, elemento_seleccionado);
            thirdScreen.putExtra(MAINACTIVITY2_NAME, nombre);
            thirdScreen.putExtra(MAINACTIVITY2_SURNAME, apellido);
            thirdScreen.putExtra(MAINACTIVITY2_AGE, edad);
            SharedPreferences prefItem = getSharedPreferences("configItem", Context.MODE_PRIVATE);
            SharedPreferences.Editor editorItem = prefItem.edit();
            editorItem.putString("name", nombre);
            editorItem.putString("surname", apellido);
            editorItem.putString("age", edad);
            editorItem.commit();
            startActivity(thirdScreen);
        }
    }
}
package com.example.repasoexamen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv_name, tv_surname, tv_age, tv_formulario;
    EditText et_name, et_surname, et_age, et_new_item;
    Button btn_guardar;

    ListView lv_extras;

    ArrayList<String> list_extras;

    ArrayAdapter<String> adapter;

    Intent secondScreen;

    String selectedExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        lv_extras = (ListView) findViewById(R.id.lv_extra);

        list_extras = new ArrayList<String>();
        list_extras.add("1");
        list_extras.add("2");
        list_extras.add("3");
        list_extras.add("4");
        list_extras.add("5");
        list_extras.add("6");
        list_extras.add("7");
        list_extras.add("8");
        list_extras.add("9");
        list_extras.add("10");

        adapter = new ArrayAdapter<String>(this, R.layout.list_view, R.id.tv_aux, list_extras);

        lv_extras.setAdapter(adapter);

        itemSelected();

        registerForContextMenu(lv_extras);
    }

    public void itemSelected() {
        lv_extras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedExtra = list_extras.get(i);
                SharedPreferences pref = getSharedPreferences(getString(R.string.pref_fileName), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(getString(R.string.pref_extra), selectedExtra);
                editor.commit();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Seleccione opción");

        menu.add(0, 1, 0, "Eliminar");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        switch (item.getItemId()) {
            case 1:
                this.list_extras.remove(info.position);
                this.adapter.notifyDataSetChanged();
                Toast.makeText(this, "Elemento borrado", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(Menu.NONE, 1, Menu.NONE, "Añadir");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                if (et_new_item.getText().toString().isEmpty()) {
                    Random r = new Random();
                    int valorDado = r.nextInt(99)+1;
                    String random = String.valueOf(valorDado);
                    this.list_extras.add(random);
                    this.adapter.notifyDataSetChanged();
                    Toast.makeText(this, "Elemento aleatorio añadido", Toast.LENGTH_SHORT).show();
                } else {
                    this.list_extras.add(et_new_item.getText().toString());
                    this.adapter.notifyDataSetChanged();
                    Toast.makeText(this, "Elemento añadido", Toast.LENGTH_SHORT).show();
                }
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void guardar(View v) {

        String name = et_name.getText().toString();
        String surname = et_surname.getText().toString();
        String age = et_age.getText().toString();

        if(name.isEmpty() || surname.isEmpty() || age.isEmpty()) {
            Toast.makeText(this, "Los campos son obligatorios", Toast.LENGTH_SHORT).show();
        } else {
            secondScreen = new Intent(this, MainActivity2.class);
            SharedPreferences pref = getSharedPreferences(getString(R.string.pref_fileName), MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString(getString(R.string.pref_name), name);
            editor.putString(getString(R.string.pref_surname), surname);
            editor.putString(getString(R.string.pref_age), age);
            editor.commit();
            startActivity(secondScreen);
        }
    }

    public void init() {

        et_name = (EditText) findViewById(R.id.et_name);
        et_surname = (EditText) findViewById(R.id.et_surname);
        et_age = (EditText) findViewById(R.id.et_age);
        et_new_item = (EditText) findViewById(R.id.et_new_item);

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_surname = (TextView) findViewById(R.id.tv_surname);
        tv_age = (TextView) findViewById(R.id.tv_age);
        tv_formulario = (TextView) findViewById(R.id.tv_formulario);

        btn_guardar = (Button) findViewById(R.id.btn_guardar);
    }
}
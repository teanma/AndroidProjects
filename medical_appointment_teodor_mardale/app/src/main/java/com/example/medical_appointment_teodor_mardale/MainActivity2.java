package com.example.medical_appointment_teodor_mardale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

public class MainActivity2 extends AppCompatActivity {

    TextView tv_modalidad;
    EditText et_nueva_modalidad;

    ListView lv_modalidades;

    ArrayList<String> list;

    ArrayAdapter<String> adapter;

    String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        lv_modalidades = (ListView) findViewById(R.id.lv_modalidad);

        list = new ArrayList<String>();
        list.add("Presencial");
        list.add("Telefónica");
        list.add("Urgencia");
        list.add("Partes de baja/alta");

        adapter = new ArrayAdapter<String>(this, R.layout.list_view, R.id.tv_aux, list);

        lv_modalidades.setAdapter(adapter);

        registerForContextMenu(lv_modalidades);

        Intent thirdScreen = new Intent(this, MainActivity3.class);

        lv_modalidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = list.get(i);
                SharedPreferences pref = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(getString(R.string.pref_modality), selectedItem);
                editor.commit();
                startActivity(thirdScreen);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(Menu.NONE, 1, Menu.NONE, "Añadir");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String nueva_modalidad = et_nueva_modalidad.getText().toString();

        switch (item.getItemId()) {
            case 1:
                if (et_nueva_modalidad.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Añada un elemento nuevo", Toast.LENGTH_SHORT).show();
                } else {
                    this.list.add(nueva_modalidad);
                    this.adapter.notifyDataSetChanged();
                    Toast.makeText(this, "Elemento nuevo añadido", Toast.LENGTH_SHORT).show();
                    return true;
                }
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.mi_eliminar:
                this.list.remove(info.position);
                this.adapter.notifyDataSetChanged();
                Toast.makeText(this, "Elemento eliminado", Toast.LENGTH_SHORT).show();
                return true;
            default:
                super.onContextItemSelected(item);
        }
        return true;
    }

    public void init() {
        tv_modalidad = (TextView) findViewById(R.id.tv_modalidad);

        et_nueva_modalidad = (EditText) findViewById(R.id.et_nueva_modalidad);
    }
}
package com.example.tarea5_listviewmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView lv_items;

    ArrayList<String> list;

    ArrayAdapter<String> adapter;

    EditText et_elemento_introducido;

    Intent secondaryScreen;

    String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        registerForContextMenu(lv_items);

        ListView itemsList = (ListView) findViewById(R.id.lv_items);

        list = new ArrayList<String>();
        list.add("Cacahuetes");
        list.add("Pistachos");
        list.add("Anacardos");
        list.add("Almendras");

        adapter = new ArrayAdapter<String>(this, R.layout.list_view, R.id.tv_aux_menu_item, list);

        itemsList.setAdapter(adapter);

        secondaryScreen = new Intent(this, MainActivity2.class);

        itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                selectedItem = list.get(i);
                SharedPreferences prefItem = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE);
                SharedPreferences.Editor editorItem = prefItem.edit();
                editorItem.putString(getString(R.string.pref_selected_item), selectedItem);
                editorItem.commit();
                startActivity(secondaryScreen);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Seleccione opci??n");

        menu.add(0, 1, 0, "Borrar");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.cl_main_activity);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()) {
            case 1:
                this.list.remove(info.position);
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
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_nuevo:
                if (et_elemento_introducido.getText().toString().isEmpty()) {
                    Random r = new Random();
                    int valorDado = r.nextInt(6)+1;
                    String random = String.valueOf(valorDado);
                    this.list.add(random);
                    this.adapter.notifyDataSetChanged();
                    Toast.makeText(this, "Elemento aleatorio a??adido", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    this.list.add((et_elemento_introducido.getText().toString()));
                    this.adapter.notifyDataSetChanged();
                    Toast.makeText(this, "Elemento a??adido", Toast.LENGTH_SHORT).show();
                    et_elemento_introducido.setText("");
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void init() {
        lv_items = (ListView) findViewById(R.id.lv_items);

        et_elemento_introducido = (EditText) findViewById(R.id.et_elemento_introducido);
    }
}
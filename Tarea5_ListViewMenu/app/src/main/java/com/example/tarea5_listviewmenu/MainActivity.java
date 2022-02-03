package com.example.tarea5_listviewmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_items;

    ArrayList<String> list;

    ArrayAdapter<String> adapter;

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

        itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                /*selectedItem = (String) parent.getItemAtPosition(i);
                Toast.makeText(parent.getContext(), "Has elegido " + selectedItem, Toast.LENGTH_SHORT).show();*/
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //getMenuInflater().inflate(R.menu.menu, menu);

        menu.setHeaderTitle("Seleccione opción");

        menu.add(0, 1, 0, "Borrar");
        menu.add(0, 2, 0, "Detalles");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.cl_main_activity);

        if(item.getItemId() == 1) {
            Toast.makeText(this, "Elemento borrado", Toast.LENGTH_SHORT).show();
            constraintLayout.getContext();
        } else if(item.getItemId() == 2) {
            Toast.makeText(this, "Mostrando detalles", Toast.LENGTH_SHORT).show();
            constraintLayout.getContext();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mi_nuevo) {
            Toast.makeText(this, "Elemento nuevo añadido", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void init() {
        lv_items = (ListView) findViewById(R.id.lv_items);
    }
}
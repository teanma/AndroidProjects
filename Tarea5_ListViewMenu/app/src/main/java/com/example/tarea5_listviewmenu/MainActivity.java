package com.example.tarea5_listviewmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
                selectedItem = (String) parent.getItemAtPosition(i);
                Toast.makeText(parent.getContext(), "Has elegido " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu, menu);

        menu.add(0, 1, 0, "Crear");
        menu.add(0, 2, 0, "Borrar");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void init() {
        lv_items = (ListView) findViewById(R.id.lv_items);
    }
}
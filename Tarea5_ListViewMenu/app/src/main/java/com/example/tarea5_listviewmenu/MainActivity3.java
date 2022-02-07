package com.example.tarea5_listviewmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView tv_selected_item, tv_introduced_name, tv_introduced_surname, tv_introduced_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();

        SharedPreferences prefSelected = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE);
        String itemName = prefSelected.getString(getString(R.string.pref_selected_item), getString(R.string.def_value));
        tv_selected_item.setText(itemName);
        String nameUser = prefSelected.getString(getString(R.string.pref_name), getString(R.string.def_value));
        tv_introduced_name.setText(nameUser);
        String surnameUser = prefSelected.getString(getString(R.string.pref_surname), getString(R.string.def_value));
        tv_introduced_surname.setText(surnameUser);
        String ageUser = prefSelected.getString(getString(R.string.pref_age), getString(R.string.def_value));
        tv_introduced_age.setText(ageUser);
    }

    public void init() {
        tv_selected_item = (TextView) findViewById(R.id.tv_selected_item);
        tv_introduced_name = (TextView) findViewById(R.id.tv_introduced_name);
        tv_introduced_surname = (TextView) findViewById(R.id.tv_introduced_surname);
        tv_introduced_age = (TextView) findViewById(R.id.tv_introduced_age);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi2_anterior:
                Intent secondaryScreen = new Intent(this, MainActivity2.class);
                startActivity(secondaryScreen);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
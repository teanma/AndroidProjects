package com.example.repasoexamen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView tv_intro_name, tv_intro_surname, tv_intro_age, tv_intro_extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();

        SharedPreferences pref = getSharedPreferences(getString(R.string.pref_fileName), MODE_PRIVATE);
        String name = pref.getString(getString(R.string.pref_name), getString(R.string.pref_def));
        tv_intro_name.setText(name);
        String surname = pref.getString(getString(R.string.pref_surname), getString(R.string.pref_def));
        tv_intro_surname.setText(surname);
        String age = pref.getString(getString(R.string.pref_age), getString(R.string.pref_def));
        tv_intro_age.setText(age);
        String extra = pref.getString(getString(R.string.pref_extra), getString(R.string.pref_def));
        tv_intro_extra.setText(extra);
    }

    /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Elige opción");

        menu.add(0, 1, 0, "Volver");
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        Intent secondScreen = new Intent(this, MainActivity2.class);

        startActivity(secondScreen);

        return true;
    }

    public void init() {
        tv_intro_name = (TextView) findViewById(R.id.tv_intro_name);
        tv_intro_surname = (TextView) findViewById(R.id.tv_intro_surname);
        tv_intro_age = (TextView) findViewById(R.id.tv_intro_age);
        tv_intro_extra = (TextView) findViewById(R.id.tv_intro_extra);
    }
}
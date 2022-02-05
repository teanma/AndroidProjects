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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent secondaryScreen = getIntent();

        String tv_item = secondaryScreen.getStringExtra(MainActivity.MAINACTIVITY_SELECTED_ITEM);
        String tv_name = secondaryScreen.getStringExtra(MainActivity2.MAINACTIVITY2_NAME);
        String tv_surname = secondaryScreen.getStringExtra(MainActivity2.MAINACTIVITY2_SURNAME);
        String tv_age = secondaryScreen.getStringExtra(MainActivity2.MAINACTIVITY2_AGE);

        TextView tv_selected_item = (TextView) findViewById(R.id.tv_selected_item);
        TextView tv_introduced_name = (TextView) findViewById(R.id.tv_introduced_name);
        TextView tv_introduced_surname = (TextView) findViewById(R.id.tv_introduced_surname);
        TextView tv_introduced_age = (TextView) findViewById(R.id.tv_introduced_age);

        SharedPreferences prefItem = getSharedPreferences("configItem", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorItem = prefItem.edit();
        String itemName = prefItem.getString(getString(R.string.tv_item), tv_item);
        tv_selected_item.setText(itemName);
        String nameUser = prefItem.getString(getString(R.string.tv_name), tv_name);
        tv_introduced_name.setText(nameUser);
        String surnameUser = prefItem.getString(getString(R.string.tv_surname), tv_surname);
        tv_introduced_surname.setText(surnameUser);
        String ageUser = prefItem.getString(getString(R.string.tv_age), tv_age);
        tv_introduced_age.setText(ageUser);
        editorItem.commit();
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
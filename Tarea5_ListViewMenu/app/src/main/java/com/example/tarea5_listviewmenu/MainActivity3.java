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

        TextView tv_selected_item = (TextView) findViewById(R.id.tv_selected_item);
        TextView tv_introduced_name = (TextView) findViewById(R.id.tv_introduced_name);
        TextView tv_introduced_surname = (TextView) findViewById(R.id.tv_introduced_surname);
        TextView tv_introduced_age = (TextView) findViewById(R.id.tv_introduced_age);

        SharedPreferences prefSelected = getSharedPreferences("configItem", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorItem = prefSelected.edit();
        String itemName = prefSelected.getString("selectedItem", "selectedItemValue");
        tv_selected_item.setText(itemName);
        String nameUser = prefSelected.getString("name", "nameValue");
        tv_introduced_name.setText(nameUser);
        String surnameUser = prefSelected.getString("surname", "surnameValue");
        tv_introduced_surname.setText(surnameUser);
        String ageUser = prefSelected.getString("age", "ageValue");
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
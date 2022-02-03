package com.example.tarea5_listviewmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent mainScreen = getIntent();

        String tv_elemento_seleccionado = mainScreen.getStringExtra(MainActivity.MAINACTIVITY_SELECTED_ITEM);

        TextView tv_elemento = (TextView) findViewById(R.id.tv_elemento);
        tv_elemento.setText(tv_elemento_seleccionado);
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
            case R.id.mi_volver:
                Intent mainScreen = new Intent(this, MainActivity.class);
                startActivity(mainScreen);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
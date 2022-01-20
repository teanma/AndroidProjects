package com.example.menuproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    protected static final String MAINACTIVITY_NAME = "com.example.menuproject.name";

    TextView tv_nombre2, tv_nom_rec;
    EditText et_nombre2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();

        Intent pantallaPrincipal = getIntent();

        String name = pantallaPrincipal.getStringExtra(MainActivity.MAINACTIVITY_NAME);

        tv_nom_rec.setText(name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu2) {
        super.onCreateOptionsMenu(menu2);
        getMenuInflater().inflate(R.menu.menu2, menu2);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi2_anterior:
                String name = et_nombre2.getText().toString();
                Intent pantallaPrincipal = new Intent(this, MainActivity.class);
                pantallaPrincipal.putExtra(MAINACTIVITY_NAME, name);
                startActivity(pantallaPrincipal);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void init() {

        tv_nombre2 = (TextView) findViewById(R.id.tv_nombre2);
        tv_nom_rec = (TextView) findViewById(R.id.tv_nom_rec);

        et_nombre2 = (EditText) findViewById(R.id.et_nombre2);
    }
}
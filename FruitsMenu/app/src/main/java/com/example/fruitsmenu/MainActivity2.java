package com.example.fruitsmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    ImageView iv_selected_fruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
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
            case R.id.sc_golden:
                iv_selected_fruit.setImageResource(R.drawable.golden);
                return true;
            case R.id.sc_pink_lady:
                iv_selected_fruit.setImageResource(R.drawable.pink_lady);
                return true;
            case R.id.sc_platanos:
                iv_selected_fruit.setImageResource(R.drawable.platano);
                return true;
            case R.id.sc_conferencia:
                iv_selected_fruit.setImageResource(R.drawable.conferencia);
                return true;
            case R.id.sc_limonera:
                iv_selected_fruit.setImageResource(R.drawable.limonera);
                return true;
            case R.id.mi_anterior:
                Intent pantallaPrincipal = new Intent(this, MainActivity.class);
                startActivity(pantallaPrincipal);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void init() {

        iv_selected_fruit = (ImageView) findViewById(R.id.iv_selected_fruit);
    }
}
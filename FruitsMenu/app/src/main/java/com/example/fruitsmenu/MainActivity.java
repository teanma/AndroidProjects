package com.example.fruitsmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    protected static final String MAINACTIVITY_SELECTED_FRUIT = "com.example.fruitsmenu.selected_fruit";

    ImageView iv_frutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        //getMenuInflater().inflate(R.menu.menu, menu);
        SubMenu subMenu1 = menu.addSubMenu(Menu.NONE, 1, Menu.NONE, "Manzanas");
        subMenu1.addSubMenu(Menu.NONE, 11, Menu.NONE, "Golden");
        subMenu1.addSubMenu(Menu.NONE, 12, Menu.NONE, "Pink Lady");

        menu.add(Menu.NONE,2,Menu.NONE,"Plátanos");

        SubMenu subMenu2 = menu.addSubMenu(Menu.NONE, 3, Menu.NONE, "Peras");
        subMenu2.addSubMenu(Menu.NONE, 31, Menu.NONE, "Conferencia");
        subMenu2.addSubMenu(Menu.NONE, 32, Menu.NONE, "Limonera");

        menu.add(Menu.NONE, 4,Menu.NONE, "Siguiente");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        iv_frutas = (ImageView) findViewById(R.id.iv_frutas);
        switch (item.getItemId()) {
            case 11:
                iv_frutas.setImageResource(R.drawable.golden);
                return true;
            case 12:
                iv_frutas.setImageResource(R.drawable.pink_lady);
                return true;
            case 2:
                iv_frutas.setImageResource(R.drawable.platano);
                return true;
            case 31:
                iv_frutas.setImageResource(R.drawable.conferencia);
                return true;
            case 32:
                iv_frutas.setImageResource(R.drawable.limonera);
                return true;
            case 4:
                Intent pantallaSecundaria = new Intent(this, MainActivity2.class);
                startActivity(pantallaSecundaria);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
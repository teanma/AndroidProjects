package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_longPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        registerForContextMenu(tv_longPress);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu, menu);

        menu.setHeaderTitle("Choose a color");

        menu.add(0, 1, 0, "Yellow");
        menu.add(0, 2, 0, "Gray");
        menu.add(0, 3, 0, "Cyan");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.cl_mainActivity);

        if (item.getTitle() == "Yellow") {
            constraintLayout.setBackgroundColor(Color.YELLOW);
        } else if (item.getItemId() == 2) {
            constraintLayout.setBackgroundColor(Color.GRAY);
        } else if (item.getTitle() == "Cyan") {
            constraintLayout.setBackgroundColor(Color.CYAN);
        }

        return true;
    }

    public void init() {

        tv_longPress = (TextView) findViewById(R.id.tv_longPress);
    }
}
package com.example.listviewgraphiccard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent mainScreen = getIntent();

        String graphic_card = mainScreen.getStringExtra(MainActivity.MAINACTIVITY_GRAPHIC_CARD);

        TextView tv_1030_quantity = (TextView) findViewById(R.id.tv_1030_quantity);
        tv_1030_quantity.setText(graphic_card);
        TextView tv_2060_quantity = (TextView) findViewById(R.id.tv_2060_quantity);
        tv_2060_quantity.setText(graphic_card);
        TextView tv_3060_quantity = (TextView) findViewById(R.id.tv_3060_quantity);
        tv_3060_quantity.setText(graphic_card);
        TextView tv_3090_quantity = (TextView) findViewById(R.id.tv_3090_quantity);
        tv_3090_quantity.setText(graphic_card);
    }
}
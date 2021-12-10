package com.example.listviewgraphiccard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent mainScreen = getIntent();
        List<String> graphicList = mainScreen.getStringArrayListExtra(MainActivity.MAINACTIVITY_GRAPHIC_CARD);
        tv_res = (TextView) findViewById(R.id.tv_quantity);
        int cant_1030 = 0;
        int cant_2060 = 0;
        int cant_3060 = 0;
        int cant_3090 = 0;
        for (String list : graphicList) {
            if (list.equals("1030")) {
                cant_1030++;
            } else if (list.equals("2060")) {
                cant_2060++;
            } else if (list.equals("3060")) {
                cant_3060++;
            } else if (list.equals("3090")) {
                cant_3090++;
            }
        }
        tv_res.setText("1030: " + cant_1030 + "\n" + "2060: " + cant_2060 + "\n" + "3060: " + cant_3060 + "\n" + "3090: " + cant_3090);
    }

    public void backToHome(View v) {
        Intent mainScreen = new Intent(this, MainActivity.class);
        startActivity(mainScreen);
    }
}
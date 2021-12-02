package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent mainScreen = getIntent();

        String operating_system = mainScreen.getStringExtra(MainActivity.MAINACTIVITY_OPERATING_SYSTEM);
        String version = mainScreen.getStringExtra(MainActivity.MAINACTIVITY_VERSION);

        TextView tv_selected_os = (TextView) findViewById(R.id.tv_selected_os);
        tv_selected_os.setText(operating_system);
        TextView tv_selected_version = (TextView) findViewById(R.id.tv_selected_version);
        tv_selected_version.setText(version);
    }

    public void backToHome(View v) {
        Intent mainScreen = new Intent(this, MainActivity.class);
        startActivity(mainScreen);
    }
}
package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    protected final static String MAINACTIVITY_OPERATING_SYSTEM = "com.example.listviewexample.operating_system";
    protected final static String MAINACTIVITY_VERSION = "com.example.listviewexample.version";

    TextView tv_select_fruit;
    ListView lv_operating_systems;
    RadioButton rb_windows7, rb_windows10, rb_windows11, rb_ubuntu, rb_red_hat, rb_linux_others;
    RadioGroup rg_windows_versions, rg_linux_versions;
    Button btn_load_info;
    String selectedItem;
    boolean isSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        rg_windows_versions.setVisibility(View.GONE);
        rg_linux_versions.setVisibility(View.GONE);

        ListView lv_operating_systems = (ListView) findViewById(R.id.lv_operating_systems);

        String[] os = {"Windows", "Linux", "iOS", "Others"};

        ArrayAdapter aa_os = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, os);

        lv_operating_systems.setAdapter(aa_os);

        lv_operating_systems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(), "OS selected: " + selectedItem, Toast.LENGTH_SHORT).show();
                switch (selectedItem) {
                    case "Windows":
                        rg_windows_versions.setVisibility(View.VISIBLE);
                        rg_linux_versions.setVisibility(View.GONE);
                        isSelected= true;
                        break;
                    case "Linux":
                        rg_linux_versions.setVisibility(View.VISIBLE);
                        rg_windows_versions.setVisibility(View.GONE);
                        isSelected= true;
                        break;
                    case "iOS":
                    case "Others":
                        rg_linux_versions.setVisibility(View.GONE);
                        rg_windows_versions.setVisibility(View.GONE);
                        isSelected= true;
                        break;
                }
            }
        });
    }

    public void initialize() {
        tv_select_fruit = (TextView) findViewById(R.id.tv_select_os);
        lv_operating_systems = (ListView) findViewById(R.id.lv_operating_systems);
        rb_windows7 = (RadioButton) findViewById(R.id.rb_windows7);
        rb_windows10 = (RadioButton) findViewById(R.id.rb_windows10);
        rb_windows11 = (RadioButton) findViewById(R.id.rb_windows11);
        rb_ubuntu = (RadioButton) findViewById(R.id.rb_ubuntu);
        rb_red_hat = (RadioButton) findViewById(R.id.rb_red_hat);
        rb_linux_others = (RadioButton) findViewById(R.id.rb__linux_others);
        rg_windows_versions = (RadioGroup) findViewById(R.id.rg_windows_versions);
        rg_linux_versions = (RadioGroup) findViewById(R.id.rg_linux_versions);
        btn_load_info = (Button) findViewById(R.id.btn_load_info);
    }

    public void loadInfo(View v) {
        String windows = "Windows";
        String windows7 = "7";
        String windows10 = "10";
        String windows11 = "11";
        String linux = "Linux";
        String ubuntu = "Ubuntu";
        String red_hat = "RedHat";
        String linux_others = "Another Linux version";
        String ios = "iOS";
        String others = "Others";

        if (!isSelected) {
            Toast.makeText(this, "Select an operating system", Toast.LENGTH_SHORT).show();
        } else if (!rb_windows7.isChecked() && !rb_windows10.isChecked() && !rb_windows10.isChecked() && !rb_ubuntu.isChecked() && !rb_red_hat.isChecked() && !rb_linux_others.isChecked()) {
            Toast.makeText(this, "Select a version", Toast.LENGTH_SHORT).show();
        } else {
            Intent secondaryScreen = new Intent(this, MainActivity2.class);
            if (rb_windows7.isChecked()) {
                secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, windows);
                secondaryScreen.putExtra(MAINACTIVITY_VERSION, windows7);
            } else if (rb_windows10.isChecked()) {
                secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, windows);
                secondaryScreen.putExtra(MAINACTIVITY_VERSION, windows10);
            } else if (rb_windows11.isChecked()) {
                secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, windows);
                secondaryScreen.putExtra(MAINACTIVITY_VERSION, windows11);
            } else if (rb_ubuntu.isChecked()) {
                secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, linux);
                secondaryScreen.putExtra(MAINACTIVITY_VERSION, ubuntu);
            } else if (rb_red_hat.isChecked()) {
                secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, linux);
                secondaryScreen.putExtra(MAINACTIVITY_VERSION, red_hat);
            } else if (rb_linux_others.isChecked()) {
                secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, linux);
                secondaryScreen.putExtra(MAINACTIVITY_VERSION, linux_others);
            } else if (selectedItem.equals(ios)) {
                secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, ios);
                secondaryScreen.putExtra(MAINACTIVITY_VERSION, "No available version");
            } else {
                secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, others);
                secondaryScreen.putExtra(MAINACTIVITY_VERSION, "No available version");
            }
            startActivity(secondaryScreen);
        }
    }
}
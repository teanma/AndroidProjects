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

public class MainActivity extends AppCompatActivity {

    protected final static String MAINACTIVITY_OPERATING_SYSTEM = "com.example.listviewexample.operating_system";
    protected final static String MAINACTIVITY_VERSION = "com.example.listviewexample.version";

    TextView tv_select_fruit;
    ListView lv_operating_systems;
    RadioButton rb_windows7, rb_windows10, rb_windows11, rb_ubuntu, rb_red_hat, rb_linux_others;
    RadioGroup rg_windows_versions, rg_linux_versions;
    Button btn_load_info;

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
                String selected = parent.getSelectedItem().toString();
                Toast.makeText(parent.getContext(), "OS selected " + selected, Toast.LENGTH_SHORT).show();
                if (selected.equals("Windows")) {
                    rg_windows_versions.setVisibility(View.VISIBLE);
                } else if (selected.equals("Linux")) {
                    rg_linux_versions.setVisibility(View.VISIBLE);
                } else {
                    rg_linux_versions.setVisibility(View.GONE);
                    rg_windows_versions.setVisibility(View.GONE);
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
        String windows7 = "Windows 7";
        String windows10 = "Windows 10";
        String windows11 = "Windows 11";
        String linux = "Linux";
        String ubuntu = "Ubuntu";
        String red_hat = "RedHat";
        String linux_others = "Another Linux version";
        String iOS = "iOS";
        String others = "Others";

        Intent secondaryScreen = new Intent(this, MainActivity2.class);
        if (rb_windows7.isChecked()) {
            secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, windows);
            secondaryScreen.putExtra(MAINACTIVITY_VERSION, windows7);
        }
        if (rb_windows10.isChecked()) {
            secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, windows);
            secondaryScreen.putExtra(MAINACTIVITY_VERSION, windows10);
        }
        if (rb_windows11.isChecked()) {
            secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, windows);
            secondaryScreen.putExtra(MAINACTIVITY_VERSION, windows11);
        }
        if (rb_ubuntu.isChecked()) {
            secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, linux);
            secondaryScreen.putExtra(MAINACTIVITY_VERSION, ubuntu);
        }
        if (rb_red_hat.isChecked()) {
            secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, linux);
            secondaryScreen.putExtra(MAINACTIVITY_VERSION, red_hat);
        }
        if (rb_linux_others.isChecked()) {
            secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, linux);
            secondaryScreen.putExtra(MAINACTIVITY_VERSION, linux_others);
        }
        secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, iOS);
        secondaryScreen.putExtra(MAINACTIVITY_OPERATING_SYSTEM, others);
        startActivity(secondaryScreen);
    }
}
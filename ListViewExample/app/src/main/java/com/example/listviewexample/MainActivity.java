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

    protected final static String MAINACTIVITY_WINDOWS7 = "com.example.listviewexample.windows7";
    protected final static String MAINACTIVITY_WINDOWS10 = "com.example.listviewexample.windows10";
    protected final static String MAINACTIVITY_WINDOWS11 = "com.example.listviewexample.windows11";
    protected final static String MAINACTIVITY_UBUNTU = "com.example.listviewexample.ubuntu";
    protected final static String MAINACTIVITY_RED_HAT = "com.example.listviewexample.red_hat";
    protected final static String MAINACTIVITY_LINUX_OTHERS = "com.example.listviewexample.linux_others";
    protected final static String MAINACTIVITY_IOS = "com.example.listviewexample.ios";
    protected final static String MAINACTIVITY_OTHERS = "com.example.listviewexample.others";

    TextView tv_select_fruit;
    RadioButton rb_windows7, rb_windows10, rb_windows11, rb_ubuntu, rb_red_hat, rb_linux_others;
    RadioGroup rg_windows_versions, rg_linux_versions;
    Button btn_load_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_windows_versions.setVisibility(View.GONE);
        rg_linux_versions.setVisibility(View.GONE);

        initialize();

        ListView lv_fruits = (ListView) findViewById(R.id.lv_fruits);

        String[] fruits = {"Windows", "Linux", "iOS", "Others"};

        ArrayAdapter aa_fruits = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fruits);

        lv_fruits.setAdapter(aa_fruits);

        lv_fruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getSelectedItem().toString();
                if (selected.equals("Windows")) {
                    rg_windows_versions.setVisibility(View.VISIBLE);
                    rg_linux_versions.setVisibility(View.GONE);
                    Toast.makeText(parent.getContext(), "You have selected the option: " + selected, Toast.LENGTH_SHORT).show();
                } else if (selected.equals("Linux")) {
                    rg_linux_versions.setVisibility(View.VISIBLE);
                    rg_windows_versions.setVisibility(View.GONE);
                    Toast.makeText(parent.getContext(), "You have selected the option: " + selected, Toast.LENGTH_SHORT).show();
                } else if (selected.equals("iOS")) {
                    rg_linux_versions.setVisibility(View.GONE);
                    rg_windows_versions.setVisibility(View.GONE);
                    Toast.makeText(parent.getContext(), "You have selected the option: " + selected, Toast.LENGTH_SHORT).show();
                } else {
                    rg_linux_versions.setVisibility(View.GONE);
                    rg_windows_versions.setVisibility(View.GONE);
                    Toast.makeText(parent.getContext(), "You have selected the option: " + selected, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void initialize() {
        tv_select_fruit = (TextView) findViewById(R.id.tv_selecct_fruit);
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
        String windows7 = "Windows 7";
        String windows10 = "Windows 10";
        String windows11 = "Windows 11";
        String ubuntu = "Ubuntu";
        String red_hat = "RedHat";
        String linux_others = "Another linux's version";
        String iOS = "iOS";
        String others = "Others";

        Intent secondaryScreen = new Intent(this, MainActivity2.class);
        if (rb_windows7.isChecked()) {
            secondaryScreen.putExtra(MAINACTIVITY_WINDOWS7, windows7);
        }
        if (rb_windows10.isChecked()) {
            secondaryScreen.putExtra(MAINACTIVITY_WINDOWS10, windows10);
        }
        if (rb_windows11.isChecked()) {
            secondaryScreen.putExtra(MAINACTIVITY_WINDOWS11, windows11);
        }
        if (rb_ubuntu.isChecked()) {
            secondaryScreen.putExtra(MAINACTIVITY_UBUNTU, ubuntu);
        }
        if (rb_red_hat.isChecked()) {
            secondaryScreen.putExtra(MAINACTIVITY_RED_HAT, red_hat);
        }
        if (rb_linux_others.isChecked()) {
            secondaryScreen.putExtra(MAINACTIVITY_LINUX_OTHERS, linux_others);
        }
        secondaryScreen.putExtra(MAINACTIVITY_IOS, iOS);
        secondaryScreen.putExtra(MAINACTIVITY_OTHERS, others);
    }
}
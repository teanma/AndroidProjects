package com.example.randompreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tv_tot_aciertos, tv_tot_intentos, tv_por_aciertos, tv_med_intentos;

    Intent mainScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getInformation();
    }

        /*Intent mainScreen = getIntent();*/

        /*int attempts_average = mainScreen.getIntExtra(String.valueOf(MainActivity.ATTEMPTS_AVERAGE), 0);

        int hit_percentage = mainScreen.getIntExtra(String.valueOf(MainActivity.HIT_PERCENTAGE), 0);*/


    public void getInformation() {

        tv_tot_aciertos = (TextView) findViewById(R.id.tv_tot_aciertos);
        tv_tot_intentos = (TextView) findViewById(R.id.tv_tot_intentos);
        tv_por_aciertos = (TextView) findViewById(R.id.tv_por_aciertos);
        tv_med_intentos = (TextView) findViewById(R.id.tv_med_intentos);

        /*SharedPreferences prefSelected = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE);
        String hits = prefSelected.getString("pref_hits", "def_value");
        tv_tot_aciertos.setText(hits);
        String attempts = prefSelected.getString("pref_attempts", "def_value");
        tv_tot_intentos.setText(attempts);*/
        tv_por_aciertos.setText(String.valueOf(getIntent().getIntExtra(MainActivity.HIT_PERCENTAGE,0)) +  "%");
        tv_med_intentos.setText(String.valueOf(getIntent().getIntExtra(MainActivity.ATTEMPTS_AVERAGE,0)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu2) {
        super.onCreateOptionsMenu(menu2);
        menu2.add(Menu.NONE, 1, Menu.NONE,"Anterior");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                mainScreen = new Intent(this, MainActivity.class);
                startActivity(mainScreen);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
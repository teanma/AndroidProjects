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

    private double media;

    private double porcentaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
    }

    public void init() {
        tv_tot_aciertos = (TextView) findViewById(R.id.tv_tot_aciertos);
        tv_tot_intentos = (TextView) findViewById(R.id.tv_tot_intentos);
        tv_por_aciertos = (TextView) findViewById(R.id.tv_por_aciertos);
        tv_med_intentos = (TextView) findViewById(R.id.tv_med_intentos);

        Intent mainScreen = getIntent();

        int attempts_average = mainScreen.getIntExtra(String.valueOf(MainActivity.ATTEMPTS_AVERAGE), 0);

        int hit_percentage = mainScreen.getIntExtra(String.valueOf(MainActivity.HIT_PERCENTAGE), 0);

        SharedPreferences prefSelected = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE);
        String hits = prefSelected.getString(getString(R.string.pref_hits), (getString(R.string.def_value)));
        tv_tot_aciertos.setText(hits);
        String attempts = prefSelected.getString(getString(R.string.pref_attempts), (getString(R.string.def_value)));
        tv_tot_intentos.setText(attempts);
       /* media = attempts/hits;
        porcentaje = hits*100/attempts;*/
        String por_aciertos = prefSelected.getString(getString(R.string.pref_hit_percentage), String.valueOf(attempts_average));
        tv_por_aciertos.setText(por_aciertos);
        String med_intentos = prefSelected.getString(getString(R.string.pref_attempts_average), String.valueOf(hit_percentage));
        tv_med_intentos.setText(med_intentos);
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
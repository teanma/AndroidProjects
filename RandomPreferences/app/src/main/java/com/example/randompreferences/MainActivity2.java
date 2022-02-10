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

    int media;

    int porcentaje;

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

        SharedPreferences prefSelected = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE);
        int hits = prefSelected.getInt(getString(R.string.pref_hits), Integer.parseInt(getString(R.string.def_value)));
        tv_tot_aciertos.setText(hits);
        int attempts = prefSelected.getInt(getString(R.string.pref_attempts), Integer.parseInt(getString(R.string.def_value)));
        tv_tot_intentos.setText(attempts);
        media = attempts/hits;
        porcentaje = hits*100/attempts;
        String por_aciertos = prefSelected.getString(getString(R.string.pref_hit_percentage), String.valueOf(porcentaje));
        tv_por_aciertos.setText(por_aciertos);
        String med_intentos = prefSelected.getString(getString(R.string.pref_attempts_average), String.valueOf(media));
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
package com.example.randompreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv_introduce_numero;

    EditText et_numero_introducido;

    Button btn_introducir_numero;

    int randomValue;

    int aciertos;

    int intentos;

    Intent secondScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Random r = new Random();
        randomValue = r.nextInt(10)+1;

        SharedPreferences pref = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(getString(R.string.random_value), String.valueOf(randomValue));
        editor.putString(getString(R.string.pref_hits), String.valueOf(aciertos));
        editor.putString(getString(R.string.pref_attempts), String.valueOf(intentos));
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, 1, Menu.NONE,"Estadísticas");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                secondScreen = new Intent(this, MainActivity2.class);
                SharedPreferences prefFormulary = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefFormulary.edit();
                editor.putString(getString(R.string.pref_hits), String.valueOf(aciertos));
                editor.putString(getString(R.string.pref_attempts), String.valueOf(intentos));
                editor.commit();
                startActivity(secondScreen);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void init() {
        tv_introduce_numero = (TextView) findViewById(R.id.tv_introduce_numero);
        et_numero_introducido = (EditText) findViewById(R.id.et_numero_introducido);
        btn_introducir_numero = (Button) findViewById(R.id.btn_introducir_numero);
    }

    public void introducirNumero(View v) {

        int number = Integer.parseInt(et_numero_introducido.getText().toString());

        if(number < randomValue) {
            Toast.makeText(this, "El número introducido es menor que el generado", Toast.LENGTH_SHORT).show();
            intentos++;

        } else if (number > randomValue) {
            Toast.makeText(this, "El número introducido es mayor que el generado", Toast.LENGTH_SHORT).show();
            intentos++;

        } else {
            Toast.makeText(this, "Acertaste el número", Toast.LENGTH_SHORT).show();
            aciertos++;
            Random r = new Random();
            randomValue = r.nextInt(10)+1;
            SharedPreferences pref = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("número aleatorio", String.valueOf(randomValue));
            editor.commit();
        }
    }
}
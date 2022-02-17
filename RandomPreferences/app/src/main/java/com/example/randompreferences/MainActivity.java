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

    protected static final String ATTEMPTS_AVERAGE = "com.example.randompreferences.attempts_average";

    protected static final String HIT_PERCENTAGE = "com.example.randompreferences.hit_percentage";

    TextView tv_introduce_numero;

    EditText et_numero_introducido;

    Button btn_introducir_numero;

    int randomValue;

    int hits;

    int attempts;

    Intent secondScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences();
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
                hits = prefFormulary.getInt("pref_hits", -1);
                attempts = prefFormulary.getInt("pref_attempts", -1);
                int average = attempts/hits;
                int percentage = hits*100/attempts;
                secondScreen.putExtra(ATTEMPTS_AVERAGE, average);
                secondScreen.putExtra(HIT_PERCENTAGE, percentage);
                startActivity(secondScreen);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void preferences() {

        SharedPreferences prefHitAttempt = getSharedPreferences(getString(R.string.pref_file_name), Context.MODE_PRIVATE);
        SharedPreferences.Editor editorHitAttempt = prefHitAttempt.edit();

        hits = prefHitAttempt.getInt("pref_hits", -1);
        attempts = prefHitAttempt.getInt("pref_attempts", -1);

        tv_introduce_numero = (TextView) findViewById(R.id.tv_introduce_numero);
        et_numero_introducido = (EditText) findViewById(R.id.et_numero_introducido);
        btn_introducir_numero = (Button) findViewById(R.id.btn_introducir_numero);

        SharedPreferences prefFile = getSharedPreferences("random_number", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefFile.edit();

        randomValue = random();
        editor.putInt("random_value", randomValue);
        editor.commit();
        randomValue = prefFile.getInt("random_value", 20);

        btn_introducir_numero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(et_numero_introducido.getText().toString());

                if(number < randomValue) {
                    Toast.makeText(MainActivity.this, "El número introducido es menor al número generado", Toast.LENGTH_SHORT).show();
                    attempts++;
                } else if (number > randomValue) {
                    Toast.makeText(MainActivity.this, "El número introducido es mayor que el generado", Toast.LENGTH_SHORT).show();
                    attempts++;
                } else {
                    Toast.makeText(MainActivity.this, "Acertaste el número", Toast.LENGTH_SHORT).show();
                    hits++;
                    Random r = new Random();
                    randomValue = r.nextInt(10)+1;
                }
                editorHitAttempt.putInt("pref_hits", hits);
                editorHitAttempt.putInt("pref_attempts", attempts);
                editorHitAttempt.commit();
            }
        });
    }

    public int random() {
        Random r = new Random();
        return r.nextInt(10)+1;
    }
}
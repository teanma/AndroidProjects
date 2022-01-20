package com.example.menuproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static final String MAINACTIVITY_NAME = "com.example.menuproject.name";


    TextView tv_nombre, tv_nom_rec_2;
    EditText et_nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        Intent pantallaSecundaria = getIntent();

        String name = pantallaSecundaria.getStringExtra(MainActivity.MAINACTIVITY_NAME);

        tv_nom_rec_2.setText(name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_compartir:
                Toast.makeText(this, "Has pulsado la opción Compartir del menú", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mi_generar_pdf:
                Toast.makeText(this, "Has pulsado la opción Generar PDF del menú", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mi_imprimir:
                Toast.makeText(this, "Has pulsado la opción Imprimir del menú", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mi_enviar:
                Toast.makeText(this, "Has pulsado la opción Enviar del menú", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mi_marcar:
                Toast.makeText(this, "Has pulsado la opción Marcar como pagada del menú", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mi_siguiente:
                String name = et_nombre.getText().toString();
                Intent pantallaSecundaria = new Intent(this, MainActivity2.class);
                pantallaSecundaria.putExtra(MAINACTIVITY_NAME, name);
                startActivity(pantallaSecundaria);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void init() {

        tv_nombre = (TextView) findViewById(R.id.tv_nombre);
        tv_nom_rec_2 = (TextView) findViewById(R.id.tv_nom_rec_2);

        et_nombre = (EditText) findViewById(R.id.et_nombre);
    }
}
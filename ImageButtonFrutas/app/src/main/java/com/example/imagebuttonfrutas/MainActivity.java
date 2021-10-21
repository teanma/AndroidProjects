package com.example.imagebuttonfrutas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected boolean isFruitVisible;
    protected boolean isVegetableVisible;

    private ImageButton img_btn_albaricoque, img_btn_platano, img_btn_pimiento, img_btn_patata;
    private TextView tv_albaricoque, tv_platano, tv_pimiento, tv_patata, tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_btn_albaricoque = (ImageButton) findViewById(R.id.img_btn_albaricoque);
        img_btn_platano = (ImageButton) findViewById(R.id.img_btn_platano);
        img_btn_pimiento = (ImageButton) findViewById(R.id.img_btn_pimiento);
        img_btn_patata = (ImageButton) findViewById(R.id.img_btn_patata);

        tv_albaricoque = (TextView) findViewById(R.id.tv_albaricoque);
        tv_platano = (TextView) findViewById(R.id.tv_platano);
        tv_pimiento = (TextView) findViewById(R.id.tv_pimiento);
        tv_patata = (TextView) findViewById(R.id.tv_patata);
        tv_result = (TextView) findViewById(R.id.tv_result);

        img_btn_albaricoque.setVisibility(View.GONE);
        img_btn_platano.setVisibility(View.GONE);
        img_btn_pimiento.setVisibility(View.GONE);
        img_btn_patata.setVisibility(View.GONE);

        tv_albaricoque.setVisibility(View.GONE);
        tv_platano.setVisibility(View.GONE);
        tv_pimiento.setVisibility(View.GONE);
        tv_patata.setVisibility(View.GONE);

        isFruitVisible = false;
        isVegetableVisible = false;
    }

    public void showFruits(View v) {

        if (isFruitVisible) {
            tv_albaricoque.setVisibility(View.GONE);
            tv_platano.setVisibility(View.GONE);
            img_btn_albaricoque.setVisibility(View.GONE);
            img_btn_platano.setVisibility(View.GONE);
            Toast.makeText(this, "Ocultando frutas", Toast.LENGTH_SHORT).show();
            isFruitVisible = false;
        } else {
            tv_albaricoque.setVisibility(View.VISIBLE);
            tv_platano.setVisibility(View.VISIBLE);
            img_btn_albaricoque.setVisibility(View.VISIBLE);
            img_btn_platano.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Mostrando frutas", Toast.LENGTH_SHORT).show();
            isFruitVisible = true;
        }
    }

    public void showVegetables(View v) {

        if (isVegetableVisible) {
            tv_pimiento.setVisibility(View.GONE);
            tv_patata.setVisibility(View.GONE);
            img_btn_pimiento.setVisibility(View.GONE);
            img_btn_patata.setVisibility(View.GONE);
            Toast.makeText(this, "Ocultando verduras", Toast.LENGTH_SHORT).show();
            isVegetableVisible = false;
        } else {
            tv_pimiento.setVisibility(View.VISIBLE);
            tv_patata.setVisibility(View.VISIBLE);
            img_btn_pimiento.setVisibility(View.VISIBLE);
            img_btn_patata.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Mostrando verduras", Toast.LENGTH_SHORT).show();
            isVegetableVisible = true;
        }
    }

    public void addAlbaricoque(View v) {

        Toast.makeText(this, "Añadiendo albaricoques", Toast.LENGTH_SHORT).show();

        tv_result.setText("Albaricoque" + "\n" + tv_result.getText());

    }

    public void addPlatano(View v) {

        Toast.makeText(this, "Añadiendo plátanos", Toast.LENGTH_SHORT).show();

        tv_result.setText("Plátano" + "\n" + tv_result.getText());

    }

    public void addPimiento(View v) {

        Toast.makeText(this, "Añadiendo pimientos", Toast.LENGTH_SHORT).show();

        tv_result.setText("Pimiento" + "\n" + tv_result.getText());
    }

    public void addPatata(View v) {

        Toast.makeText(this, "Añadiendo patatas", Toast.LENGTH_SHORT).show();

        tv_result.setText("Patata" + "\n" + tv_result.getText());

    }
}
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

    private ImageButton img_btn_fruta, img_btn_verdura, img_btn_albaricoque, img_btn_platano, img_btn_pimiento, img_btn_patata;
    private TextView tv_fruta, tv_verdura, tv_albaricoque, tv_platano, tv_pimiento, tv_patata, tv_cesta_compra, tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_btn_fruta = (ImageButton) findViewById(R.id.img_btn_fruta);
        img_btn_verdura = (ImageButton) findViewById(R.id.img_btn_verdura);
        img_btn_albaricoque = (ImageButton) findViewById(R.id.img_btn_albaricoque);
        img_btn_platano = (ImageButton) findViewById(R.id.img_btn_platano);
        img_btn_pimiento = (ImageButton) findViewById(R.id.img_btn_pimiento);
        img_btn_patata = (ImageButton) findViewById(R.id.img_btn_patata);

        tv_fruta = (TextView) findViewById(R.id.tv_fruta);
        tv_verdura = (TextView) findViewById(R.id.tv_verdura);
        tv_albaricoque = (TextView) findViewById(R.id.tv_albaricoque);
        tv_platano = (TextView) findViewById(R.id.tv_platano);
        tv_pimiento = (TextView) findViewById(R.id.tv_pimiento);
        tv_patata = (TextView) findViewById(R.id.tv_patata);
        tv_cesta_compra = (TextView) findViewById(R.id.tv_cesta_compra);
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
        Toast.makeText(this, "Has elegido fruta", Toast.LENGTH_SHORT).show();

        img_btn_albaricoque = (ImageButton) findViewById(R.id.img_btn_albaricoque);
        img_btn_platano = (ImageButton) findViewById(R.id.img_btn_platano);

        tv_albaricoque = (TextView) findViewById(R.id.tv_albaricoque);
        tv_platano = (TextView) findViewById(R.id.tv_platano);

        if (isFruitVisible) {
            tv_albaricoque.setVisibility(View.GONE);
            tv_platano.setVisibility(View.GONE);
            img_btn_albaricoque.setVisibility(View.GONE);
            img_btn_platano.setVisibility(View.GONE);
            isFruitVisible = false;
        } else {
            tv_albaricoque.setVisibility(View.VISIBLE);
            tv_platano.setVisibility(View.VISIBLE);
            img_btn_albaricoque.setVisibility(View.VISIBLE);
            img_btn_platano.setVisibility(View.VISIBLE);
            isFruitVisible = true;
        }
    }

    public void showVegetables(View v) {
        Toast.makeText(this, "Has elegido verdura", Toast.LENGTH_SHORT).show();

        img_btn_pimiento = (ImageButton) findViewById(R.id.img_btn_pimiento);
        img_btn_patata = (ImageButton) findViewById(R.id.img_btn_patata);

        tv_pimiento = (TextView) findViewById(R.id.tv_pimiento);
        tv_patata = (TextView) findViewById(R.id.tv_patata);


        if (isVegetableVisible) {
            tv_pimiento.setVisibility(View.GONE);
            tv_patata.setVisibility(View.GONE);
            img_btn_pimiento.setVisibility(View.GONE);
            img_btn_patata.setVisibility(View.GONE);
            isVegetableVisible = false;
        } else {
            tv_pimiento.setVisibility(View.VISIBLE);
            tv_patata.setVisibility(View.VISIBLE);
            img_btn_pimiento.setVisibility(View.VISIBLE);
            img_btn_patata.setVisibility(View.VISIBLE);
            isVegetableVisible = true;
        }
    }

    public void addAlbaricoque(View v) {

        tv_result = (TextView) findViewById(R.id.tv_result);

        tv_result.setText("Albaricoque" + "\n" + tv_result.getText());

    }

    public void addPlatano(View v) {

        tv_result = (TextView) findViewById(R.id.tv_result);

        tv_result.setText("Plátano" + "\n" + tv_result.getText());

    }

    public void addPimiento(View v) {

        tv_result = (TextView) findViewById(R.id.tv_result);

        tv_result.setText("Pimiento" + "\n" + tv_result.getText());
    }

    public void addPatata(View v) {

        tv_result = (TextView) findViewById(R.id.tv_result);

        tv_result.setText("Patata" + "\n" + tv_result.getText());

    }
}
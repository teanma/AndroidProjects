package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText et_num_cont, et_num;
    Button btn_suma, btn_resta, btn_reset;
    ToggleButton tb_act_desact;
    CheckBox cb_cont_neg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_num_cont = (EditText) findViewById(R.id.et_num_cont);
        et_num = (EditText) findViewById(R.id.et_num);

        btn_suma = (Button) findViewById(R.id.btn_suma);
        btn_resta = (Button) findViewById(R.id.btn_resta);
        btn_reset = (Button) findViewById(R.id.btn_reset);

        tb_act_desact = (ToggleButton) findViewById(R.id.tb_act_desact);

        cb_cont_neg = (CheckBox) findViewById(R.id.cb_cont_neg);
    }

    public void resta(View v) {
        et_num = (EditText) findViewById(R.id.et_num);
        et_num_cont = (EditText) findViewById(R.id.et_num_cont);
        int num = Integer.parseInt(et_num.getText().toString());
        int num_cont = Integer.parseInt(et_num_cont.getText().toString());
        num_cont -= num;
        if (num_cont < 0) {
            Toast.makeText(this, "No se puede poner en números negativos", Toast.LENGTH_SHORT).show();
        } else {
            et_num_cont.setText("" + num_cont);
        }
    }

    public void suma(View v) {
        et_num = (EditText) findViewById(R.id.et_num);
        et_num_cont = (EditText) findViewById(R.id.et_num_cont);
        int num = Integer.parseInt(et_num.getText().toString());
        int num_cont = Integer.parseInt(et_num_cont.getText().toString());
        num_cont = num + num_cont;
        et_num_cont.setText("" + num_cont);
    }


    public void isNegativeRes(View v) {
        et_num = (EditText) findViewById(R.id.et_num);
        int num = Integer.parseInt(et_num.getText().toString());
        if (num <= 0) {
            Toast.makeText(this, "Introduce un número positivo", Toast.LENGTH_SHORT).show();
        } else {
            resta(v);
        }
    }

    public void isNegativeSum(View v) {
        et_num = (EditText) findViewById(R.id.et_num);
        int num = Integer.parseInt(et_num.getText().toString());
        if (num <= 0) {
            Toast.makeText(this, "Introduce un número positivo", Toast.LENGTH_SHORT).show();
        } else {
            suma(v);
        }
    }

    public void actDesact(View v) {
        if (!tb_act_desact.isChecked()) {
            Toast.makeText(this, "Has desactivado las funciones", Toast.LENGTH_SHORT).show();
            btn_reset.setVisibility(View.GONE);
            et_num.setVisibility(View.GONE);
            cb_cont_neg.setVisibility(View.GONE);
        } else {
            Toast.makeText(this, "Has activado las funciones", Toast.LENGTH_SHORT).show();
            btn_reset.setVisibility(View.VISIBLE);
            et_num.setVisibility(View.VISIBLE);
            cb_cont_neg.setVisibility(View.VISIBLE);
        }
    }

    public void resetear(View v) {
        et_num_cont.setText("0");
    }

    public void ocultarResta(View v) {
        if (!cb_cont_neg.isChecked()) {
            Toast.makeText(this, "Has ocultado el botón de resta", Toast.LENGTH_SHORT).show();
            btn_resta.setVisibility(View.GONE);
        } else {
            Toast.makeText(this, "Has mostrado el botón de resta", Toast.LENGTH_SHORT).show();
            btn_resta.setVisibility(View.VISIBLE);
        }
    }
}
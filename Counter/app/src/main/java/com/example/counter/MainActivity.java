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

    protected boolean isNegative;
    EditText et_num_cont, et_num;
    Button btn_suma, btn_resta, btn_reset;
    ToggleButton tb_act_desact;
    CheckBox cb_cont_neg;
    int num = 0;

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
        isNegative = num <= 0;
        if(btn_resta.isClickable()) {
            num = Integer.parseInt(et_num.getText().toString());
            num--;
            et_num_cont.setText("" + num);
        } else if (isNegative) {
            Toast.makeText(this, "Introduce un número positivo", Toast.LENGTH_SHORT).show();
        }
    }

    public void suma(View v) {
        isNegative = num <= 0;
        if(btn_suma.isClickable()) {
            num = Integer.parseInt(et_num.getText().toString());
            num++;
            et_num_cont.setText("" + num);
        } else if (isNegative) {
            Toast.makeText(this, "Introduce un número positivo", Toast.LENGTH_SHORT).show();
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
        int reset = 0;
        if (et_num.getText().toString().isEmpty()) {
            Toast.makeText(this, "Introduce un número", Toast.LENGTH_SHORT).show();
        } else {
            et_num.setText("" + reset);
        }
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
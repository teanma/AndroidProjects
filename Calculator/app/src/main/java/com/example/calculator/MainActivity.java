package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    int num1, num2;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        tvResultado = (TextView) findViewById(R.id.tvResultado);

        if (etNum1.equals("") || etNum2.equals("")) {
            tvResultado.setText("Introduce los números");
        }
    }

    public void suma(View v) {

        if (etNum1.getText().toString().isEmpty() || etNum2.getText().toString().isEmpty()) {
            tvResultado.setText("Introduce los números");
        } else {
            num1 = Integer.parseInt(etNum1.getText().toString());
            num2 = Integer.parseInt(etNum2.getText().toString());

            int sum = num1 + num2;
            tvResultado.setText(Integer.toString(sum));
        }
    }

    public void resta(View v) {
        if (etNum1.getText().toString().isEmpty() || etNum2.getText().toString().isEmpty()) {
            tvResultado.setText("Introduce los números");
        } else {
            num1 = Integer.parseInt(etNum1.getText().toString());
            num2 = Integer.parseInt(etNum2.getText().toString());

            int res = num1 - num2;
            tvResultado.setText(Integer.toString(res));
        }
    }

    public void multiplicacion(View v) {
        if (etNum1.getText().toString().isEmpty() || etNum2.getText().toString().isEmpty()) {
            tvResultado.setText("Introduce los números");
        } else {
            num1 = Integer.parseInt(etNum1.getText().toString());
            num2 = Integer.parseInt(etNum2.getText().toString());

            int mult = num1 * num2;
            tvResultado.setText(Integer.toString(mult));
        }
    }

    public void division(View v) {
        if (etNum1.getText().toString().isEmpty() || etNum2.getText().toString().isEmpty()) {
            tvResultado.setText("Introduce los números");
        } else {
            num1 = Integer.parseInt(etNum1.getText().toString());
            num2 = Integer.parseInt(etNum2.getText().toString());

            int div = num1 / num2;
            tvResultado.setText(Integer.toString(div));
        }
    }

    public void resetear(View v) {
        etNum1.setText("");
        etNum2.setText("");
        tvResultado.setText("");
    }
}
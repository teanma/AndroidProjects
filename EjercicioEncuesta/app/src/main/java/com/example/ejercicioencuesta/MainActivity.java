package com.example.ejercicioencuesta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_votos_windows, tv_votos_linux, tv_votos_ios, tv_votos_android;
    RadioButton rb_windows, rb_linux, rb_ios, rb_android;
    ImageButton img_btn_cargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_votos_windows = (TextView) findViewById(R.id.tv_votos_windows);
        tv_votos_linux = (TextView) findViewById(R.id.tv_votos_linux);
        tv_votos_ios = (TextView) findViewById(R.id.tv_votos_ios);
        tv_votos_android = (TextView) findViewById(R.id.tv_votos_android);

        rb_windows = (RadioButton) findViewById(R.id.rb_windows);
        rb_linux = (RadioButton) findViewById(R.id.rb_linux);
        rb_ios = (RadioButton) findViewById(R.id.rb_ios);
        rb_android = (RadioButton) findViewById(R.id.rb_android);

        img_btn_cargar = (ImageButton) findViewById(R.id.img_btn_cargar);
    }

    public void cargarVoto(View v) {
        RadioGroup rg_sistemas_operativos = (RadioGroup) findViewById(R.id.rg_sistemas_operativos);
        switch (rg_sistemas_operativos.getCheckedRadioButtonId()) {
            case R.id.rb_windows:
                Toast.makeText(this, "Has votado Windows", Toast.LENGTH_SHORT).show();
                int votoWindows = 0;
                while (img_btn_cargar.isClickable()) {
                    votoWindows++;
                    tv_votos_windows.setText(votoWindows + " votos");
                }
                break;
            case R.id.rb_linux:
                Toast.makeText(this, "Has votado Linux", Toast.LENGTH_SHORT).show();
                int votoLinux = 0;
                while (img_btn_cargar.isClickable()) {
                    votoLinux++;
                    tv_votos_linux.setText(votoLinux + " votos");
                }
                break;
            case R.id.rb_ios:
                Toast.makeText(this, "Has votado iOs", Toast.LENGTH_SHORT).show();
                int votoIos = 0;
                while (img_btn_cargar.isClickable()) {
                    votoIos++;
                    tv_votos_ios.setText(votoIos + " votos");
                }
                break;
            case R.id.rb_android:
                Toast.makeText(this, "Has votado Android", Toast.LENGTH_SHORT).show();
                int votoAndroid = 0;
                while (img_btn_cargar.isClickable()) {
                    votoAndroid++;
                    tv_votos_android.setText(votoAndroid + " votos");
                }
                break;
        }
    }
}
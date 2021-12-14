package com.example.framelayoutexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv_dell = (ImageView) findViewById(R.id.iv_dell);
        ImageView iv_hp = (ImageView) findViewById(R.id.iv_hp);

        EditText et_top_right = (EditText) findViewById(R.id.et_top_right);
        EditText et_left_center = (EditText) findViewById(R.id.et_left_center);
        EditText et_right_bottom = (EditText) findViewById(R.id.et_right_bottom);

        FrameLayout.LayoutParams dell_params = (FrameLayout.LayoutParams) iv_dell.getLayoutParams();
        FrameLayout.LayoutParams hp_params = (FrameLayout.LayoutParams) iv_hp.getLayoutParams();

        FrameLayout.LayoutParams top_right_params = (FrameLayout.LayoutParams) et_top_right.getLayoutParams();
        FrameLayout.LayoutParams left_center_params = (FrameLayout.LayoutParams) et_left_center.getLayoutParams();
        FrameLayout.LayoutParams right_bottom_params = (FrameLayout.LayoutParams) et_right_bottom.getLayoutParams();

        dell_params.gravity = Gravity.LEFT | Gravity.TOP;
        iv_dell.setLayoutParams(dell_params);
        hp_params.gravity = Gravity.BOTTOM | Gravity.LEFT;
        iv_hp.setLayoutParams(hp_params);

        top_right_params.gravity = Gravity.RIGHT | Gravity.TOP;
        et_top_right.setLayoutParams(top_right_params);
        left_center_params.gravity = Gravity.CENTER | Gravity.LEFT;
        et_left_center.setLayoutParams(left_center_params);
        right_bottom_params.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        et_right_bottom.setLayoutParams(right_bottom_params);

    }
}
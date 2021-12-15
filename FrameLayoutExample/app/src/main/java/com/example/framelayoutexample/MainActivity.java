package com.example.framelayoutexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv_dell, iv_hp;
    EditText et_top_right, et_left_center, et_right_bottom;
    Button btn_move_widgets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {

        iv_dell = (ImageView) findViewById(R.id.iv_dell);
        iv_hp = (ImageView) findViewById(R.id.iv_hp);

        et_top_right = (EditText) findViewById(R.id.et_top_right);
        et_left_center = (EditText) findViewById(R.id.et_left_center);
        et_right_bottom = (EditText) findViewById(R.id.et_right_bottom);

        btn_move_widgets = (Button) findViewById(R.id.btn_move_widgets);
    }

    public void moveWidgets(View v) {

        FrameLayout.LayoutParams dell_params = (FrameLayout.LayoutParams) iv_dell.getLayoutParams();
        FrameLayout.LayoutParams hp_params = (FrameLayout.LayoutParams) iv_hp.getLayoutParams();

        FrameLayout.LayoutParams top_right_params = (FrameLayout.LayoutParams) et_top_right.getLayoutParams();
        FrameLayout.LayoutParams left_center_params = (FrameLayout.LayoutParams) et_left_center.getLayoutParams();
        FrameLayout.LayoutParams right_bottom_params = (FrameLayout.LayoutParams) et_right_bottom.getLayoutParams();

        dell_params.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        iv_dell.setLayoutParams(dell_params);
        hp_params.gravity = Gravity.RIGHT | Gravity.TOP;
        iv_hp.setLayoutParams(hp_params);

        top_right_params.gravity = Gravity.LEFT | Gravity.TOP;
        et_top_right.setLayoutParams(top_right_params);
        left_center_params.gravity = Gravity.CENTER | Gravity.RIGHT;
        et_left_center.setLayoutParams(left_center_params);
        right_bottom_params.gravity = Gravity.BOTTOM | Gravity.LEFT;
        et_right_bottom.setLayoutParams(right_bottom_params);
    }
}
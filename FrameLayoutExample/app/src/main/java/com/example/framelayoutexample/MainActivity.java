package com.example.framelayoutexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv_dell, iv_hp;
    EditText et_top_right, et_left_center, et_right_bottom;
    CheckBox cb_move_widgets;

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

        cb_move_widgets = (CheckBox) findViewById(R.id.cb_move_widgets);
    }

    public void moveWidgets(View v) {

        FrameLayout.LayoutParams dell_params = (FrameLayout.LayoutParams) iv_dell.getLayoutParams();
        FrameLayout.LayoutParams hp_params = (FrameLayout.LayoutParams) iv_hp.getLayoutParams();

        FrameLayout.LayoutParams top_right_params = (FrameLayout.LayoutParams) et_top_right.getLayoutParams();
        FrameLayout.LayoutParams left_center_params = (FrameLayout.LayoutParams) et_left_center.getLayoutParams();
        FrameLayout.LayoutParams right_bottom_params = (FrameLayout.LayoutParams) et_right_bottom.getLayoutParams();
        FrameLayout.LayoutParams cb_move_widgets_params = (FrameLayout.LayoutParams) cb_move_widgets.getLayoutParams();

        if (cb_move_widgets.isChecked()) {
            dell_params.gravity = Gravity.BOTTOM | Gravity.RIGHT;
            iv_dell.setLayoutParams(dell_params);
            hp_params.gravity = Gravity.RIGHT | Gravity.TOP;
            iv_hp.setLayoutParams(hp_params);

            et_top_right.setText("Top left");
            et_left_center.setText("Right center");
            et_right_bottom.setText("Left bottom");

            top_right_params.gravity = Gravity.LEFT | Gravity.TOP;
            et_top_right.setLayoutParams(top_right_params);
            left_center_params.gravity = Gravity.CENTER | Gravity.RIGHT;
            et_left_center.setLayoutParams(left_center_params);
            right_bottom_params.gravity = Gravity.BOTTOM | Gravity.LEFT;
            et_right_bottom.setLayoutParams(right_bottom_params);
            cb_move_widgets_params.gravity = Gravity.CENTER | Gravity.LEFT;
            cb_move_widgets.setLayoutParams(cb_move_widgets_params);
        } else {
            dell_params.gravity = Gravity.LEFT | Gravity.TOP;
            iv_dell.setLayoutParams(dell_params);
            hp_params.gravity = Gravity.BOTTOM | Gravity.LEFT;
            iv_hp.setLayoutParams(hp_params);

            et_top_right.setText("Top right");
            et_left_center.setText("Left center");
            et_right_bottom.setText("Right bottom");

            top_right_params.gravity = Gravity.RIGHT | Gravity.TOP;
            et_top_right.setLayoutParams(top_right_params);
            left_center_params.gravity = Gravity.CENTER | Gravity.LEFT;
            et_left_center.setLayoutParams(left_center_params);
            right_bottom_params.gravity = Gravity.BOTTOM | Gravity.RIGHT;
            et_right_bottom.setLayoutParams(right_bottom_params);
            cb_move_widgets_params.gravity = Gravity.CENTER | Gravity.RIGHT;
            cb_move_widgets.setLayoutParams(cb_move_widgets_params);
        }
    }
}
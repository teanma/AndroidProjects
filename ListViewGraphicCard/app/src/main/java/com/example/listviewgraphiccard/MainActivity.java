package com.example.listviewgraphiccard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected final static String MAINACTIVITY_GRAPHIC_CARD = "com.example.listviewgraphiccard.graphic_card";

    TextView tv_select_item;
    ListView lv_graphic_cards;
    Button btn_load_info;
    String selectedItem;
    boolean isSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        ListView lv_graphic_cards = (ListView) findViewById(R.id.lv_graphic_cards);

        String[] gc = {"1030", "2060", "3060", "3090"};

        int[] values = {0, 0, 0, 0};

        ArrayAdapter aa_gc = new ArrayAdapter<String>(this, R.layout.list_view_graphic_card, R.id.tv_aux_gc, gc);

        lv_graphic_cards.setAdapter(aa_gc);

        lv_graphic_cards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                selectedItem = (String) parent.getItemAtPosition(i);
                Toast.makeText(parent.getContext(), "Graphic card selected: " + selectedItem, Toast.LENGTH_SHORT).show();
                if (selectedItem.equals("1030")) {
                    values[i] = values[i]++;
                } else if (selectedItem.equals("2060")) {
                    values[i] = values[i]++;
                } else if (selectedItem.equals("3060")) {
                    values[i] = values[i]++;
                } else {
                    values[i] = values[i]++;
                }
            }
        });
    }

    public void initialize() {
        tv_select_item = (TextView) findViewById(R.id.tv_select_item);
        lv_graphic_cards = (ListView) findViewById(R.id.lv_graphic_cards);
        btn_load_info = (Button) findViewById(R.id.btn_load_info);
    }

    public void loadInfo(View v) {
        String gc_1030 = "1030";
        String gc_2060 = "2060";
        String gc_3060 = "3060";
        String gc_3090 = "3090";

        //if(!isSelected) {
          //  Toast.makeText(this, "Select an item", Toast.LENGTH_SHORT).show();
        //} else {
            Intent secondaryScreen = new Intent(this, MainActivity2.class);
            if(selectedItem.equals(gc_1030)) {
                secondaryScreen.putExtra(MAINACTIVITY_GRAPHIC_CARD, gc_1030);
            } else if (selectedItem.equals(gc_2060)) {
                secondaryScreen.putExtra(MAINACTIVITY_GRAPHIC_CARD, gc_2060);
            } else if (selectedItem.equals(gc_3060)) {
                secondaryScreen.putExtra(MAINACTIVITY_GRAPHIC_CARD, gc_3060);
            } else {
                secondaryScreen.putExtra(MAINACTIVITY_GRAPHIC_CARD, gc_3090);
            }
            startActivity(secondaryScreen);
        //}
    }
}
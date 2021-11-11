package com.example.formulariodeportivo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Listener {

    TextView tv_name, tv_surname, tv_phone, tv_email, tv_football, tv_basketball, tv_position, tv_obligatory_field_name, tv_obligatory_field_surname, tv_obligatory_field_spinContact, tv_obligatory_field_phone, tv_obligatory_field_email, tv_obligatory_field_spinSport;
    EditText et_name, et_surname, et_phone, et_email;
    Spinner spinContact, spinSport;
    CheckBox cb_position1_football, cb_position2_football, cb_position3_football, cb_position4_football, cb_position1_basketball, cb_position2_basketball, cb_position3_basketball, cb_position4_basketball;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        tv_phone.setVisibility(View.GONE);
        tv_email.setVisibility(View.GONE);
        tv_football.setVisibility(View.GONE);
        tv_basketball.setVisibility(View.GONE);
        tv_position.setVisibility(View.GONE);
        tv_obligatory_field_phone.setVisibility(View.GONE);
        tv_obligatory_field_email.setVisibility(View.GONE);

        et_phone.setVisibility(View.GONE);
        et_email.setVisibility(View.GONE);

        cb_position1_football.setVisibility(View.GONE);
        cb_position2_football.setVisibility(View.GONE);
        cb_position3_football.setVisibility(View.GONE);
        cb_position4_football.setVisibility(View.GONE);
        cb_position1_basketball.setVisibility(View.GONE);
        cb_position2_basketball.setVisibility(View.GONE);
        cb_position3_basketball.setVisibility(View.GONE);
        cb_position4_basketball.setVisibility(View.GONE);

        contactsListener();

        sportsListener();
    }

    public void initialize() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_surname = (TextView) findViewById(R.id.tv_surname);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_football = (TextView) findViewById(R.id.tv_football);
        tv_basketball = (TextView) findViewById(R.id.tv_basketball);
        tv_position = (TextView) findViewById(R.id.tv_position);
        tv_obligatory_field_name = (TextView) findViewById(R.id.tv_obligatory_field_name);
        tv_obligatory_field_surname = (TextView) findViewById(R.id.tv_obligatory_field_surname);
        tv_obligatory_field_spinContact = (TextView) findViewById(R.id.tv_obligatory_field_spinContact);
        tv_obligatory_field_phone = (TextView) findViewById(R.id.tv_obligatory_field_phone);
        tv_obligatory_field_email = (TextView) findViewById(R.id.tv_obligatory_field_email);
        tv_obligatory_field_spinSport = (TextView) findViewById(R.id.tv_obligatory_field_spinSport);

        et_name = (EditText) findViewById(R.id.et_name);
        et_surname = (EditText) findViewById(R.id.et_surname);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_email = (EditText) findViewById(R.id.et_email);

        spinContact = (Spinner) findViewById(R.id.spinContact);
        spinSport = (Spinner) findViewById(R.id.spinSport);

        cb_position1_football = (CheckBox) findViewById(R.id.cb_position1_football);
        cb_position2_football = (CheckBox) findViewById(R.id.cb_position2_football);
        cb_position3_football = (CheckBox) findViewById(R.id.cb_position3_football);
        cb_position4_football = (CheckBox) findViewById(R.id.cb_position4_football);
        cb_position1_basketball = (CheckBox) findViewById(R.id.cb_position1_basketball);
        cb_position2_basketball = (CheckBox) findViewById(R.id.cb_position2_basketball);
        cb_position3_basketball = (CheckBox) findViewById(R.id.cb_position3_basketball);
        cb_position4_basketball = (CheckBox) findViewById(R.id.cb_position4_basketball);

        btn_send = (Button) findViewById(R.id.btn_send);
    }

    @Override
    public void contactsListener() {
        String[] contacts = {"Select contact", "Phone", "Email"};

        ArrayAdapter<String> adapterContacts = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, contacts);

        spinContact.setAdapter(adapterContacts);

        spinContact.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getSelectedItem().toString();
                String selectedByPosition = parent.getItemAtPosition(position).toString();
                String res = "Selected: " + selected + " SelectedByPosition " + selectedByPosition + " position " + position;
                Toast.makeText(parent.getContext(), res, Toast.LENGTH_SHORT).show();
                if (selected.equals("Phone")) {
                    tv_email.setVisibility(View.GONE);
                    et_email.setVisibility(View.GONE);
                    tv_obligatory_field_email.setVisibility(View.GONE);
                    tv_phone.setVisibility(View.VISIBLE);
                    et_phone.setVisibility(View.VISIBLE);
                    tv_obligatory_field_phone.setVisibility(View.VISIBLE);
                } else if (selected.equals("Email")) {
                    tv_email.setVisibility(View.VISIBLE);
                    et_email.setVisibility(View.VISIBLE);
                    tv_obligatory_field_email.setVisibility(View.VISIBLE);
                    tv_phone.setVisibility(View.GONE);
                    et_phone.setVisibility(View.GONE);
                    tv_obligatory_field_phone.setVisibility(View.GONE);
                } else {
                    tv_email.setVisibility(View.GONE);
                    et_email.setVisibility(View.GONE);
                    tv_obligatory_field_email.setVisibility(View.GONE);
                    tv_phone.setVisibility(View.GONE);
                    et_phone.setVisibility(View.GONE);
                    tv_obligatory_field_phone.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void sportsListener() {
        String[] sports = {"Select sport", "Football", "Basketball"};

        ArrayAdapter<String> adapterSports = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sports);

        spinSport.setAdapter(adapterSports);

        spinSport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getSelectedItem().toString();
                String selectedByPosition = parent.getItemAtPosition(position).toString();
                String res = "Selected: " + selected + " SelectedByPosition " + selectedByPosition + " position " + position;
                Toast.makeText(parent.getContext(), res, Toast.LENGTH_SHORT).show();
                if (selected.equals("Football")) {
                    tv_basketball.setVisibility(View.GONE);
                    cb_position1_basketball.setVisibility(View.GONE);
                    cb_position2_basketball.setVisibility(View.GONE);
                    cb_position3_basketball.setVisibility(View.GONE);
                    cb_position4_basketball.setVisibility(View.GONE);
                    tv_position.setVisibility(View.VISIBLE);
                    tv_football.setVisibility(View.VISIBLE);
                    cb_position1_football.setVisibility(View.VISIBLE);
                    cb_position2_football.setVisibility(View.VISIBLE);
                    cb_position3_football.setVisibility(View.VISIBLE);
                    cb_position4_football.setVisibility(View.VISIBLE);
                } else if (selected.equals("Basketball")) {
                    tv_basketball.setVisibility(View.VISIBLE);
                    cb_position1_basketball.setVisibility(View.VISIBLE);
                    cb_position2_basketball.setVisibility(View.VISIBLE);
                    cb_position3_basketball.setVisibility(View.VISIBLE);
                    cb_position4_basketball.setVisibility(View.VISIBLE);
                    tv_position.setVisibility(View.VISIBLE);
                    tv_football.setVisibility(View.GONE);
                    cb_position1_football.setVisibility(View.GONE);
                    cb_position2_football.setVisibility(View.GONE);
                    cb_position3_football.setVisibility(View.GONE);
                    cb_position4_football.setVisibility(View.GONE);
                } else {
                    tv_basketball.setVisibility(View.GONE);
                    cb_position1_basketball.setVisibility(View.GONE);
                    cb_position2_basketball.setVisibility(View.GONE);
                    cb_position3_basketball.setVisibility(View.GONE);
                    cb_position4_basketball.setVisibility(View.GONE);
                    tv_position.setVisibility(View.GONE);
                    tv_football.setVisibility(View.GONE);
                    cb_position1_football.setVisibility(View.GONE);
                    cb_position2_football.setVisibility(View.GONE);
                    cb_position3_football.setVisibility(View.GONE);
                    cb_position4_football.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
package com.example.formulariodeportivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Listener {

    protected static final String MAINACTIVITY_NAME = "com.example.formulariodeportivo.name";
    protected static final String MAINACTIVITY_SURNAME = "com.example.formulariodeportivo.surname";
    protected static final String MAINACTIVITY_SELECTED_CONTACT = "com.example.formulariodeportivo.selected_contact";
    protected static final String MAINACTIVITY_CONTACT = "com.example.formulariodeportivo.contact";
    protected static final String MAINACTIVITY_SPORT = "com.example.formulariodeportivo.sport";
    protected static final String MAINACTIVITY_POSITION = "com.example.formulariodeportivo.position";


    TextView tv_name, tv_surname, tv_phone, tv_email, tv_football, tv_basketball, tv_position, tv_obligatory_field_name, tv_obligatory_field_surname, tv_obligatory_field_spinContact, tv_obligatory_field_phone, tv_obligatory_field_email, tv_obligatory_field_spinSport;
    EditText et_name, et_surname, et_phone, et_email;
    Spinner spinContact, spinSport;
    RadioGroup rg_football, rg_basketball;
    RadioButton rb_portero, rb_medio, rb_defensa, rb_delantero, rb_base, rb_escolta, rb_alero, rb_pivot;
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

        rg_football.setVisibility(View.GONE);
        rg_basketball.setVisibility(View.GONE);

        //rb_portero.setVisibility(View.GONE);
        //rb_medio.setVisibility(View.GONE);
        //rb_defensa.setVisibility(View.GONE);
        //rb_delantero.setVisibility(View.GONE);
        //rb_base.setVisibility(View.GONE);
        //rb_escolta.setVisibility(View.GONE);
        //rb_alero.setVisibility(View.GONE);
        //rb_pivot.setVisibility(View.GONE);

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

        rg_football = (RadioGroup) findViewById(R.id.rg_football);
        rg_basketball = (RadioGroup) findViewById(R.id.rg_basketball);

        rb_portero = (RadioButton) findViewById(R.id.rb_portero);
        rb_medio = (RadioButton) findViewById(R.id.rb_medio);
        rb_defensa = (RadioButton) findViewById(R.id.rb_defensa);
        rb_delantero = (RadioButton) findViewById(R.id.rb_delantero);
        rb_base = (RadioButton) findViewById(R.id.rb_base);
        rb_escolta = (RadioButton) findViewById(R.id.rb_escolta);
        rb_alero = (RadioButton) findViewById(R.id.rb_alero);
        rb_pivot = (RadioButton) findViewById(R.id.rb_pivot);

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
                    rg_basketball.setVisibility(View.GONE);
                    tv_position.setVisibility(View.VISIBLE);
                    tv_football.setVisibility(View.VISIBLE);
                    rg_football.setVisibility(View.VISIBLE);
                } else if (selected.equals("Basketball")) {
                    tv_basketball.setVisibility(View.VISIBLE);
                    rg_basketball.setVisibility(View.VISIBLE);
                    tv_position.setVisibility(View.VISIBLE);
                    tv_football.setVisibility(View.GONE);
                    rg_football.setVisibility(View.GONE);
                } else {
                    tv_basketball.setVisibility(View.GONE);
                    rg_basketball.setVisibility(View.GONE);
                    tv_position.setVisibility(View.GONE);
                    tv_football.setVisibility(View.GONE);
                    rg_football.setVisibility(View.GONE);
                    rg_football.clearCheck();
                    rg_basketball.clearCheck();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void sendData(View v) {

        String name = et_name.getText().toString();
        String surname = et_surname.getText().toString();
        String phone = et_phone.getText().toString();
        String email = et_email.getText().toString();
        String phone_contact = "Móvil:";
        String email_contact = "Email:";
        String football = "Fútbol:";
        String basketball = "Baloncesto:";
        String portero = "Portero";
        String medio = "Medio";
        String defensa = "Defensa";
        String delantero = "Delantero";
        String base = "Base";
        String escolta = "Escolta";
        String alero = "Alero";
        String pivot = "Pivot";

        if (name.isEmpty() || surname.isEmpty() || phone.isEmpty() && email.isEmpty() || !rb_portero.isChecked() && !rb_medio.isChecked() && !rb_defensa.isChecked() && !rb_delantero.isChecked() && !rb_base.isChecked() && !rb_escolta.isChecked() && !rb_alero.isChecked() && !rb_pivot.isChecked()) {
            Toast.makeText(this, "Rellene los campos", Toast.LENGTH_SHORT).show();
        } else {
            Intent pantallaSecundaria = new Intent(this, MainActivity2.class);
            if (!et_phone.getText().toString().isEmpty()) {
                pantallaSecundaria.putExtra(MAINACTIVITY_SELECTED_CONTACT, phone_contact);
                pantallaSecundaria.putExtra(MAINACTIVITY_CONTACT, phone);
            }
            if (!et_email.getText().toString().isEmpty()) {
                pantallaSecundaria.putExtra(MAINACTIVITY_SELECTED_CONTACT, email_contact);
                pantallaSecundaria.putExtra(MAINACTIVITY_CONTACT, email);
            }
            if (rb_portero.isChecked()) {
                pantallaSecundaria.putExtra(MAINACTIVITY_SPORT, football);
                pantallaSecundaria.putExtra(MAINACTIVITY_POSITION, portero);
            }
            if (rb_medio.isChecked()) {
                pantallaSecundaria.putExtra(MAINACTIVITY_SPORT, football);
                pantallaSecundaria.putExtra(MAINACTIVITY_POSITION, medio);
            }
            if (rb_defensa.isChecked()) {
                pantallaSecundaria.putExtra(MAINACTIVITY_SPORT, football);
                pantallaSecundaria.putExtra(MAINACTIVITY_POSITION, defensa);
            }
            if (rb_delantero.isChecked()) {
                pantallaSecundaria.putExtra(MAINACTIVITY_SPORT, football);
                pantallaSecundaria.putExtra(MAINACTIVITY_POSITION, delantero);
            }
            if (rb_base.isChecked()) {
                pantallaSecundaria.putExtra(MAINACTIVITY_SPORT, basketball);
                pantallaSecundaria.putExtra(MAINACTIVITY_POSITION, base);
            }
            if (rb_escolta.isChecked()) {
                pantallaSecundaria.putExtra(MAINACTIVITY_SPORT, basketball);
                pantallaSecundaria.putExtra(MAINACTIVITY_POSITION, escolta);
            }
            if (rb_alero.isChecked()) {
                pantallaSecundaria.putExtra(MAINACTIVITY_SPORT, basketball);
                pantallaSecundaria.putExtra(MAINACTIVITY_POSITION, alero);
            }
            if (rb_pivot.isChecked()) {
                pantallaSecundaria.putExtra(MAINACTIVITY_SPORT, basketball);
                pantallaSecundaria.putExtra(MAINACTIVITY_POSITION, pivot);
            }
            pantallaSecundaria.putExtra(MAINACTIVITY_NAME, name);
            pantallaSecundaria.putExtra(MAINACTIVITY_SURNAME, surname);
            startActivity(pantallaSecundaria);
        }

    }
}
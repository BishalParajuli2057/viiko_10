package com.example.viiko_10;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AddUserActivity extends AppCompatActivity {
    private EditText textFirstName;
    private EditText textLastName;
    private EditText textEmail;
    private RadioGroup radioDegreeProgram;
    private RadioButton seRadioButton, imRadioButton, ceRadioButton, eeRadioButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textFirstName = findViewById(R.id.textFirstName);
        textLastName = findViewById(R.id.textLastName);
        textEmail = findViewById(R.id.textEmail);
        radioDegreeProgram = findViewById(R.id.textDegreeProgram);
        seRadioButton = findViewById(R.id.seRadioButton);
        imRadioButton = findViewById(R.id.imRadioButton);
        ceRadioButton = findViewById(R.id.ceRadioButton);
        eeRadioButton = findViewById(R.id.eeRadioButton);
    }

    public void addUserClicked(View view) {
        String firstName = textFirstName.getText().toString();
        String lastName = textLastName.getText().toString();
        String email = textEmail.getText().toString();
        int selectedId = radioDegreeProgram.getCheckedRadioButtonId();
        String degreeProgram = null;
        if(selectedId == R.id.seRadioButton) {
            degreeProgram = "Software Engineering";
        } else if(selectedId == R.id.imRadioButton) {
            degreeProgram = "Information Management";
        } else if(selectedId == R.id.ceRadioButton) {
            degreeProgram = "Computer Engineering";
        } else if(selectedId == R.id.eeRadioButton) {
            degreeProgram = "Electrical Engineering";
        } else {
        }
        List<String> degrees = new ArrayList<>();
        if (((CheckBox) findViewById(R.id.bcCheckBox)).isChecked()) degrees.add("B.Sc. degree");
        if (((CheckBox) findViewById(R.id.msCheckBox)).isChecked()) degrees.add("M.Sc. degree");
        if (((CheckBox) findViewById(R.id.IciCheckBox)).isChecked()) degrees.add("L.ic. degree");
        if (((CheckBox) findViewById(R.id.phdCheckBox)).isChecked()) degrees.add("Ph.D. degree");
        User newUser = new User(firstName, lastName, email, degreeProgram, degrees);
        UserStorage.getInstance().addUser(newUser);
        Toast.makeText(this, "User added successfully", Toast.LENGTH_SHORT).show();
    }
}

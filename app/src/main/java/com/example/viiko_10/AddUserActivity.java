package com.example.viiko_10;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class AddUserActivity extends AppCompatActivity {
    private EditText textFirstName;
    private EditText textLastName;
    private EditText textEmail;
    private RadioButton seRadioButton, imRadioButton, ceRadioButton, eeRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textFirstName = findViewById(R.id.textFirstName);
        textLastName = findViewById(R.id.textLastName);
        textEmail = findViewById(R.id.textEmail);
        seRadioButton = findViewById(R.id.seRadioButton);
        imRadioButton = findViewById(R.id.imRadioButton);
        ceRadioButton = findViewById(R.id.ceRadioButton);
        eeRadioButton = findViewById(R.id.eeRadioButton);
    }

    public void onAddUserClicked(View view) {
        String firstName = textFirstName.getText().toString();
        String lastName = textLastName.getText().toString();
        String email = textEmail.getText().toString();
        String degreeProgram = "";
        if (seRadioButton.isChecked()) degreeProgram = "Software Engineering";
        if (imRadioButton.isChecked()) degreeProgram = "Industrial Management";
        if (ceRadioButton.isChecked()) degreeProgram = "Computational Engineering";
        if (eeRadioButton.isChecked()) degreeProgram = "Electrical Engineering";

        User newUser = new User(firstName, lastName, email, degreeProgram);
        UserStorage.getInstance(getApplicationContext()).addUser(newUser);

        finish();
    }
}

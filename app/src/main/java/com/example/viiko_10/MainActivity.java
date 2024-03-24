package com.example.viiko_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToAddUser(View view) {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }

    public void goToListUsers(View view) {
        Intent intent = new Intent(this, ListUserActivity.class);
        startActivity(intent);
    }
}

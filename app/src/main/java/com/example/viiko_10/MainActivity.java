package com.example.viiko_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            findViewById(R.id.addUserButton).setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivity(intent);
            });

        }
    }

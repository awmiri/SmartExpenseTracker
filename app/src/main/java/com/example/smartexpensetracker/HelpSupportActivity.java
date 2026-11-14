
package com.example.smartexpensetracker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class HelpSupportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_help_support);
        PersonalHeaderView personalHeader = findViewById(R.id.personalHeader);
        // Back Button
        personalHeader.setOnBackClickListener(v -> {
            finish();
        });

    }
}


package com.example.smartexpensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        LinearLayout PersonalInformation = findViewById(R.id.rowPersonalInformation);

        PersonalInformation.setOnClickListener(v -> {
            Intent intent = new Intent(
                    ProfileActivity.this ,
                    PersonalInformationActivity.class
            );

            startActivity(intent);

        });

        LinearLayout AboutAppInformation = findViewById(R.id.rowAboutApp);

        AboutAppInformation.setOnClickListener(v ->{
            Intent intent = new Intent(
                    ProfileActivity.this,
                    AboutActivity.class
            );

            startActivity(intent);

        });

        LinearLayout HelpAndSupportBtn = findViewById(R.id.rowHelpAndSupport);

        HelpAndSupportBtn.setOnClickListener(v -> {
            Intent intent = new Intent(
                    ProfileActivity.this,
                    HelpSupportActivity.class
            );

            startActivity(intent);
        });


        new BottomNavigation(this, 4);


    }
}

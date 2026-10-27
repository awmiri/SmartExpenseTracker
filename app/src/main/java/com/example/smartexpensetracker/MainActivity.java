
package com.example.smartexpensetracker;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // نمایش تاریخ فعلی
        TextView textMonth = findViewById(R.id.textMonth);
        TextView textDay = findViewById(R.id.textDay);
        TextView textCharDat = findViewById(R.id.characterText);

        Date today = new Date();

        SimpleDateFormat monthFormat =
                new SimpleDateFormat("MMM", Locale.ENGLISH);

        SimpleDateFormat dayFormat =
                new SimpleDateFormat("d", Locale.ENGLISH);

        SimpleDateFormat dayCharFormat =
                new SimpleDateFormat("EEEE", Locale.ENGLISH);

        textMonth.setText(
                monthFormat.format(today).toUpperCase(Locale.ENGLISH)
        );

        textDay.setText(dayFormat.format(today));

        textCharDat.setText(
                dayCharFormat.format(today).toUpperCase(Locale.ENGLISH)
        );

        // راه‌اندازی نوار پایین مشترک؛ تب Home فعال است
        new BottomNavigation(this, 2);
    }
}

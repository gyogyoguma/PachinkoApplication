package com.example.pachinkoapplication;

import android.os.Bundle;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // CalendarViewに現在日時を設定します。
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);

    }
}
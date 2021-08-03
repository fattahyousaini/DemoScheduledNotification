package com.myapplicationdev.android.demoschedulednotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int reqCode = 12345;
    Button btnSchedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSchedule = findViewById(R.id.btnSchedule);

        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 5);

                Intent i = new Intent(MainActivity.this, ScheduledNotificationReceiver.class);
                int reqCode = 12345;
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,reqCode,
                        i, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);

            }
        });
    }
}
package com.example.alarmtest;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends Activity {

    Button setTime;
    Calendar cuurentTime = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTime = (Button) findViewById(R.id.setTime);
        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar currentTime = Calendar.getInstance();
                new TimePickerDialog(MainActivity.this,0,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i2) {
                        Intent intent = new Intent(MainActivity.this,AlarmActivity.class);
                        PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(System.currentTimeMillis());
                        calendar.set(Calendar.HOUR,i);
                        calendar.set(Calendar.MINUTE,i2);

                        AlarmManager aManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                        aManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pi);
                        Toast.makeText(MainActivity.this,"闹钟设置成功",Toast.LENGTH_SHORT).show();
                    }
                },currentTime.get(Calendar.HOUR),currentTime.get(Calendar.MINUTE),false).show();
            }
        });
    }

}

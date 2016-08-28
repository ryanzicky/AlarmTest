package com.example.alarmtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/8/28 0028.
 */
public class AlarmActivity extends Activity{
    MediaPlayer alarmMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alarmMusic = MediaPlayer.create(this,R.raw.alarm);
        alarmMusic.setLooping(true);

        alarmMusic.start();
        new AlertDialog.Builder(AlarmActivity.this).setTitle("闹钟").setMessage("闹钟响了!").setPositiveButton("确定",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alarmMusic.stop();
                AlarmActivity.this.finish();
            }
        }).show();
    }
}

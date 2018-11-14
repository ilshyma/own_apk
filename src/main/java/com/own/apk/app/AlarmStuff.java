package com.own.apk.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * Created by asti on 06.05.2017.
 */

public class AlarmStuff {
    // 3600 * 1000 * 3 = 10800000 мс в 3х часах
    public static int DELAY_ADV = 10800000;

        public AlarmStuff() {
        }


        public void setRepeatingAlarm(Context context, long milliSecs) {
            AlarmManager am = (AlarmManager) context
                    .getSystemService(Context.ALARM_SERVICE);
            Intent i = new Intent(context, AlarmRec.class);
            PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
            am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+milliSecs,
                    milliSecs, pi);
        }

        public void setOnetimeTimer(Context context, long milliSecs) {
            AlarmManager am = (AlarmManager) context
                    .getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(context, AlarmRec.class);
            PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
            am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + milliSecs,
                    pi);

        }

        public void cancelAlarm(Context context) {
            Intent intent = new Intent(context, AlarmRec.class);
            PendingIntent sender = PendingIntent
                    .getBroadcast(context, 0, intent, 0);
            AlarmManager alarmManager = (AlarmManager) context
                    .getSystemService(Context.ALARM_SERVICE);

            alarmManager.cancel(sender);
        }
}
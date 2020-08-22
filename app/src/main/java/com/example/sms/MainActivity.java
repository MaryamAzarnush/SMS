package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.IntentFilter;
import android.drm.DrmStore;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{
        Manifest.permission.RECEIVE_SMS,Manifest.permission.BROADCAST_SMS,
                Manifest.permission.READ_SMS }, 1);

       MySmsReceiver mySmsReceiver = new MySmsReceiver();
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(mySmsReceiver, intentFilter);
    }
}
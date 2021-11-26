package com.example.grocerystore_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OTP_L extends AppCompatActivity implements SMSListener {
    private OTPReceiver broadcastReceiver;
    public static final String OTP_REGEX = "[0-9]{1,6}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_l);
        OTPReceiver.bindListener(this);

        broadcastReceiver = new OTPReceiver();


    }

    @Override
    public void messageReceived(String messageText, String senderno) {

        Log.e("MainActivity","Message Received : " + messageText + "  from : "+senderno);
        Toast.makeText(getApplicationContext(),"Message: "+
                messageText + " From : " + senderno, Toast.LENGTH_LONG).show();
        Pattern pattern = Pattern.compile(OTP_REGEX);
        Matcher matcher = pattern.matcher(messageText);
        String otp = "XXXXX";
        while (matcher.find())
        {
            otp = matcher.group();
        }
        Toast.makeText(getApplicationContext(),"OTP Received is: "+ otp ,Toast.LENGTH_LONG).show();
        TextView t = findViewById(R.id.editText_otp);
        t.setText(otp);
        int i=0;
        while(i<=55555){
            i++;
        }
        Intent nxt=new Intent(getApplicationContext(),Fruits.class);
        startActivity(nxt);



    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter
                ("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(broadcastReceiver,intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);

    }
}


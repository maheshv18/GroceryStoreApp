package com.example.grocerystore_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;

import androidx.annotation.RequiresApi;

public class OTPReceiver extends BroadcastReceiver {
    private static SMSListener mListener;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Bundle bundle  = intent.getExtras();

        SmsMessage smsMessage;

        if (Build.VERSION.SDK_INT >= 19) { //KITKAT
            SmsMessage[] msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            smsMessage = msgs[0];
        } else {
            Object pdus[] = (Object[]) bundle.get("pdus");
            String format = bundle.getString("format");
            //smsMessage = SmsMessage.createFromPdu((byte[]) pdus[0]);
            smsMessage = SmsMessage.createFromPdu((byte[]) pdus[0],format);
        }
        String messageBody = smsMessage.getMessageBody();
        String senderNo = smsMessage.getDisplayOriginatingAddress();

        //Pass the message text to interface
        mListener.messageReceived(messageBody,senderNo);

    }

    public static void bindListener(SMSListener listener) {
        mListener = listener;
    }

}


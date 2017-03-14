package com.example.luis.myapplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Luis on 19/02/2017.
 */
public class RecibirSMS extends BroadcastReceiver  {
    public TextView textView4;

    @Override


    public void onReceive(Context context, Intent intent) {


        Bundle bundle = intent.getExtras();
        SmsMessage[] mensaje = null;
        String texto="";
        String sender="";
        String allowedSender = "4245224127";

        if (bundle != null){
            Object[]pdus = (Object[])bundle.get("pdus");
            mensaje = new SmsMessage[pdus.length];
            for (int i=0; i<mensaje.length; i++){
                mensaje[i]= SmsMessage.createFromPdu((byte[])pdus[i]);
                sender = mensaje[i].getOriginatingAddress();
                texto += sender + " " + mensaje[i].getMessageBody().toString();

            }
            if(sender.contains(allowedSender)) {
                MainActivity mainActivity = MainActivity.instance();
                mainActivity.onMsgReceive(texto);

                Toast.makeText(context,texto,Toast.LENGTH_LONG).show();

                Log.i("Luis",texto);
            }
        }
    }
}


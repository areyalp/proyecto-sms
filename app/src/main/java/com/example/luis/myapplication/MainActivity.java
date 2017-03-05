package com.example.luis.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {
    EditText texto1,texto2,texto3,texto4,texto5,texto6;

    String temperatura,humedad,hluz,co2,triego,tfer,mensaje,m;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            }

    public void EnviarSMS(View v) {

        texto1 = ((EditText) findViewById(R.id.campo_texto));
        texto2 = ((EditText) findViewById(R.id.humedadText));
        texto3 = ((EditText) findViewById(R.id.horaluztext));
        texto4 = ((EditText) findViewById(R.id.co2text));
        texto5 = ((EditText) findViewById(R.id.tiemporiegotext));
        texto6 = ((EditText) findViewById(R.id.tiempofertext));

        temperatura= "Temp= " + texto1.getText().toString() + " °C\n";
        humedad= "H= " + texto2.getText().toString() + " %\n";
        hluz= "H.L= " + texto3.getText().toString();
        co2= " CO2= " + texto4.getText().toString() + " %\n";
        triego= "T.R= " + texto5.getText().toString() + " m\n";
        tfer= "T.F= "+ texto6.getText().toString() + " m\n";
        mensaje= temperatura + humedad + hluz + co2 + triego + tfer;
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("04245224127", null, mensaje, null, null);

    }





}

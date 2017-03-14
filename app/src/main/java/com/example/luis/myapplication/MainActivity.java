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
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

public class MainActivity extends Activity {
    EditText texto1,texto2,texto3,texto4,texto5,texto6;

    TextView textMsgReceive;
    public static MainActivity inst;

    String temperatura,humedad,hluz,co2,triego,tfer,mensaje,m;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto1 = ((EditText) findViewById(R.id.campo_texto));
        texto2 = ((EditText) findViewById(R.id.humedadText));
        texto3 = ((EditText) findViewById(R.id.horaluztext));
        texto4 = ((EditText) findViewById(R.id.co2text));
        texto5 = ((EditText) findViewById(R.id.tiemporiegotext));
        texto6 = ((EditText) findViewById(R.id.tiempofertext));
        texto1.setText("25");
        texto2.setText("85");
        texto3.setText("3");
        texto4.setText("3000");
        texto5.setText("40");
        texto6.setText("10");
        textMsgReceive = (TextView)findViewById(R.id.textMsgReceive);
            }

    public static MainActivity instance() {
        return inst;
    }

    public void onMsgReceive(final String textSMS) {
        textMsgReceive.setText(textSMS);
    }

    public void EnviarSMS(View v) {
        if(!texto1.getText().equals("")) {
            temperatura= "Temp= " + texto1.getText().toString() + " °C\n";
        }
        if(!texto2.getText().equals("")) {
            humedad= "H= " + texto2.getText().toString() + " %\n";
        }
        if(!texto3.getText().equals("")) {
            hluz= "H.L= " + texto3.getText().toString();
        }
        if(!texto4.getText().equals("")) {
            co2= " CO2= " + texto4.getText().toString() + " %\n";
        }
        if(!texto5.getText().equals("")) {
            triego= "T.R= " + texto5.getText().toString() + " m\n";
        }
        if(!texto6.getText().equals("")) {
            tfer = "T.F= " + texto6.getText().toString() + " m\n";
        }
        mensaje= temperatura + humedad + hluz + co2 + triego + tfer;
        SmsManager smsManager = SmsManager.getDefault();
        String receiver = "04245224127";
        smsManager.sendTextMessage(receiver, null, mensaje, null, null);
        Toast.makeText(this, "Enviando mensaje a " + receiver, Toast.LENGTH_LONG).show();
    }





}

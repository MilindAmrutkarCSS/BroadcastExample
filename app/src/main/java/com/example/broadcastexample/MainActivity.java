package com.example.broadcastexample;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ExampleBroadcast exampleBroadcast = new ExampleBroadcast();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //We filter our request and register the receiver
        IntentFilter filter = new IntentFilter("com.example.EXAMPLE_ACTION");
        registerReceiver(exampleBroadcast, filter);

        /**
         * Create new Android studio project for sending broadcast messages,
         * so when that app sends a Broadcast message it is received by this
         * app as a toast message.
         * And when this app is in background then the app doesn't show toast
         * message
         */

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(exampleBroadcast);
    }
}

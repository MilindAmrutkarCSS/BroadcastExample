package com.example.broadcastexample;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /**
     * Here we declare our dynamic registration of Broadcast
     * receiver and we listen for broadcasts as long as our
     * app is in the foreground.
     * We register it in onStart()
     * and unregister it in onStop()
     */

    ExampleBroadcast exampleBroadcast = new ExampleBroadcast();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * If you want to keep the broadcast receiver active
         * even when the app is in the background, you can
         * register it in onCreate() and unregister it in
         * onDestroy(). This would keep the broadcast receiver
         * alive for the lifecycle of this activity.
         * If you want to keep it active as long as your whole
         * application is running then you have to register it in
         * the onCreate() of the application class.
         *
         */
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Triggered when the app goes into the foreground
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(exampleBroadcast, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Triggered when the app goes into the background
        unregisterReceiver(exampleBroadcast);
    }
}

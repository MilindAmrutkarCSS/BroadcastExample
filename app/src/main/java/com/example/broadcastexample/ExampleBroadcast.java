package com.example.broadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ExampleBroadcast extends BroadcastReceiver {

    /**
     *
     * Implicit Broadcasts means that whatever component sends
     * this broadcast, doesn't specify our broadcast receiver
     * directly by it's classname instead it just specifies an
     * action and we can decide to listen to this action
     * and react to it. Static means we register our broadcast
     * in the manifest file, and we can receive our broadcast
     * even if our app is not running.
     * There are lot of restrictions put by Android in static
     * implementation of Broadcast receiver.
     * In versions greater than Naugat and Oreo we cannot use
     * static registration of broadcasts like for eg.
     * android.net.conn.CONNECTIVITY_CHANGE doesn't work any more
     * in Oreo and all.
     *
     * The solution is to use the Dynamic implementation of
     * receivers.
     */

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
           boolean noConnectivity = intent.getBooleanExtra(
                   ConnectivityManager.EXTRA_NO_CONNECTIVITY,
                   false
           );
           if(noConnectivity) {
               Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
           } else {
               Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
           }
        }
    }
}

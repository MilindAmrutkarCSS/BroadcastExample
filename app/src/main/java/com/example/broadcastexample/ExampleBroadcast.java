package com.example.broadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ExampleBroadcast extends BroadcastReceiver {

    /**
     *  Instead of listening for System broadcasts we can
     *  send and receive our own broadcasts.
     *  These broadcasts can be explicit broadcasts(which
     *  means that we specify the component that we want to
     *  trigger directly for eg. We want to send the broadcast
     *  that only triggers our ExampleBroadcast receiver and no
     *  other broadcast receiver
     *
     *  Or we can send an implicit broadcast which is
     *  basically the same as the System broadcast
     */


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "EBR triggered", Toast.LENGTH_SHORT).show();
    }
}

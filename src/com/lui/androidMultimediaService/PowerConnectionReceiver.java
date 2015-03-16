package com.lui.androidMultimediaService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

public class PowerConnectionReceiver extends BroadcastReceiver {

    ScreenResize screen = new ScreenResize();
    Brightness brightness = new Brightness();

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isCharging = false;
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        if(status == 2) {
            isCharging = true;
            screen.setSize();
            brightness.shutdownScreen();

        }
        else {
            screen.resetSize();
            brightness.maxBrighness();
        }



    }
}
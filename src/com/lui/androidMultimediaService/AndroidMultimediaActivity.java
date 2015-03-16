package com.lui.androidMultimediaService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class AndroidMultimediaActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        startService(new Intent(AndroidMultimediaActivity.this, AndroidMultimediaService.class));
    }

}

package com.lui.androidMultimediaService;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class ScreenResize {


    private Runtime runtime;
    private Process proc;
    private OutputStreamWriter osw;


    public ScreenResize() {
        runtime = Runtime.getRuntime();
        try {
            proc = runtime.exec("su");
        } catch (IOException e) {
            e.printStackTrace();
        }
        osw = new OutputStreamWriter(proc.getOutputStream());
    }



    public void setSize() {
        try {
            osw.write("wm size 1280x720");
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetSize() {
        try {
            osw.write("wm size reset");
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

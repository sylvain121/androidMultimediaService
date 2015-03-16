package com.lui.androidMultimediaService;


import java.io.IOException;
import java.io.OutputStreamWriter;

public class Brightness {

    private String brightnessFile = "/sys/class/backlight/pwm-backlight/brightness";
    private int minBrightness = 0;
    private int maxBrightness = 140;

    private Runtime runtime;
    private Process proc;
    private OutputStreamWriter osw;


    public Brightness() {
        runtime = Runtime.getRuntime();
        try {
            proc = runtime.exec("su");
        } catch (IOException e) {
            e.printStackTrace();
        }
        osw = new OutputStreamWriter(proc.getOutputStream());
    }



    public void shutdownScreen() {

        try {
            osw.write("echo "+minBrightness+" > "+brightnessFile);
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void maxBrighness() {
        try {
            osw.write("echo "+maxBrightness+" > "+brightnessFile);
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

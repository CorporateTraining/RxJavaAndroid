package com.example.androidhandler;


import android.os.Handler;
import android.os.Looper;

public class MyThread extends Thread {
    private Looper myLooper;
    private Handler myHandler;

    public MyThread() {
        start();
    }

    @Override
    public void run() {
        Looper.prepare();
        myLooper = Looper.myLooper();
        myHandler = new MyHandler(myLooper);
        Looper.loop();

    }

    public Looper getLooper() {
        return myLooper;
    }

    public Handler getMyHandler() {
        return myHandler;
    }
}
package com.example.androidhandler;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.Map;

public class MyHandler extends Handler {
    public MyHandler(@NonNull Looper looper) {
        super(looper);
    }

    @Override
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        Map messageObject = (Map) message.obj;
        Toast.makeText( (Context)messageObject.get("context"), (String)messageObject.get("messageInfo"), Toast.LENGTH_SHORT).show();
    }
}

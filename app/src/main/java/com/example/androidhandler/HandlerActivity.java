package com.example.androidhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandlerActivity extends AppCompatActivity {
    private static final int MESSAGE_1 = 1;
    private static final int MESSAGE_2 = 2;
    private static final String MESSAGE_INFO_1 = "message_info_1";
    private static final String MESSAGE_INFO_2 = "message_info_2";
    private MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        Button message_one_button = findViewById(R.id.message_one);
        Button message_two_button = findViewById(R.id.message_two);
        myThread = new MyThread();

        buttonOnClick(message_one_button, MESSAGE_INFO_1, MESSAGE_1);
        buttonOnClick(message_two_button, MESSAGE_INFO_2, MESSAGE_2);
    }

    private void buttonOnClick(Button messageOneButton, final String messageInfo, final int messageWhat) {
        messageOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> mapMessage = new HashMap<>();
                mapMessage.put("context", getBaseContext());
                mapMessage.put("messageInfo", messageInfo);
                Message message = Message.obtain();
                message.what = messageWhat;
                message.obj = mapMessage;
                myThread.getMyHandler().sendMessage(message);
            }
        });
    }

}
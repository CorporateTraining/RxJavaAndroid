package com.example.androidhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SPActivity extends AppCompatActivity {
    private Button spSubmit;
    private EditText spContent;
    private SharedPreferences sharedPreferences;
    private static final String CONTENT = "CONTENT";
    private static final String DATA = "DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_p);
        spSubmit = findViewById(R.id.sp_submit);
        spContent = findViewById(R.id.sp_content);
        sharedPreferences = getApplicationContext().getSharedPreferences(DATA, MODE_PRIVATE);

        saveSharedPreferences();
        onClickSubmitButton();
    }

    private void saveSharedPreferences() {
        String content = sharedPreferences.getString(CONTENT, "");
        spContent.setText(content);
    }

    private void onClickSubmitButton() {
        spSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(CONTENT, spContent.getText().toString());
                edit.apply();
            }
        });
    }
}
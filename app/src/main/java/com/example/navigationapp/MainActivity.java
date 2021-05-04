package com.example.navigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendMessage(View view) {
        Intent intent = new Intent(this,ReceiverActivity.class);
        EditText editText = (EditText) findViewById(R.id.message);
        intent.putExtra("message",editText.getText().toString());
        startActivity(intent);
    }
}
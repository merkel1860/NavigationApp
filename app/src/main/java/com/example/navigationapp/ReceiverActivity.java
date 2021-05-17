package com.example.navigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiverActivity extends AppCompatActivity {
    private TextView displayTextView;
    private Button cancelButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        // binding UI widgets with activity controls
        bindingWidgetsToActivity();

        Intent intent= getIntent();
        displayTextView.setText(intent.getStringExtra("message"));




    }

  private void settingUpListener(){
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"Still staying",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedBack = new Intent();
                feedBack.putExtra("resultMessage","Good Bye");
                setResult(RESULT_OK,feedBack);
            }
        });
  }

    private void bindingWidgetsToActivity() {
        displayTextView = (TextView) findViewById(R.id.message);
        backButton = findViewById(R.id.back_button);
        cancelButton = findViewById(R.id.cancel_button);
    }
}
package com.example.navigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int queryCode = 11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendMessage(View view) {
        Intent intent = new Intent(this,ReceiverActivity.class);
        EditText editText = (EditText) findViewById(R.id.question);
        intent.putExtra("player",editText.getText().toString());
        startActivityForResult(intent,queryCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int score = Integer.parseInt(data.
                getStringExtra("child_result"));
        String banner = score > 0? "Great Job," : "Next Time";
        TextView scoreTextView = findViewById(R.id.score_text_view);
        scoreTextView.setText(score + " / 5");
        Toast.makeText(getApplicationContext(), banner, Toast.LENGTH_LONG).show();
//        System.out.println("resultCode (-1/OK) :"+resultCode);
//        System.out.println("Data () :"+data.getStringExtra("child_result"));

    }
}
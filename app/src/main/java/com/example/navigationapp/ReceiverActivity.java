package com.example.navigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiverActivity extends AppCompatActivity {
    private TextView questionTextView, playerTextView, couterTextView;
    private Button falselButton, trueButton;
    private int player_score;
    private int round;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        // binding UI widgets with activity controls
        bindingWidgetsToActivity();
        // retrieving parameters from parent activity
        Intent intent = getIntent();
        playerTextView.setText(intent.getStringExtra("player").toUpperCase());

        //Setting up button listener
        settingUpListener();
        // Setup quizz
        SetUPQuizzing();
//        questionTextView.setText("La capital de Germany est : Berlin?");
    }

    private void SetUPQuizzing() {
        // Setting up questions and player score
        quizzedSetUP();
        // initial player score
        resetPlayerRoundParameters();
        nextRound();
    }

    private void nextRound() {
        questionTextView.setText(
                DAO.getInstanceDAO().
                        getQuestionList().
                        get(round).getQuestion());
        round++;
    }

    private void quizzedSetUP() {
        DAO.getInstanceDAO().getQuestionList().add(
                new Question("La capital de Haiti est : Jacmel?", false)
        );
        DAO.getInstanceDAO().getQuestionList().add(
                new Question("La capital de Germany est : Berlin?", true)
        );
        DAO.getInstanceDAO().getQuestionList().add(
                new Question("Jacmel est au sud d'Haiti?", false)
        );
        DAO.getInstanceDAO().getQuestionList().add(
                new Question("ESIH signifit Ecole d'Infotronique d'Haiti?", false)
        );
        DAO.getInstanceDAO().getQuestionList().add(
                new Question("Etes vous beau/belle?", true)
        );
    }

    private void settingUpListener() {
        falselButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkResponse(v, false);
            }
        });
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkResponse(v, true);
            }
        });
    }

    private void checkResponse(View v, boolean playerResponse) {
        if (DAO.getInstanceDAO().getQuestionList().
                get(round-1).isResponse() == playerResponse) {
            player_score++;
            infoBubble("Correct Answer", Toast.LENGTH_LONG);
        } else {
            infoBubble("Wrong answer", Toast.LENGTH_LONG);
        }
        nextRound();
        if (round == DAO.getInstanceDAO().getQuestionList().size()) {
            infoBubble("End of journey", Toast.LENGTH_SHORT);
            resetButton();
            messagingActivityManager();
            resetPlayerRoundParameters();
        }

    }

    private void infoBubble(String s, int lengthLong) {
        Toast toast = Toast.makeText(getApplicationContext(),
                s, lengthLong);
        toast.show();
    }

    private void messagingActivityManager() {
        Intent feedBack = new Intent();
        feedBack.putExtra("child_result", String.valueOf(player_score));
        setResult(Activity.RESULT_OK, feedBack);
    }

    private void resetButton() {
        falselButton.setEnabled(false);
        trueButton.setEnabled(false);
    }

    private void resetPlayerRoundParameters() {
        player_score = 0;
        round = 0;
    }

    private void checkResponse(boolean playerResponse) {
        if (playerResponse) {
            player_score = 0;
            infoBubble("Wrong answer", Toast.LENGTH_LONG);
        } else {
            player_score = 100;
            infoBubble("Correct", Toast.LENGTH_LONG);
        }
    }

    private void bindingWidgetsToActivity() {
        trueButton = findViewById(R.id.true_button);
        falselButton = findViewById(R.id.false_button);
        playerTextView = findViewById(R.id.player_textView);
        couterTextView = findViewById(R.id.counter_textView);
        questionTextView = (TextView) findViewById(R.id.question);
    }
}
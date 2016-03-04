package com.example.notandi.diceroll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class DiceActivity extends AppCompatActivity {

    public static final String LOG_TAG = "IntentLog";
    int SECOND_ACTIVITY = 1;

    Button btnRoll;
    Button btnScore;
    NumberPicker pickNum;
    EditText txtDie1;
    EditText txtDie2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        this.setTitle("DiceRoll" + "- DiceActivity");

        btnRoll = (Button)findViewById(R.id.btnRoll);
        btnScore = (Button)findViewById(R.id.btnScore);
        pickNum = (NumberPicker)findViewById(R.id.pickNum);
        txtDie1 = (EditText)findViewById(R.id.txtDie1);
        txtDie2 = (EditText)findViewById(R.id.txtDie2);

        randomDices();

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiceActivity.this.onClickRoll();
            }
        });

        btnScore.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                DiceActivity.this.onClickScore();

            }
        });
    }

    public void onClickRoll()
    {
        randomDices();

    }

    public void onClickScore()
    {
        Intent intent = new Intent();
        intent.setClass(this, DiceScoreActivity.class);

        intent.putExtra("Die1", txtDie1.getText());
        intent.putExtra("Die2", txtDie2.getText());

        Log.d(LOG_TAG, "Score clicked!");
        startActivityForResult(intent, SECOND_ACTIVITY);
        Log.d(LOG_TAG, "Activity started!");


    }

    public void randomDices()
    {
        int die1 = (int)(Math.random()*6+1);
        int die2 = (int)(Math.random()*6+1);

        txtDie1.setText(Integer.valueOf(die1).toString());
        txtDie2.setText(Integer.valueOf(die2).toString());
    }

    @Override
    protected void onActivityResult (int reqCode,
                                     int resCode,
                                     Intent data)
    {
        if (resCode == SECOND_ACTIVITY)
        {
            switch (resCode){
                case RESULT_OK:
                    break;

            }
        }
    }
}

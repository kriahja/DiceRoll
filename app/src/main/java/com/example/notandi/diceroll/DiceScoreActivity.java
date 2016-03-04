package com.example.notandi.diceroll;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by notandi on 4.3.2016.
 */
public class DiceScoreActivity extends Activity
{

    Button btnBack;

    @Override protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dicescore);
        btnBack = (Button)findViewById(R.id.btnBack);

        this.setTitle("DiceRoll" + "- DiceScoreActivity");

        Bundle extras = getIntent().getExtras();
        String d1 = extras.get("Die1").toString();
        String d2 = extras.get("Die2").toString();
        TextView die1 = (TextView)findViewById(R.id.txtDie1);
        TextView die2 = (TextView)findViewById(R.id.txtDie2);
        TextView date = (TextView)findViewById(R.id.txtDate);


        die1.setText(d1);
        die2.setText(d2);
        String d = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        date.setText(d);




        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiceScoreActivity.this.onClickBack();
            }
        });

    }

    protected void onClickBack()
    {
        setResult(RESULT_CANCELED);
        finish();
    }
}

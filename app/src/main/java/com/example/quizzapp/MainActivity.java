package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int scoreOf7 = 0;
    private boolean EnterOncePerSubmtion = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Submit(View view) {
        RadioButton qustion1 = (RadioButton) findViewById(R.id.q1_cho2);
        RadioButton qustion2 = (RadioButton) findViewById(R.id.q2_cho1);
        CheckBox qustionThree1 = (CheckBox) findViewById(R.id.q3_cho1);
        CheckBox qustionThree2 = (CheckBox) findViewById(R.id.q3_cho2);
        CheckBox qustionThree3 = (CheckBox) findViewById(R.id.q3_cho3);
        CheckBox qustionThree4 = (CheckBox) findViewById(R.id.q3_cho4);
        RadioButton qustion4 = (RadioButton) findViewById(R.id.q4_cho4);
        RadioButton qustion5 = (RadioButton) findViewById(R.id.q5_cho2);
        RadioButton qustion6 = (RadioButton) findViewById(R.id.q6_cho2);
        TextView score = (TextView) findViewById(R.id.score);
        EditText name = (EditText) findViewById(R.id.name);
        EditText qustion7 = (EditText) findViewById(R.id.ana_q7);
        if (EnterOncePerSubmtion) {
            cheak(qustion1.isChecked());
            cheak(qustion2.isChecked());
            cheak(qustionThree1.isChecked() && qustionThree2.isChecked() && !qustionThree3.isChecked() && !qustionThree4.isChecked());
            cheak(qustion4.isChecked());
            cheak(qustion5.isChecked());
            cheak(qustion6.isChecked());
            if (qustion7.getText().toString().equalsIgnoreCase("object oriented")) {
                if (scoreOf7 < 7)
                    scoreOf7++;
                else
                    return;
            }
            EnterOncePerSubmtion = false;
        } else
            return;
        String scoreWithname = name.getText().toString() + " Score is: " + scoreOf7;
        score.setText(scoreWithname);
        Context context = getApplicationContext();
        CharSequence text = scoreWithname;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void cheak(Boolean aBoolean) {
        if (aBoolean)
            if (scoreOf7 < 7)
                scoreOf7++;
            else
                return;
    }

    public void rest(View view) {
        scoreOf7 = 0;
        TextView score = (TextView) findViewById(R.id.score);
        score.setText("");
        EnterOncePerSubmtion = true;
    }
}

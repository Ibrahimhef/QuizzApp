package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int scoreOf7=0;
    private boolean q1=true;
    private boolean q2=true;
    private boolean q3=true;
    private boolean q4=true;
    private boolean q5=true;
    private boolean q6=true;
    private boolean q7=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Submit(View view){
        RadioButton qustion1 = (RadioButton) findViewById(R.id.q1_cho2);
        RadioButton qustion2 = (RadioButton) findViewById(R.id.q2_cho1);
        CheckBox qustion3_1 = (CheckBox) findViewById(R.id.q3_cho1);
        CheckBox qustion3_2 = (CheckBox) findViewById(R.id.q3_cho2);
        CheckBox qustion3_3 = (CheckBox) findViewById(R.id.q3_cho3);
        CheckBox qustion3_4 = (CheckBox) findViewById(R.id.q3_cho4);
        RadioButton qustion4 = (RadioButton) findViewById(R.id.q4_cho4);
        RadioButton qustion5 = (RadioButton) findViewById(R.id.q5_cho2);
        RadioButton qustion6 = (RadioButton) findViewById(R.id.q6_cho2);
        EditText qustion7 = (EditText) findViewById(R.id.ana_q7);
        if (q1){
            cheak(qustion1.isChecked());
            q1=false;
        }
        if (q2){
            cheak(qustion2.isChecked());
            q2=false;
        }
        if (q3){
            cheak(qustion3_1.isChecked() && qustion3_2.isChecked() && !qustion3_3.isChecked() && !qustion3_4.isChecked());
            q3=false;
        }
        if (q4){
            cheak(qustion4.isChecked());
            q4=false;
        }
        if (q5){
            cheak(qustion5.isChecked());
            q5=false;
        }
        if (q6){
            cheak(qustion6.isChecked());
            q6=false;
        }
        if(q7) {
            if (qustion7.getText().toString().equalsIgnoreCase("object oriented"))
                if (scoreOf7 < 7)
                    scoreOf7++;
                q7=false;
        }
        TextView score = (TextView) findViewById(R.id.score);
        EditText name = (EditText) findViewById(R.id.name);
        score.setText(name.getText().toString()+" Score is: " + scoreOf7);
    }
    private void cheak(Boolean aBoolean){
        if (aBoolean)
            if (scoreOf7 <7)
            scoreOf7++;
    }
    public void rest(View view){
        scoreOf7=0;
        TextView score = (TextView) findViewById(R.id.score);
        score.setText("");
        q1=q2=q3=q4=q5=q6=q7=true;
    }
}

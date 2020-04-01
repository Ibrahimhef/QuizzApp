package com.example.quizzapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    private int scoreOf7 = 0;
    private boolean EnterOncePerSubmtion = true;
    @BindView(R.id.q1_cho2) RadioButton qustion1;
    @BindView(R.id.q2_cho1) RadioButton qustion2;
    @BindView(R.id.q4_cho4) RadioButton qustion4;
    @BindView(R.id.q5_cho2) RadioButton qustion5;
    @BindView(R.id.q6_cho2) RadioButton qustion6;
    @BindView(R.id.q3_cho1) CheckBox qustionThree1;
    @BindView(R.id.q3_cho2) CheckBox qustionThree2;
    @BindView(R.id.q3_cho3) CheckBox qustionThree3;
    @BindView(R.id.q3_cho4) CheckBox qustionThree4;
    @BindView(R.id.score)  TextView score;
    @BindView(R.id.name) EditText name;
    @BindView(R.id.ana_q7) EditText qustion7;
    @BindView(R.id.qustion_group_1) RadioGroup rQrup1;
    @BindView(R.id.qustion_group_2) RadioGroup rQrup2;
    @BindView(R.id.qustion_group_3) RadioGroup rQrup3;
    @BindView(R.id.qustion_group_4) RadioGroup rQrup4;
    @BindView(R.id.qustion_group_5) RadioGroup rQrup5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void Submit(View view) {
        StringBuilder scoreWithname = new StringBuilder();
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
        scoreWithname.append(name.getText()).append(" Score is: ").append(scoreOf7);
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
        rQrup1.clearCheck();
        rQrup2.clearCheck();
        rQrup3.clearCheck();
        rQrup4.clearCheck();
        rQrup5.clearCheck();
        qustionThree1.setChecked(false);
        qustionThree2.setChecked(false);
        qustionThree3.setChecked(false);
        qustionThree4.setChecked(false);
        name.setText(null);
        qustion7.setText(null);
        score.setText(null);
        EnterOncePerSubmtion = true;
    }
}

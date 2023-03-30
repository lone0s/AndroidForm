package com.example.androidform.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.androidform.R;
import com.example.androidform.Template;

public class GeneralQuestions1 extends Template
{

    private Switch hasProgrammingExp;
    private EditText programmingExpYears;
    private TextView programmingExpYearsLabel;

    public GeneralQuestions1() {
        super(R.layout.activity_general_questions_1);
    }

    @Override
    protected void nextButtonAction(View evt) {
        int[] answerScores = new int[11];

        // TODO : Process answers

        this.data.addScore(answerScores); // Set scores to add

        this.startActivity(this, GeneralQuestions2.class);
    }

    @Override
    protected boolean canClickNextButton() {
        // TODO : Verify age > 0 && < 120 ; Parse && save}
        return true; // TODO : Check form validity
    }

    @NonNull
    @Override
    protected CharSequence onInvalidFormToastText() {
        return "TODO : insert resource here"; // TODO
    }

    public void onCreateHook(Bundle savedInstanceState) {
        hasProgrammingExp = findViewById(R.id.switchProgExp);

        programmingExpYears = findViewById(R.id.inputProgYears);

        programmingExpYearsLabel = findViewById(R.id.labelProgYears);

        programmingExpYears.setVisibility(View.GONE);

        programmingExpYearsLabel.setVisibility(View.GONE);

        hasProgrammingExp.setOnCheckedChangeListener(
                (buttonView, isChecked) ->
                {
                    programmingExpYears.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                    programmingExpYearsLabel.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                }
        );
    }
}
package com.example.androidform.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.androidform.R;
import com.example.androidform.Template;

public class GeneralQuestions1 extends Template
{
    private final int MIN_AGE = 0;
    private final int MAX_AGE = 120;
    private TextView ageInput;
    private Switch hasProgrammingExp;
    private EditText programmingExpYears;
    private TextView programmingExpYearsLabel;
    private RadioGroup professionalStatus;

    public GeneralQuestions1() {
        super(R.layout.activity_general_questions_1);
    }

    @Override
    protected void nextButtonAction(View evt) {
        int[] answerScores = new int[11];
        if(canClickNextButton()) {
            // TODO : Process answers
            this.data.addScore(answerScores); // Set scores to add
            this.nextActivity(this, GeneralQuestions2.class);
        }
        else {
            this.onInvalidFormToastText();
        }
    }

    public void onCreateHook(Bundle savedInstanceState) {
        ageInput = findViewById(R.id.ageInput);

        professionalStatus = findViewById(R.id.radioGroup);

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

    @Override
    protected boolean canClickNextButton() {
        boolean verifiedAll = true;
        int parsedAge = Integer.parseInt(ageInput.getText().toString());
        //Age
        if (!isCorrectNumericInput(MIN_AGE,MAX_AGE,parsedAge)) {
            ageInput.setTextColor(Color.RED);
            verifiedAll = false;
        }
        //Professional status
        if (professionalStatus.getCheckedRadioButtonId() == -1) {
            verifiedAll = false;
            professionalStatus.setBackgroundColor(Color.RED);
        }
        //Prog exp
        //TODO: RAJOUTER DEFAULT VALUES A INPUTS
        if (hasProgrammingExp.isActivated()) {
           int parsedProgExp = Integer.parseInt(programmingExpYears.getText().toString());
            if((parsedAge - parsedProgExp) < 1) {
                verifiedAll = false;
                hasProgrammingExp.setTextColor(Color.RED);
            }
        }
        return verifiedAll;
    }

    @NonNull
    @Override
    protected CharSequence onInvalidFormToastText() {
        return "TODO : insert resource here"; // TODO
    }

    void resetWidgetsColors() {
        this.ageInput.setTextColor(Color.BLACK);
        this.professionalStatus.setBackgroundColor(Color.TRANSPARENT);
        this.programmingExpYears.setTextColor(Color.BLACK);
    }

    boolean isCorrectNumericInput(int min, int max, int value) {
        return value > min && value < max;
    }
}
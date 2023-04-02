package com.example.androidform.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.androidform.R;
import com.example.androidform.Template;
import com.example.androidform.core.Language;

public class GeneralQuestions1 extends Template
{
    private static final String LOGGER_TAG = "General_Information_1";
    private final int MIN_AGE = 0;
    private final int MAX_AGE = 120;
    private EditText ageInput;
    private TextView ageInputLabel;
    private Switch hasProgrammingExp;
    private EditText programmingExpYears;
    private TextView programmingExpYearsLabel;
    private RadioGroup professionalStatus;
    private TextView professionalStatusLabel;

    public GeneralQuestions1() {
        super(R.layout.activity_general_questions_1);
    }

    //TODO : Fix issue with experience years input not needing to be verified
    @Override
    protected void nextButtonAction(View evt) {
        int[] answerScores = new int[11];
        if (data.getName().equals("Hakim"))
            answerScores[Language.CPP.toInt()] += 3;
        if (data.getName().equals("Xavier"))
            answerScores[Language.Java.toInt()] += 3;

        this.resetWidgetErrors();

        //AgeInput
        int age = Integer.parseInt(ageInput.getText().toString());
        if (age <= 20) {
            answerScores[Language.toInt(Language.Python)]++;
            answerScores[Language.toInt(Language.Java)]++;
            answerScores[Language.toInt(Language.Rust)]++;
        }
        if (age <= 50) {
            answerScores[Language.toInt(Language.JS)]++;
            answerScores[Language.toInt(Language.CS)]++;
            answerScores[Language.toInt(Language.CPP)]++;
            answerScores[Language.toInt(Language.PHP)]++;
        }
        if (age > 50) {
            answerScores[Language.toInt(Language.Malbolge)]++;
            answerScores[Language.toInt(Language.R)]++;
            answerScores[Language.toInt(Language.Caml)]++;
            answerScores[Language.toInt(Language.Haskell)]++;
        }

        //Professional status
        if (professionalStatus.getCheckedRadioButtonId() == R.id.status_rb_1) {
            answerScores[Language.toInt(Language.Python)]++;
            answerScores[Language.toInt(Language.JS)]++;
            answerScores[Language.toInt(Language.Malbolge)]++;

        } else if (professionalStatus.getCheckedRadioButtonId() == R.id.status_rb_2) {
            answerScores[Language.toInt(Language.CPP)]++;
            answerScores[Language.toInt(Language.R)]++;
            answerScores[Language.toInt(Language.Caml)]++;
            answerScores[Language.toInt(Language.Haskell)]++;
        } else {
            answerScores[Language.toInt(Language.Rust)]++;
            answerScores[Language.toInt(Language.CS)]++;
            answerScores[Language.toInt(Language.Java)]++;
            answerScores[Language.toInt(Language.PHP)]++;
        }


        //Programming exp
        //TODO : Fix issue with experience years input not needing to be verified idk why
        if (hasProgrammingExp.isChecked()) {
            int years = /*programmingExpYears.getText().toString().equals("") ?
                        0 :*/
                    Integer.parseInt(programmingExpYears.getText().toString());

            if (years == 1) {
                answerScores[Language.toInt(Language.Python)]++;
                answerScores[Language.toInt(Language.JS)]++;
            }
            if (years <= 3) {
                answerScores[Language.toInt(Language.CS)]++;
                answerScores[Language.toInt(Language.Java)]++;
                answerScores[Language.toInt(Language.PHP)]++;
            }
            if (years > 3) {
                answerScores[Language.toInt(Language.Rust)]++;
                answerScores[Language.toInt(Language.CPP)]++;
                answerScores[Language.toInt(Language.R)]++;
                answerScores[Language.toInt(Language.Caml)]++;
                answerScores[Language.toInt(Language.Haskell)]++;
                answerScores[Language.toInt(Language.Malbolge)]++;
            }
        } else {
            answerScores[Language.toInt(Language.Python)]++;
            answerScores[Language.toInt(Language.Java)]++;
            answerScores[Language.toInt(Language.PHP)]++;
            answerScores[Language.toInt(Language.CS)]++;
            answerScores[Language.toInt(Language.JS)]++;
        }

        this.data.addScore(answerScores); // Set scores to add
        this.startActivity(this, GeneralQuestions2.class);
    }

    public void onCreateHook(Bundle savedInstanceState) {
        professionalStatusLabel = findViewById(R.id.statusLabel);

        ageInputLabel = findViewById(R.id.ageLabel);

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
        String age = ageInput.getText().toString();
        int parsedAge = MIN_AGE;

        if (age.isEmpty()) {
            ageInput.setError(getString(R.string.error_age));
            verifiedAll = false;
        }
        //Age
        else {
            parsedAge = Integer.parseInt(age);
            if (!isCorrectNumericInput(MIN_AGE, MAX_AGE, parsedAge)) {
                verifiedAll = false;
                ageInput.setError(getString(R.string.error_age));
            }
        }
        //Professional status
        if (professionalStatus.getCheckedRadioButtonId() == -1) {
            verifiedAll = false;
            professionalStatusLabel.setError(getString(R.string.error_professional_status));
        }
        //Prog exp
        //TODO: RAJOUTER DEFAULT VALUES A INPUTS
        if (hasProgrammingExp.isActivated()) {
           int parsedProgExp = 0;
            String progExp = programmingExpYears.getText().toString();
            if (progExp.equals("")) {
                verifiedAll = false;
                programmingExpYears.setError(getString(R.string.error_experience));
            }
            else {
                parsedProgExp = Integer.parseInt(progExp);
                if(!isCorrectNumericInput(MIN_AGE, parsedAge, parsedAge-parsedProgExp)){
                    verifiedAll = false;
                    programmingExpYears.setError(getString(R.string.error_experience));
                }
            }
        }
        return verifiedAll;
    }

    @NonNull
    @Override
    protected CharSequence onInvalidFormToastText() {
        return getString(R.string.toast_incomplete_inputs);
    }

    void resetWidgetErrors() {
        this.ageInput.setError(null);
        this.professionalStatusLabel.setError(null);
        this.programmingExpYears.setError(null);
    }

    boolean isCorrectNumericInput(int min, int max, int value) {
        return value > min && value < max;
    }
}
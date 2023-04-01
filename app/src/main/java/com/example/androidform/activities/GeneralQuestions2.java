package com.example.androidform.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;

import com.example.androidform.DataContainer;
import com.example.androidform.R;
import com.example.androidform.Template;
import com.example.androidform.core.Language;
import com.example.androidform.questions.activities.generics.man_made.MCQ_Liking_Dislike;
//import com.example.androidform.questions.activities.generics.BSQ_YesOrNo;

public class GeneralQuestions2 extends Template {

    private static final String LOGGER_TAG = "General_Information_2";
    private TextView labelInterests;
    private CheckBox[] optionsInterests = new CheckBox[4];
    private RadioGroup interestsRadioGroup;
    private Spinner spinnerPersonality;
    private SeekBar socialyInaptBar;
    private TextView labelSocialyInaptValue;
    private ToggleButton toggleLieDetector;
    private boolean lieDetectorEnabled;

    public GeneralQuestions2() {
        super(R.layout.activity_general_questions_2);
    }
    //TODO : Penser a mettre les focus en auto sur les labels des inputs pour les erreurs
    @Override
    protected boolean canClickNextButton() {
        boolean isFormValid = false;
        for (CheckBox option : optionsInterests) {
            if (option.isChecked()) {
                isFormValid = true;
                break;
            }
        }
        if (!isFormValid)
            labelInterests.setError(getText(R.string.error_interests));
        return isFormValid;
    }

    @NonNull
    @Override
    protected CharSequence onInvalidFormToastText() {
        return getString(R.string.toast_incomplete_inputs);
    }

    public void onCreateHook(Bundle savedInstanceState) {
        this.labelInterests = findViewById(R.id.labelInterests);

        int[] optionsInterestsIds = {
                R.id.optionInterests1,
                R.id.optionInterests2,
                R.id.optionInterests3,
                R.id.optionInterests4};

        for (int i = 0; i < optionsInterestsIds.length; ++i) {
            optionsInterests[i] = findViewById(optionsInterestsIds[i]);
        }

        this.spinnerPersonality = findViewById(R.id.spinnerPersonality);
        this.socialyInaptBar = findViewById(R.id.seekBar4);
        this.labelSocialyInaptValue = findViewById(R.id.labelSocialyInaptValue);
        this.toggleLieDetector = findViewById(R.id.toggleLieDetector);

        String initialSocialyInaptValue = socialyInaptBar.getProgress() + "%";
        this.labelSocialyInaptValue.setText(initialSocialyInaptValue);
        this.lieDetectorEnabled = this.toggleLieDetector.isEnabled();


        this.socialyInaptBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String socialyInaptValue = String.valueOf(progress) + "%";
                labelSocialyInaptValue.setText(socialyInaptValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(GeneralQuestions2.LOGGER_TAG, "Socialy inapt value start of change" );
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(GeneralQuestions2.LOGGER_TAG, "Socialy inapt value end of change" );
            }
        });

        this.toggleLieDetector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lieDetectorEnabled = !lieDetectorEnabled;
                Log.d(GeneralQuestions2.LOGGER_TAG, "Lie detector value: " + lieDetectorEnabled);
            }
        });
    }

    @Override
    protected void nextButtonAction(View evt) {
        int[] answerScores = new int[11];

        // TODO : Process answers
        // Process interests
        if (optionsInterests[0].isChecked()) {
            answerScores[Language.toInt(Language.CPP)]++;
            answerScores[Language.toInt(Language.Rust)]++;
            answerScores[Language.toInt(Language.Malboge)]++;
        }
        if(optionsInterests[1].isChecked()) {
            answerScores[Language.toInt(Language.CS)]++;
            answerScores[Language.toInt(Language.Java)]++;
            answerScores[Language.toInt(Language.Python)]++;
            answerScores[Language.toInt(Language.JS)]++;
        }
        if (optionsInterests[2].isChecked()) {
            answerScores[Language.toInt(Language.Caml)]++;
            answerScores[Language.toInt(Language.Python)]++;
            answerScores[Language.toInt(Language.JS)]++;
        }
        if (optionsInterests[3].isChecked()) {
            answerScores[Language.toInt(Language.Haskell)]++;
            answerScores[Language.toInt(Language.CPP)]++;
            answerScores[Language.toInt(Language.Rust)]++;
            answerScores[Language.toInt(Language.R)]++;
        }

        // Process personality
        String personality = spinnerPersonality.getSelectedItem().toString();
        String[] personalities = getResources().getStringArray(R.array.personality_types_values);
        if (personality.equals(personalities[0])) {
            answerScores[Language.toInt(Language.CPP)]++;
            answerScores[Language.toInt(Language.Caml)]++;
            answerScores[Language.toInt(Language.Haskell)]++;
            answerScores[Language.toInt(Language.R)]++;
        }
        if (personality.equals(personalities[1])) {
            answerScores[Language.toInt(Language.Java)]++;
            answerScores[Language.toInt(Language.Python)]++;
            answerScores[Language.toInt(Language.JS)]++;
        }
        if (personality.equals(personalities[2])) {
            answerScores[Language.toInt(Language.R)]++;
            answerScores[Language.toInt(Language.Malboge)]++;
            answerScores[Language.toInt(Language.Rust)]++;
        }
        if (personality.equals(personalities[3])) {
            answerScores[Language.toInt(Language.Haskell)]++;
            answerScores[Language.toInt(Language.CPP)]++;
            answerScores[Language.toInt(Language.Caml)]++;
        }
        else {
            answerScores[Language.toInt(Language.CS)]++;
            answerScores[Language.toInt(Language.Java)]++;
            answerScores[Language.toInt(Language.Python)]++;
            answerScores[Language.toInt(Language.JS)]++;
            answerScores[Language.toInt(Language.PHP)]++;
        }

        // Process socialy inapt
        int socialyInaptValue = socialyInaptBar.getProgress();
        if (socialyInaptValue < 25) {
            answerScores[Language.toInt(Language.Python)]++;
            answerScores[Language.toInt(Language.JS)]++;
        }
        else if (socialyInaptValue < 75) {
            answerScores[Language.toInt(Language.CS)]++;
            answerScores[Language.toInt(Language.Java)]++;
            answerScores[Language.toInt(Language.PHP)]++;
            answerScores[Language.toInt(Language.CPP)]++;
            answerScores[Language.toInt(Language.Caml)]++;
        }
        else{
            answerScores[Language.toInt(Language.Rust)]++;
            answerScores[Language.toInt(Language.Haskell)]++;
            answerScores[Language.toInt(Language.R)]++;
            answerScores[Language.toInt(Language.Malboge)]++;
        }

        // Process lie detector
        if (lieDetectorEnabled) {
            answerScores[Language.toInt(Language.Python)]++;
            answerScores[Language.toInt(Language.JS)]++;
            answerScores[Language.toInt(Language.PHP)]++;
            answerScores[Language.toInt(Language.Java)]++;
            answerScores[Language.toInt(Language.Malboge)]++;
        }
        else {
            answerScores[Language.toInt(Language.CPP)]++;
            answerScores[Language.toInt(Language.Caml)]++;
            answerScores[Language.toInt(Language.Haskell)]++;
            answerScores[Language.toInt(Language.Rust)]++;
            answerScores[Language.toInt(Language.R)]++;
            answerScores[Language.toInt(Language.CS)]++;
        }

        resetWidgetErrors();
        this.data.addScore(answerScores);
        this.startActivity(this, MCQ_Liking_Dislike.class);
    }

    void resetWidgetErrors() {
        this.labelInterests.setError(null);
    }
}
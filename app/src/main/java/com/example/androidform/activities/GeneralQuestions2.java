package com.example.androidform.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.androidform.R;
import com.example.androidform.Template;

public class GeneralQuestions2 extends Template {

    private static final String LOGGER_TAG = "General_Information_2";
    private CheckBox[] optionsInterests = new CheckBox[4];
    private Spinner spinnerPersonality;
    private SeekBar socialyInaptBar;
    private TextView labelSocialyInaptValue;
    private ToggleButton toggleLieDetector;
    private boolean lieDetectorEnabled;

    public GeneralQuestions2() {
        super(R.layout.activity_general_questions_2);
    }

    public void onCreateHook(Bundle savedInstanceState) {
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

        String initialSocialyInaptValue = String.valueOf(socialyInaptBar.getProgress()) + "%";
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
    protected void backButtonAction(View evt) {
        Log.d(GeneralQuestions2.LOGGER_TAG, "Previous button clicked");
        Intent intent = new Intent(this, GeneralQuestions1.class);
        this.startActivity(intent);
    }

    @Override
    protected void nextButtonAction(View evt) {
        Log.d(GeneralQuestions2.LOGGER_TAG, "Next button clicked");
    }

    public void verifyData() {

    }

    public void saveData() {

    }

    public void loadData() {

    }
}
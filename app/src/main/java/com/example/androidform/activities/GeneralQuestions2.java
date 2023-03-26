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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_questions_2);

        int[] optionsInterestsIds = {R.id.optionInterests1, R.id.optionInterests2, R.id.optionInterests3, R.id.optionInterests4};
        for (int i = 0; i < optionsInterestsIds.length; ++i) {
            optionsInterests[i] = findViewById(optionsInterestsIds[i]);
        }
        spinnerPersonality = findViewById(R.id.spinnerPersonality);
        socialyInaptBar = findViewById(R.id.seekBar4);
        labelSocialyInaptValue = findViewById(R.id.labelSocialyInaptValue);
        toggleLieDetector = findViewById(R.id.toggleLieDetector);

        String initialSocialyInaptValue = String.valueOf(socialyInaptBar.getProgress()) + "%";
        labelSocialyInaptValue.setText(initialSocialyInaptValue);
        lieDetectorEnabled = toggleLieDetector.isEnabled();


        socialyInaptBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

        toggleLieDetector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lieDetectorEnabled = !lieDetectorEnabled;
                Log.d(GeneralQuestions2.LOGGER_TAG, "Lie detector value: " + lieDetectorEnabled);
            }
        });
    }

    //TODO : Fix weird bug, backbutton not working
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
}
package com.example.androidform.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.androidform.R;
import com.example.androidform.Template;

public class GeneralQuestions1 extends Template {


    private static final String LOGGER_TAG = "General_Information_1";
    private Switch hasProgrammingExp;
    private EditText programmingExpYears;
    private TextView programmingExpYearsLabel;

    public GeneralQuestions1() {
        super(R.layout.activity_general_questions_1);
    }

    @Override
    protected void backButtonAction(View evt) {
        Log.d(GeneralQuestions1.LOGGER_TAG, "Previous button clicked");
        Log.e(GeneralQuestions1.LOGGER_TAG, "NEW VIEW CREATED, NOT OPTIMAL");
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    @Override
    protected void nextButtonAction(View evt) {
        Log.d(GeneralQuestions1.LOGGER_TAG, "Next button clicked");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hasProgrammingExp = findViewById(R.id.switchProgExp);
        programmingExpYears = findViewById(R.id.inputProgYears);
        programmingExpYearsLabel = findViewById(R.id.labelProgYears);
        programmingExpYears.setVisibility(View.GONE);
        programmingExpYearsLabel.setVisibility(View.GONE);
        hasProgrammingExp.setOnCheckedChangeListener((buttonView, isChecked) -> {
            programmingExpYears.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            programmingExpYearsLabel.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });
    }

    //TODO: Verify age > 0 && < 120 ; Parse && save
    //TODO: Fix layout constraints
}
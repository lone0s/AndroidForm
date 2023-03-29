package com.example.androidform;

import android.content.Intent;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.androidform.activities.GeneralQuestions1;
import com.example.androidform.core.Language;
import com.example.androidform.questions.activities.generics.BSQ_YesOrNo;
import com.example.androidform.activities.MainActivity;

public class GeneralInformation extends Template {

    private static final String LOGGER_TAG = "General_Information";

    public GeneralInformation() {
        super(R.layout.activity_general_questions_1);
    }

    @Override
    protected boolean canClickNextButton() {
        return true;
    }

    @NonNull
    @Override
    protected CharSequence onInvalidFormToastText() {
        return "Test";
    }

    @Override
    protected void nextButtonAction(View evt) {
        int[] answerScores = new int[11];

        // TODO : Process answers

        this.data.addScore(answerScores); // Set scores to add

        this.nextActivity(this, GeneralQuestions1.class);
    }
}
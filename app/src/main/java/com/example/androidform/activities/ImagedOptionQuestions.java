package com.example.androidform.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.androidform.R;
import com.example.androidform.Template;

public class ImagedOptionQuestions extends Template {

    public ImagedOptionQuestions() {
        super(R.layout.activity_imaged_option_questions);
    }

    public void onCreateHook(Bundle savedInstanceState) {

    }

    @Override
    protected boolean canClickNextButton() {
        return false;
    }

    @NonNull
    @Override
    protected CharSequence onInvalidFormToastText() {
        return null;
    }

    @Override
    protected void nextButtonAction(View evt) {

    }
}
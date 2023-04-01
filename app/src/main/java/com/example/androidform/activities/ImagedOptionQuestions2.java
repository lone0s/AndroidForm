package com.example.androidform.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.androidform.R;
import com.example.androidform.Template;

public class ImagedOptionQuestions2 extends Template {

    public ImagedOptionQuestions2() {
        super(R.layout.activity_imaged_option_questions2);
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
        return getString(R.string.img_no_select_toast);
    }

    @Override
    protected void nextButtonAction(View evt) {

    }
}
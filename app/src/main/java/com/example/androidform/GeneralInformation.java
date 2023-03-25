package com.example.androidform;

import android.content.Intent;
import android.util.Log;
import android.view.View;

public class GeneralInformation extends Template {

    private static final String LOGGER_TAG = "General_Information";

    public GeneralInformation() {
        super(R.layout.activity_general_information);
    }

    @Override
    protected void backButtonAction(View evt) {
        Log.d(GeneralInformation.LOGGER_TAG, "Previous button clicked");
        Log.e(GeneralInformation.LOGGER_TAG, "NEW VIEW CREATED, NOT OPTIMAL");
        Intent intent = new Intent(this, MainActivity.class);

        this.startActivity(intent);
    }

    @Override
    protected void nextButtonAction(View evt) {
        Log.d(GeneralInformation.LOGGER_TAG, "Next button clicked");
//        Intent intent = new Intent(this, GeneralInformation.class);
//
//        this.startActivity(intent);
    }
}
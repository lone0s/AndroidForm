package com.example.androidform.questions.activities.generics.man_made;

import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import com.example.androidform.R;
import com.example.androidform.Template;
import com.example.androidform.core.Language;

public class UCQ_YoN_Boat extends Template {
    public UCQ_YoN_Boat() {
        super(R.layout.ucq_yon_boat);
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
        int[] answerScores = new int[11];

        // UCQ_Boat

        // UCQ_YoN


        // Persisting data
        this.data.addScore(answerScores); // Set scores to add

        this.startActivity(this, UCQ_YoN_Boat.class);
    }
}

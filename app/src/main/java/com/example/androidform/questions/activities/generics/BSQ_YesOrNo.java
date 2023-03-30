package com.example.androidform.questions.activities.generics;

import android.util.Log;
import android.view.View;

import com.example.androidform.R;
import com.example.androidform.core.Language;
import com.example.androidform.questions.activities.generics.templates.RadioButtonQuestionActivity;

public class BSQ_YesOrNo extends RadioButtonQuestionActivity
{

    private static final String LOGGER_TAG = "[Yes, or No?]";

    @Override
    protected int[] possibleAnswersResourceIds() {
        return new int[]
                {
                        R.string.YesOrNo_A_Yes,
                        R.string.YesOrNo_A_No,
                        R.string.YesOrNo_A_Rust
                };
    }

    @Override
    protected int questionTextResourceId() {
        return R.string.YesOrNo_Q;
    }

    @Override
    protected void nextButtonAction(View evt) {
        Integer answer = this.question.getAnswer();

        Log.d(BSQ_YesOrNo.LOGGER_TAG, "Updating DataContainer");

        int[] answerScores = new int[11];
        if (answer == 0) answerScores[Language.Rust.toInt()] = 0; // rustScore
        if (answer == 1) answerScores[Language.Rust.toInt()] = 1; // rustScore
        if (answer == 2) answerScores[Language.Rust.toInt()] = 2; // rustScore

        this.data.addScore(answerScores);

        this.startActivity(this, BSQ_Boat.class);
    }
}
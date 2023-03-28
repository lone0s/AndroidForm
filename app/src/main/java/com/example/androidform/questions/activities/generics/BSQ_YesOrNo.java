package com.example.androidform.questions.activities.generics;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.androidform.DataContainer;
import com.example.androidform.GenericQuestionActivity;
import com.example.androidform.R;
import com.example.androidform.core.Language;
import com.example.androidform.questions.activities.generics.templates.RadioButtonQuestionActivity;
import com.example.androidform.questions.lib.RadioButtonQuestion;

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
        if (answer == null) return;

        Log.d(BSQ_YesOrNo.LOGGER_TAG, "Creating and updating DataContainer");
        DataContainer dc = new DataContainer();

        int[] answerScores = new int[11];
        if (answer == 0) answerScores[Language.Rust.toInt()] = 0; // rustScore
        if (answer == 1) answerScores[Language.Rust.toInt()] = 1; // rustScore
        if (answer == 2) answerScores[Language.Rust.toInt()] = 2; // rustScore

        dc.addScore(answerScores);


        Intent next = new Intent(this, BSQ_Boat.class);

        Log.d(BSQ_YesOrNo.LOGGER_TAG, "Sending DataContainer to Intent");
        next.putExtra("scores", dc);

        Log.d(BSQ_YesOrNo.LOGGER_TAG, "Launching activity SecondRadioQuestion");
        this.startActivity(next);
    }
}
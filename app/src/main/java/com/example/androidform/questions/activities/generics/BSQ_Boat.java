package com.example.androidform.questions.activities.generics;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;

import com.example.androidform.DataContainer;
import com.example.androidform.GenericQuestionActivity;
import com.example.androidform.R;
import com.example.androidform.activities.GeneralQuestions1;
import com.example.androidform.questions.activities.generics.templates.RadioButtonQuestionActivity;
import com.example.androidform.questions.lib.RadioButtonQuestion;

public class BSQ_Boat extends RadioButtonQuestionActivity
{

    @Override
    protected int[] possibleAnswersResourceIds() {
        return new int[]{
                R.string.Boat_A_SameBoat,
                R.string.Boat_A_NotSameBoat,
                R.string.Boat_A_Pointer,
                R.string.Boat_A_Boat,
                R.string.Boat_A_Rust
        };
    }

    @Override
    protected int questionTextResourceId() {
        return R.string.Boat_Q;
    }

    @Override
    protected void nextButtonAction(View evt) {
        int[] answerScores = new int[11];

        // TODO : Process answers

        this.data.addScore(answerScores); // Set scores to add

        //this.nextActivity(this, GeneralQuestions1.class); // TODO : Decommenter
    }
}

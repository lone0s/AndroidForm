package com.example.androidform.questions.activities.generics;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;

import com.example.androidform.DataContainer;
import com.example.androidform.GenericQuestionActivity;
import com.example.androidform.R;
import com.example.androidform.questions.activities.generics.templates.RadioButtonQuestionActivity;
import com.example.androidform.questions.lib.RadioButtonQuestion;

public class BSQ_Boat extends RadioButtonQuestionActivity
{

    private static final String LOGGER_TAG = "Boat question";

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
        Log.d(BSQ_Boat.LOGGER_TAG, "Retrieving Intent and DataContainer scores");
        DataContainer dc = this.getIntent().getParcelableExtra("scores");
        assert dc != null;
    }
}

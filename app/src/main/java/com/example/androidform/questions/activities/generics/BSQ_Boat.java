package com.example.androidform.questions.activities.generics;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;

import com.example.androidform.DataContainer;
import com.example.androidform.GenericQuestionActivity;
import com.example.androidform.R;
import com.example.androidform.questions.lib.RadioButtonQuestion;

public class BSQ_Boat extends GenericQuestionActivity<RadioButtonQuestion, Integer>
{

    private static final String LOGGER_TAG = "Boat question";

    @Override
    protected void buildQuestion() {
        Resources resources = getResources();

        this.question = RadioButtonQuestion.build(
                this,
                getResources().getString(R.string.Boat_Q),
                new String[]{
                        resources.getString(R.string.Boat_A_SameBoat),
                        resources.getString(R.string.Boat_A_NotSameBoat),
                        resources.getString(R.string.Boat_A_Pointer),
                        resources.getString(R.string.Boat_A_Boat),
                        resources.getString(R.string.Boat_A_Rust)
                }
        );

        Log.d(BSQ_Boat.LOGGER_TAG, "Retrieving Intent and DataContainer scores");
        DataContainer dc = this.getIntent().getParcelableExtra("scores");
        assert dc != null;
    }

    @Override
    protected void nextButtonAction(View evt) {

    }
}

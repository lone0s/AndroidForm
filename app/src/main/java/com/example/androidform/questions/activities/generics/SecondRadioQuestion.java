package com.example.androidform.questions.activities.generics;

import android.util.Log;
import android.util.Pair;
import android.view.View;

import com.example.androidform.DataContainer;
import com.example.androidform.GenericQuestionActivity;
import com.example.androidform.core.Language;
import com.example.androidform.questions.lib.RadioButtonQuestion;

import java.util.Arrays;
import java.util.HashMap;

public class SecondRadioQuestion extends GenericQuestionActivity<RadioButtonQuestion, Short>
{

    private static final String LOGGER_TAG = "";

    @Override
    protected void buildQuestion() {
        HashMap<String, Pair<Language, Short>> answers = new HashMap<>();

        answers.put("D", new Pair<>(Language.Malboge, (short) 1));
        answers.put("E", new Pair<>(Language.Java, (short) 2));
        answers.put("F", new Pair<>(Language.CPP, (short) 3));

        this.question = RadioButtonQuestion.build(
                this,
                "D, E ou F ?",
                answers
        );

        Log.d(SecondRadioQuestion.LOGGER_TAG, "Retrieving Intent and DataContainer scores");
        DataContainer dc = this.getIntent().getParcelableExtra("scores");
        assert dc != null;
    }

    @Override
    protected void nextButtonAction(View evt) {

    }
}

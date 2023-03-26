package com.example.androidform.questions.activities.generics;

import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.View;

import com.example.androidform.GenericQuestionActivity;
import com.example.androidform.MainActivity;
import com.example.androidform.core.Language;
import com.example.androidform.questions.lib.RadioButtonQuestion;

import java.util.HashMap;

public class PrototypeRadioQuestion extends GenericQuestionActivity<RadioButtonQuestion, Short>
{

    private static final String LOGGER_TAG = "[A, B or C?]";

    @Override
    protected void buildQuestion() {
        HashMap<String, Pair<Language, Short>> answers = new HashMap<>();

        answers.put("A", new Pair<>(Language.Malboge, (short) 1));
        answers.put("B", new Pair<>(Language.Java, (short) 2));
        answers.put("C", new Pair<>(Language.CPP, (short) 3));

        this.question = RadioButtonQuestion.build(
                this,
                "A, B, ou C ?",
                answers
        );
    }

    @Override
    protected void nextButtonAction(View evt) {
        Short answer = this.question.getAnswer();
        if (answer == null) return;

        Intent next = new Intent(this, MainActivity.class);
        Log.d(PrototypeRadioQuestion.LOGGER_TAG, "User enterded #" + this.question.getAnswer());

        this.startActivity(next);
    }
}
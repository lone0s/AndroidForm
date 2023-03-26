package com.example.androidform.questions.activities.generics;

import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.androidform.DataContainer;
import com.example.androidform.GenericQuestionActivity;
import com.example.androidform.MainActivity;
import com.example.androidform.core.Language;
import com.example.androidform.questions.lib.RadioButtonQuestion;

import java.util.HashMap;
import java.util.stream.Stream;

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
        Log.d(PrototypeRadioQuestion.LOGGER_TAG, "User entered #" + this.question.getAnswer());

        Log.d(PrototypeRadioQuestion.LOGGER_TAG, "Creating and updating DataContainer");
        DataContainer dc = new DataContainer();

        int[] answerScores = new int[11];
        if (answer == 0) answerScores[0] = 0; // rustScore
        if (answer == 1) answerScores[0] = 1; // rustScore
        if (answer == 2) answerScores[0] = 2; // rustScore

        dc.addScore(answerScores);


        Intent next = new Intent(this, SecondRadioQuestion.class);

        Log.d(PrototypeRadioQuestion.LOGGER_TAG, "Sending DataContainer to Intent");
        next.putExtra("scores", dc);

        Log.d(PrototypeRadioQuestion.LOGGER_TAG, "Launching activity SecondRadioQuestion");
        this.startActivity(next);
    }
}
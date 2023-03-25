package com.example.androidform;

import android.os.Bundle;
import android.util.Pair;

import com.example.androidform.core.Language;
import com.example.androidform.questions.lib.Question;
import com.example.androidform.questions.lib.RadioButtonQuestion;

import java.util.HashMap;

public class PrototypeRadioQuestion extends GenericQuestionActivity<RadioButtonQuestion, Short>
{

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
}
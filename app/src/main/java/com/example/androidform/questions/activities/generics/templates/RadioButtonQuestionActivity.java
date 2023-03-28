package com.example.androidform.questions.activities.generics.templates;

import android.content.res.Resources;

import com.example.androidform.GenericQuestionActivity;
import com.example.androidform.questions.lib.RadioButtonQuestion;

public abstract class RadioButtonQuestionActivity extends GenericQuestionActivity<RadioButtonQuestion, Integer> {

    @Override
    protected final void buildQuestion() {
        Resources resources = getResources();

        int[] answersIds = this.possibleAnswersResourceIds();
        String[] answers = new String[answersIds.length];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = resources.getString(answersIds[i]);
        }

        this.question = RadioButtonQuestion.build(
                this,
                resources.getString(this.questionTextResourceId()),
                answers
        );
    }

    protected abstract int[] possibleAnswersResourceIds();
    protected abstract int questionTextResourceId();
}

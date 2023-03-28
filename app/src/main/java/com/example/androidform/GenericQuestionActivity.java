package com.example.androidform;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.constraintlayout.widget.Group;

import com.example.androidform.questions.lib.Question;

public abstract class GenericQuestionActivity<QuestionType extends Question<Answers>, Answers> extends Template {

    protected QuestionType question;

    public GenericQuestionActivity() {
        super(R.layout.activity_generic_question);
    }

    protected abstract void buildQuestion();

    @Override
    public final void onCreateHook(Bundle savedInstanceState)
    {
        this.buildQuestion();

        ((ViewGroup) this.findViewById(R.id.genericActivity_QuestionContainer)).addView(
            this.question.getComponent()
        );
    }
}
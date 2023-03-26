package com.example.androidform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.androidform.R;
import com.example.androidform.questions.lib.Question;

public abstract class GenericQuestionActivity<QuestionType extends Question<Answers>, Answers> extends AppCompatActivity {

    protected QuestionType question;

    protected abstract void buildQuestion();

    @Override
    protected final void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_generic_question);

        this.buildQuestion();
        this.addContentView(this.question.getComponent(), new RadioGroup.LayoutParams(-2, -2));
    }
}
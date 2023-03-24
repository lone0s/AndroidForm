package com.example.androidform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.HashMap;

public class GenericQuestionActivity extends AppCompatActivity {

    protected final Question question;

    //TODO : Move l'enum (ici car actuellement un proto)
    public enum Language
    {
        Rust, CPP, Malboge, Java, Python
    }

    public static class Question
    {
        @NonNull
        private final View target;

        @NonNull
        private final Collection<Pair<Language, Short>> answers;


        private Question(
                @NonNull final View target,
                @NonNull final Collection<Pair<Language, Short>> answers

        ) // Choix du type numérique arbitraire
        {
            super();

            this.target = target;
            this.answers = answers;
        }

        public static Question radioGroupQuestion(
                Context context, // NonNull?
                @NonNull String question,
                @NonNull HashMap<String, Pair<Language, Short>> answers
        )
        {
            RadioGroup radioGroup = new RadioGroup(context);

            TextView label = new TextView(context);
            label.setText(question);

            radioGroup.addView(label);

            answers.forEach(
                    (lbl, couple) ->
                    {
                        RadioButton button = new RadioButton(context);
                        button.setText(lbl);
                        radioGroup.addView(button);
                    }
            );


            return new Question(radioGroup, answers.values());
        }

        @NonNull
        public View getComponent()
        {
            return this.target;
        }

        @NonNull
        public Boolean[] getAnswers()
        {
            if (this.target instanceof RadioGroup)
            {
                return null;
            }
        }
    }


    public GenericQuestionActivity(@NonNull Question question)
    {
        HashMap<String, Pair<Language, Short>> answers = new HashMap<>();
        answers.put("A", new Pair<>(Language.Malboge, (short) 1));
        answers.put("B", new Pair<>(Language.Java, (short) 2));
        answers.put("C", new Pair<>(Language.CPP, (short) 3));

        this.question = Question.radioGroupQuestion(
                getBaseContext(),
                "A, B, ou C ?",
                answers
        );


    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_generic_question); // Ok ou pas ?

    }
}
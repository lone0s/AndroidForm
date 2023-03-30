package com.example.androidform.questions.activities.generics.man_made;

import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import com.example.androidform.R;
import com.example.androidform.Template;
import com.example.androidform.core.Language;
import com.example.androidform.questions.activities.generics.BSQ_YesOrNo;

public class MCQ_Liking extends Template
{

    public MCQ_Liking() {
        super(R.layout.mcq_liking);
    }

    @Override
    protected boolean canClickNextButton() {
        return ((CheckBox) this.findViewById(R.id.MCQ_A_history)).isChecked() ||
                ((CheckBox) this.findViewById(R.id.MCQ_A_sand)).isChecked() ||
                ((CheckBox) this.findViewById(R.id.MCQ_A_snake)).isChecked() ||
                ((CheckBox) this.findViewById(R.id.MCQ_A_suffer)).isChecked()
        ;
    }

    @NonNull
    @Override
    protected CharSequence onInvalidFormToastText() {
        return "Why are you here, if you don't even like suffering?";
    }

    @Override
    protected void nextButtonAction(View evt) {

        int[] answerScores = new int[11];

        if(((CheckBox) this.findViewById(R.id.MCQ_A_history)).isChecked())
        {
            answerScores[Language.Caml.toInt()] = 1;
            answerScores[Language.Haskell.toInt()] = 1;
        }
        if(((CheckBox) this.findViewById(R.id.MCQ_A_sand)).isChecked())
        {
            answerScores[Language.Caml.toInt()] += 1;
            answerScores[Language.Java.toInt()] += 1;
            answerScores[Language.JS.toInt()] += 1;
        }

        if(((CheckBox) this.findViewById(R.id.MCQ_A_snake)).isChecked())
        {
            answerScores[Language.Python.toInt()] += 1;
            answerScores[Language.PHP.toInt()] += 1;
            answerScores[Language.JS.toInt()] += 1;
        }

        if(((CheckBox) this.findViewById(R.id.MCQ_A_suffer)).isChecked())
        {
            answerScores[Language.Python.toInt()] += 1;
            answerScores[Language.PHP.toInt()] += 1;
            answerScores[Language.JS.toInt()] += 1;
            answerScores[Language.Rust.toInt()] += 1;
            answerScores[Language.Malboge.toInt()] += 1;
        }

        this.data.addScore(answerScores); // Set scores to add

        this.startActivity(this, BSQ_YesOrNo.class);
    }
}

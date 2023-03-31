package com.example.androidform.questions.activities.generics.man_made;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import com.example.androidform.R;
import com.example.androidform.Template;
import com.example.androidform.core.Language;
import com.example.androidform.questions.activities.generics.BSQ_YesOrNo;

public final class MCQ_Liking_Dislike extends Template
{

    public MCQ_Liking_Dislike() {
        super(R.layout.mcq_liking_dislike);
    }

    private void MCQLikingOnCreateHook()
    {

    }
    private void MCQDislikeOnCreate()
    {
        this.findViewById(R.id.MCQ_Dislike_A_none).setOnClickListener(
                (evt) -> this.MCQDislikeReset()
        );

        this.findViewById(R.id.MCQ_Dislike_A_life).setOnClickListener(
                evt -> ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_none)).setChecked(false)
        );
        this.findViewById(R.id.MCQ_Dislike_A_rust).setOnClickListener(
                evt -> ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_none)).setChecked(false)
        );

        this.findViewById(R.id.MCQ_Dislike_A_ugly).setOnClickListener(
                evt ->
                {
                    ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_beauty)).setChecked(false);
                    ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_none)).setChecked(false);
                }
        );
        this.findViewById(R.id.MCQ_Dislike_A_beauty).setOnClickListener(
                evt ->
                {
                    ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_ugly)).setChecked(false);
                    ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_none)).setChecked(false);
                }
        );
    }

    private void MCQDislikeReset()
    {
        ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_beauty)).setChecked(false);
        ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_ugly)).setChecked(false);
        ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_life)).setChecked(false);
        ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_rust)).setChecked(false);
    }

    @Override
    protected void onCreateHook(Bundle savedInstanceState) {
        this.MCQLikingOnCreateHook();
        this.MCQDislikeOnCreate();
    }

    @Override
    protected boolean canClickNextButton() {
        return this.MCQLikingAnswered() && this.MCQDislikeAnswered();
    }

    private boolean MCQLikingAnswered()
    {
        return ((CheckBox) this.findViewById(R.id.MCQ_Liking_A_history)).isChecked() ||
                ((CheckBox) this.findViewById(R.id.MCQ_Liking_A_sand)).isChecked() ||
                ((CheckBox) this.findViewById(R.id.MCQ_Liking_A_snake)).isChecked() ||
                ((CheckBox) this.findViewById(R.id.MCQ_Liking_A_suffer)).isChecked()
        ;
    }
    private boolean MCQDislikeAnswered()
    {
        return ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_beauty)).isChecked() ||
                ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_ugly)).isChecked() ||
                ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_life)).isChecked() ||
                ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_rust)).isChecked() ||
                ((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_none)).isChecked()
        ;
    }

    @NonNull
    @Override
    protected CharSequence onInvalidFormToastText() {
        if (!this.MCQLikingAnswered() && !this.MCQDislikeAnswered())
        {
            return this.getResources().getString(R.string.mcq_liking_activity_error_toast);
        }
        if(!this.MCQDislikeAnswered())
        {
            return this.getResources().getString(R.string.Dislike_error_toast);
        }
        return this.getResources().getString(R.string.Liking_error_toast);
    }

    @Override
    protected void nextButtonAction(View evt) {

        int[] answerScores = new int[11];

        // MCQ_Liking
        if(((CheckBox) this.findViewById(R.id.MCQ_Liking_A_history)).isChecked())
        {
            answerScores[Language.Caml.toInt()] += 1;
            answerScores[Language.Haskell.toInt()] += 1;
        }
        if(((CheckBox) this.findViewById(R.id.MCQ_Liking_A_sand)).isChecked())
        {
            answerScores[Language.Caml.toInt()] += 1;
            answerScores[Language.Java.toInt()] += 1;
            answerScores[Language.JS.toInt()] += 1;
        }

        if(((CheckBox) this.findViewById(R.id.MCQ_Liking_A_snake)).isChecked())
        {
            answerScores[Language.Python.toInt()] += 1;
            answerScores[Language.PHP.toInt()] += 1;
            answerScores[Language.JS.toInt()] += 1;
        }

        if(((CheckBox) this.findViewById(R.id.MCQ_Liking_A_suffer)).isChecked())
        {
            answerScores[Language.Python.toInt()] += 1;
            answerScores[Language.PHP.toInt()] += 1;
            answerScores[Language.JS.toInt()] += 1;
            answerScores[Language.Rust.toInt()] += 1;
            answerScores[Language.Malboge.toInt()] += 1;
        }

        // MCQ_Dislike
        if(((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_none)).isChecked())
        {
            answerScores[Language.PHP.toInt()] += 1;
            answerScores[Language.Python.toInt()] += 1;
            answerScores[Language.JS.toInt()] += 1;
        }
        else
        {
            if(((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_life)).isChecked())
            {
                answerScores[Language.Malboge.toInt()] += 1;
                answerScores[Language.PHP.toInt()] += 1;
                answerScores[Language.JS.toInt()] += 1;
                answerScores[Language.Caml.toInt()] += 1;
                answerScores[Language.Rust.toInt()] += 1;
                answerScores[Language.Java.toInt()] += 1;
            }

            if(((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_beauty)).isChecked())
            {
                answerScores[Language.Java.toInt()] += 1;
                answerScores[Language.Haskell.toInt()] += 1;
            }
            else if(((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_ugly)).isChecked())
            {
                answerScores[Language.Rust.toInt()] += 1;
                answerScores[Language.CPP.toInt()] += 1;
                answerScores[Language.CS.toInt()] += 1;
                answerScores[Language.Caml.toInt()] += 1;
            }

            if(((CheckBox) this.findViewById(R.id.MCQ_Dislike_A_rust)).isChecked())
            {
                answerScores[Language.Rust.toInt()] += 1;
            }
        }

        // Persisting data
        this.data.addScore(answerScores); // Set scores to add

        this.startActivity(this, UCQ_YoN_Boat.class);
    }
}

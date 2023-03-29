package com.example.androidform.questions.lib;

import android.view.View;

import androidx.annotation.NonNull;

public abstract class Question<AnswerType>
{
    @NonNull
    protected final View target;

    protected Question(
            @NonNull final View target
    ) // Choix du type numérique des poids arbitraire
    {
        super();

        this.target = target;
    }

    @NonNull
    public View getComponent()
    {
        return this.target;
    }

    @NonNull
    public abstract AnswerType getAnswer();
}
package com.example.androidform.questions.lib;

import android.util.Pair;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.androidform.core.Language;

import java.util.Collection;

/**
 * TODO : Extend to InputTexts & Sliders
 */
public abstract class Question<ReturnType>
{
    @NonNull
    protected final View target;

//   @NonNull
    protected final Collection<Pair<Language, Short>> answers;


    protected Question(
            @NonNull final View target,
            @NonNull final Collection<Pair<Language, Short>> answers
    ) // Choix du type numérique des poids arbitraire
    {
        super();

        this.target = target;
        this.answers = answers;
    }

    @NonNull
    public View getComponent()
    {
        return this.target;
    }

    @NonNull
    public abstract ReturnType getAnsweredText();
}
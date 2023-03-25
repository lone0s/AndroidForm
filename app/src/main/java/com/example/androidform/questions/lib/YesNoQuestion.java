package com.example.androidform.questions.lib;

import android.content.Context;
import android.util.Pair;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.androidform.core.Language;

import java.util.Collection;
import java.util.HashMap;

public class YesNoQuestion extends Question<Boolean>
{

    protected YesNoQuestion(@NonNull View target, @NonNull Collection<Pair<Language, Short>> answers) {
        super(target, answers);
    }

    @NonNull
    public static YesNoQuestion build(
            Context context,
            @NonNull String question,
            @NonNull HashMap<String, Pair<Language, Short>> answers
    )
    {
        return null;
    }

    @NonNull
    @Override
    public Boolean getAnswer() {
        return null;
    }
}

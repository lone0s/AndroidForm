package com.example.androidform.questions.lib;

import android.util.Pair;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.androidform.core.Language;

import java.util.Collection;
import java.util.Optional;

public class SpinnerQuestion extends Question<Short>{
    protected SpinnerQuestion(@NonNull View target, @NonNull Collection<Pair<Language, Short>> answers) {
        super(target, answers);
    }

    @NonNull
    @Override
    public Short getAnsweredText() {
        return null;
    }
}

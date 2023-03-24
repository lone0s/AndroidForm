package com.example.androidform.questions.lib;

import android.util.Pair;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.androidform.core.Language;

import java.util.Collection;
import java.util.Optional;

public class SliderQuestion extends Question{
    protected SliderQuestion(@NonNull View target, @NonNull Collection<Pair<Language, Short>> answers) {
        super(target, answers);
    }

    @NonNull
    @Override
    public Optional<String> getAnsweredText() {
        return Optional.empty();
    }
}

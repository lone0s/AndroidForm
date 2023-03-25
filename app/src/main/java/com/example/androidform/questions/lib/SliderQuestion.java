package com.example.androidform.questions.lib;

import android.util.Pair;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.androidform.core.Language;

import java.util.Collection;
import java.util.Optional;

public class SliderQuestion extends Question<Integer>{
    protected SliderQuestion(@NonNull View target, @NonNull Collection<String> answers) {
        super(target);
    }

    @NonNull
    @Override
    public Integer getAnswer() {
        return null;
    }
}

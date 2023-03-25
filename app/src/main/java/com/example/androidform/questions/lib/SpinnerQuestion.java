package com.example.androidform.questions.lib;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import com.example.androidform.core.Language;

import java.util.HashMap;

public class SpinnerQuestion extends Question<Short>{
    protected SpinnerQuestion(@NonNull View target) {
        super(target);
    }

    @NonNull
    public static SpinnerQuestion build(
            Context context,
            @NonNull String question,
            @NonNull HashMap<String, Pair<Language, Short>> answers
    )
    {
        return null;
    }

    @NonNull
    @Override
    public Short getAnswer() {
        return null;
    }
}

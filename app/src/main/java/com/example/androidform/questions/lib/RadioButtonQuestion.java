package com.example.androidform.questions.lib;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.androidform.core.Language;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

public class RadioButtonQuestion extends Question<Short> {

    private RadioButtonQuestion(RadioGroup radioGroup, Collection<Pair<Language, Short>> values) {
        super((View) radioGroup, values);
    }

    public static RadioButtonQuestion build(
            Context context,
            @NonNull
                    String question,
            @NonNull
                    HashMap<String, Pair<Language, Short>> answers
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


        return new RadioButtonQuestion(radioGroup, answers.values());
    }

    @NonNull
    @Override
    public Short getAnsweredText() {
        // TODO
        return null;
    }
}

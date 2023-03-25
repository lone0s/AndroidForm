package com.example.androidform.questions.lib;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.androidform.core.Language;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class RadioButtonQuestion extends Question<Short> {

    private final List<RadioButton> answers;

    private RadioButtonQuestion(@NonNull RadioGroup radioGroup, @NonNull final Collection<RadioButton> radiobuttons) {
        super((View) radioGroup);
        this.answers = (List<RadioButton>) radiobuttons;
    }

    @NonNull
    public static RadioButtonQuestion build(
            Context context,
            @NonNull String question,
            @NonNull HashMap<String, Pair<Language, Short>> answers
    )
    {
        RadioGroup radioGroup = new RadioGroup(context);

        TextView label = new TextView(context);
        label.setText(question);

        radioGroup.addView(label);

        List<RadioButton> buttons = new ArrayList<>();

        answers.forEach(
            (lbl, couple) ->
            {
                RadioButton button = new RadioButton(context);
                button.setText(lbl);
                radioGroup.addView(button);

                buttons.add(button);
            }
        );


        return new RadioButtonQuestion(radioGroup, buttons);
    }

    @NonNull
    @Override
    public Short getAnswer() {
        if (!((RadioButton) this.target).isChecked()) return -1;

        Short i = 0;
        for (RadioButton answer : this.answers) {
            if (answer.isChecked()) return i;

            i++;
        }

        throw new Error("Dead code reached");
    }
}
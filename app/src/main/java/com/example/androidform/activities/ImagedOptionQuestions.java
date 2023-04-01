package com.example.androidform.activities;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.androidform.R;
import com.example.androidform.Template;
import com.example.androidform.core.Language;

public class ImagedOptionQuestions extends Template {

    private ImageView tekken;
    private ImageView streetFighter;
    private boolean tekkenSelected;
    private boolean streetFighterSelected;

    public ImagedOptionQuestions() {
        super(R.layout.activity_imaged_option_questions);
    }

    public void onCreateHook(Bundle savedInstanceState) {
        tekken = findViewById(R.id.tekkenImg);
        streetFighter = findViewById(R.id.sfImg);
        tekkenSelected = false;
        streetFighterSelected = false;

        tekken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tekkenSelected) {
                    tekkenSelected = false;
                    tekken.setBackground(null);
                } else {
                    if (streetFighterSelected) {
                        Toast.makeText(ImagedOptionQuestions.this, R.string.img_double_select_toast_error, Toast.LENGTH_SHORT).show();
                        streetFighter.setBackground(null);
                        streetFighterSelected = false;
                    }
                    tekkenSelected = true;
                    tekken.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.image_frame,null));
                }
            }
        });

        streetFighter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (streetFighterSelected) {
                    streetFighterSelected = false;
                    streetFighter.setBackground(null);
                } else {
                    if (tekkenSelected) {
                        Toast.makeText(ImagedOptionQuestions.this, R.string.img_double_select_toast_error, Toast.LENGTH_SHORT).show();
                        tekken.setBackground(null);
                        tekkenSelected = false;
                    }
                    streetFighterSelected = true;
                    streetFighter.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.image_frame,null));
                }
            }
        });
    }

    @Override
    protected boolean canClickNextButton() {
        return tekkenSelected || streetFighterSelected;
    }

    @NonNull
    @Override
    protected CharSequence onInvalidFormToastText() {
        return getString(R.string.img_no_select_toast);
    }

    @Override
    protected void nextButtonAction(View evt) {
        int[] answerScores = new int[11];
        if (tekkenSelected) {
            answerScores[Language.Malboge.toInt()]++;
            answerScores[Language.Haskell.toInt()]++;
            answerScores[Language.Rust.toInt()]++;
            answerScores[Language.CS.toInt()]++;
            answerScores[Language.R.toInt()]++;
        }
        else {
            answerScores[Language.Java.toInt()]++;
            answerScores[Language.Python.toInt()]++;
            answerScores[Language.CPP.toInt()]++;
            answerScores[Language.PHP.toInt()]++;
            answerScores[Language.JS.toInt()]++;
            answerScores[Language.Caml.toInt()]++;
        }
        this.data.addScore(answerScores);
        this.startActivity(this, ImagedOptionQuestions2.class);
    }
}
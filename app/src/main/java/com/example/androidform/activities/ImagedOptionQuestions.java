package com.example.androidform.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.androidform.R;
import com.example.androidform.Template;

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
                    tekken.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                } else {
                    if (streetFighterSelected)
                        Toast.makeText(ImagedOptionQuestions.this, R.string.img_select_toast_error, Toast.LENGTH_SHORT).show();
                    else {
                        tekkenSelected = true;
                        tekken.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }
                }
            }
        });

        streetFighter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (streetFighterSelected) {
                    streetFighterSelected = false;
                    streetFighter.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                } else {
                    if (tekkenSelected)
                        Toast.makeText(ImagedOptionQuestions.this, R.string.img_select_toast_error, Toast.LENGTH_SHORT).show();
                    else {
                        streetFighterSelected = true;
                        streetFighter.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }
                }
            }
        });
    }

    @Override
    protected boolean canClickNextButton() {
        return false;
    }

    @NonNull
    @Override
    protected CharSequence onInvalidFormToastText() {
        return null;
    }

    @Override
    protected void nextButtonAction(View evt) {

    }
}
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
import com.example.androidform.core.Language;

public class ImagedOptionQuestions2 extends Template {

    private ImageView matrix;
    private ImageView mrRobot;
    private boolean matrixSelected;
    private boolean mrRobotSelected;


    public ImagedOptionQuestions2() {
        super(R.layout.activity_imaged_option_questions2);
    }

    public void onCreateHook(Bundle savedInstanceState) {
        this.matrix = findViewById(R.id.matrixImg);
        this.mrRobot = findViewById(R.id.mrrobotImg);
        this.matrixSelected = false;
        this.mrRobotSelected = false;
        this.matrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (matrixSelected) {
                    matrixSelected = false;
                    matrix.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                } else {
                    if (mrRobotSelected) {
                        Toast.makeText(ImagedOptionQuestions2.this, R.string.img_double_select_toast_error, Toast.LENGTH_SHORT).show();
                        mrRobot.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                        mrRobotSelected = false;
                    }
                    matrixSelected = true;
                    matrix.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                }
            }
        });
        this.mrRobot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mrRobotSelected) {
                    mrRobotSelected = false;
                    mrRobot.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                } else {
                    if (matrixSelected) {
                        Toast.makeText(ImagedOptionQuestions2.this, R.string.img_double_select_toast_error, Toast.LENGTH_SHORT).show();
                        matrix.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                        matrixSelected = false;
                    }
                    mrRobotSelected = true;
                    mrRobot.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                }
            }
        });
    }

    @Override
    protected boolean canClickNextButton() {
        return matrixSelected || mrRobotSelected;
    }

    @NonNull
    @Override
    protected CharSequence onInvalidFormToastText() {
        return getString(R.string.img_no_select_toast);
    }

    @Override
    protected void nextButtonAction(View evt) {
        int[] answerScores = new int[11];
        if (matrixSelected) {
            answerScores[Language.CPP.toInt()]++;
            answerScores[Language.Haskell.toInt()]++;
            answerScores[Language.Caml.toInt()]++;
            answerScores[Language.PHP.toInt()]++;
            answerScores[Language.R.toInt()]++;
        }
        else {
            answerScores[Language.Java.toInt()]++;
            answerScores[Language.Python.toInt()]++;
            answerScores[Language.JS.toInt()]++;
            answerScores[Language.Malboge.toInt()]++;
            answerScores[Language.CS.toInt()]++;
            answerScores[Language.Rust.toInt()]++;
        }
        this.data.addScore(answerScores);
        this.startActivity(this,ImagedOptionQuestions3.class);
    }
}
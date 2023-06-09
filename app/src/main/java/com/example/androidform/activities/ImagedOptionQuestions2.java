package com.example.androidform.activities;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

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
                    matrix.setBackground(null);
                } else {
                    if (mrRobotSelected) {
                        Toast.makeText(ImagedOptionQuestions2.this, R.string.img_double_select_toast_error, Toast.LENGTH_SHORT).show();
                        mrRobot.setBackground(null);
                        mrRobotSelected = false;
                    }
                    matrixSelected = true;
                    matrix.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.image_frame,null));
                }
            }
        });
        this.mrRobot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mrRobotSelected) {
                    mrRobotSelected = false;
                    mrRobot.setBackground(null);
                } else {
                    if (matrixSelected) {
                        Toast.makeText(ImagedOptionQuestions2.this, R.string.img_double_select_toast_error, Toast.LENGTH_SHORT).show();
                        matrix.setBackground(null);
                        matrixSelected = false;
                    }
                    mrRobotSelected = true;
                    mrRobot.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.image_frame,null));
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
            answerScores[Language.Malbolge.toInt()]++;
            answerScores[Language.CS.toInt()]++;
            answerScores[Language.Rust.toInt()]++;
        }
        this.data.addScore(answerScores);
        this.startActivity(this,ImagedOptionQuestions3.class);
    }
}
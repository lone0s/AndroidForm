package com.example.androidform.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.androidform.R;
import com.example.androidform.Template;

public class ImagedOptionQuestions3 extends Template {

    private ImageView github;
    private ImageView gitlab;
    private boolean githubSelected;
    private boolean gitlabSelected;


    public ImagedOptionQuestions3() {
        super(R.layout.activity_imaged_option_questions3);
    }

    public void onCreateHook(Bundle savedInstanceState) {
        this.github = findViewById(R.id.githubImg);
        this.gitlab = findViewById(R.id.gitlabImg);
        this.githubSelected = false;
        this.gitlabSelected = false;
        this.github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (githubSelected) {
                    githubSelected = false;
                    github.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                } else {
                    if (gitlabSelected) {
                        Toast.makeText(ImagedOptionQuestions3.this, R.string.img_double_select_toast_error, Toast.LENGTH_SHORT).show();
                        gitlab.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                        gitlabSelected = false;
                    }
                    githubSelected = true;
                    github.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                }
            }
        });
        this.gitlab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gitlabSelected) {
                    gitlabSelected = false;
                    gitlab.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                } else {
                    if (githubSelected) {
                        Toast.makeText(ImagedOptionQuestions3.this, R.string.img_double_select_toast_error, Toast.LENGTH_SHORT).show();
                        github.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                        githubSelected = false;
                    }
                    gitlabSelected = true;
                    gitlab.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                }
            }
        });
    }

    @Override
    protected boolean canClickNextButton() {
        return githubSelected || gitlabSelected;
    }

    @NonNull
    @Override
    protected CharSequence onInvalidFormToastText() {
        return getString(R.string.img_no_select_toast);
    }

    @Override
    protected void nextButtonAction(View evt) {

    }
}
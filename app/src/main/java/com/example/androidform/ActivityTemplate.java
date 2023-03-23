package com.example.androidform;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityTemplate extends AppCompatActivity {

    private final int layoutId;
    public ActivityTemplate(int id) {
        this.layoutId = id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
    }
}

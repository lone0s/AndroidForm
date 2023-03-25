package com.example.androidform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public abstract class Template extends AppCompatActivity {
    private final int layoutId;

    public Template(int id) {
        this.layoutId = id;
    }

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);

        findViewById(R.id.beforeButton).setOnClickListener(this::backButtonEventListener);
        findViewById(R.id.nextButton).setOnClickListener(this::nextButtonEventListener);

    }

    protected abstract void backButtonEventListener(View evt);

    protected abstract void nextButtonEventListener(View evt);


    // Need onClickHandler pour next

    // Need onClickHandler pour before
}
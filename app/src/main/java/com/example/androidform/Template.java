package com.example.androidform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

    private void backButtonEventListener(View evt)
    {
        this.backButtonAction(evt);
    }
    private void nextButtonEventListener(View evt)
    {
        this.nextButtonAction(evt);
    }

    /**
     * Action to be performed when clicking the "Previous" button
     * */
    protected abstract void backButtonAction(View evt);
    /**
     * Action to be performed when clicking the "Next" button
     * */
    protected abstract void nextButtonAction(View evt);


    // Need onClickHandler pour next

    // Need onClickHandler pour before
}
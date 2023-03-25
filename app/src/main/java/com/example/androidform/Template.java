package com.example.androidform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public abstract class Template extends AppCompatActivity {
    private final int layoutId;

    private Button beforeButton;
    private Button nextButton;

    public Template(int id) {
        this.layoutId = id;
    }

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);

        beforeButton = findViewById(R.id.beforeButton);
        nextButton = findViewById(R.id.nextButton);

        beforeButton.setOnClickListener(this::backButtonEventListener);
        nextButton.setOnClickListener(this::nextButtonEventListener);
    }

    protected abstract void backButtonEventListener(View evt);

    protected abstract void nextButtonEventListener(View evt);


    // Need onClickHandler pour next

    // Need onClickHandler pour before
}
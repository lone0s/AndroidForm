package com.example.androidform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Template extends AppCompatActivity {
    private final int layoutId;

    private Button beforeButton;
    private Button nextButton;

    public Template(int id) {
        this.layoutId = id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        beforeButton = findViewById(R.id.beforeButton);
        nextButton = findViewById(R.id.nextButton);
    }

    // Need onClickHandler pour next

    // Need onClickHandler pour before
}
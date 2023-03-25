package com.example.androidform.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.androidform.R;

public class MainActivity extends AppCompatActivity {

    private static final String LOGGER_TAG = "Main menu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findViewById(R.id.startButton).setOnClickListener(
                (evt) ->
                {
                    Log.d(MainActivity.LOGGER_TAG, "Start button clicked");
                    Intent intent = new Intent(this, GeneralQuestions1.class);

                    this.startActivity(intent);
                }
        );
    }
}
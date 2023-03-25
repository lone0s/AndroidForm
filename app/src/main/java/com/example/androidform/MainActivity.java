package com.example.androidform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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
                    Intent intent = new Intent(this, GeneralInformation.class);

                    this.startActivity(intent);
                }
        );
    }
}
package com.example.androidform.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.androidform.DataContainer;
import com.example.androidform.R;

public class MainActivity extends AppCompatActivity {
    private boolean isFirstLoad = true;
    private static final String LOGGER_TAG = "Main menu";
    @NonNull
    private EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.nameInput = findViewById(R.id.nameInput);
        this.findViewById(R.id.startButton).setOnClickListener(
                (evt) ->
                {
                    Log.d(MainActivity.LOGGER_TAG, "Start button clicked");
                    Intent intent = new Intent(this, GeneralQuestions1.class);

                    String name = this.nameInput.getText().toString();
                    if (name.isEmpty())
                        name = "1337";
                    Log.d(MainActivity.LOGGER_TAG, "Starting activity with name: " + name);

                    intent.putExtra("scores", (Parcelable) new DataContainer(this.nameInput.getText().toString()));
                    this.startActivity(intent);
                }
        );

        this.nameInput.setOnClickListener(view -> {
            if (isFirstLoad) {
                nameInput.setText("");
                isFirstLoad = false;
            }
        });
    }
}
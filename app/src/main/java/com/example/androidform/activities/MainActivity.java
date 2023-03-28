package com.example.androidform.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.androidform.R;

public class MainActivity extends AppCompatActivity {
    private boolean isFirstLoad = true;
    private static final String LOGGER_TAG = "Main menu";
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
                    this.startActivity(intent);
                }
        );

        this.nameInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFirstLoad) {
                    nameInput.setText("");
                    isFirstLoad = false;
                }
            }
        });
        private void verifyData(){

        }
        private void saveData() {

        }
        private void loadData() {

        }
    }
}
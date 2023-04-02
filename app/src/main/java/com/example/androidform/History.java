package com.example.androidform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

       /* DataContainer[] dc = ((DataContainer[]) this.getIntent().getParcelableArrayExtra("scoresArray"));

        for (DataContainer dataContainer : dc)
        {
            // TODO :
            // - Creer un fragment representant un DataContainer
            // - Injecter le composant dans R.id.dataContainerContainer
        }*/

        this.findViewById(R.id.BackButton).setOnClickListener(
                (evt) -> this.finish()
        );
    }



}
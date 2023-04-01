package com.example.androidform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.androidform.core.Language;

public final class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        this.findViewById(R.id.exitButton).setOnClickListener(this::QuitButtonAction);
        this.findViewById(R.id.seeHistory).setOnClickListener(this::SeeHistoryButton);

        DataContainer dc = this.getIntent().getParcelableExtra("scores");
        int[] results = dc.getResults();

        this.saveResults(dc);
        Language winner = this.getResults(results);

        this.initView(winner);

    }

    private void initView(Language winner) {
        int languageNameResourceId;
        int imageResourceId;
        int languageDescResourceId;
        switch (winner)
        {
            case Rust:
                languageNameResourceId = R.string.RustName;
                imageResourceId = 0; // TODO
                languageDescResourceId = R.string.RustDesc;
                break;
            case Haskell:
                languageNameResourceId = R.string.HaskellName;
                imageResourceId = 0; // TODO
                languageDescResourceId = R.string.HaskellDesc;
                break;
            case Caml:
                languageNameResourceId = R.string.CamlName;
                imageResourceId = 0; // TODO
                languageDescResourceId = R.string.CamlDesc;
                break;
            case Malboge:
                languageNameResourceId = R.string.MalbogeName;
                imageResourceId = 0; // TODO
                languageDescResourceId = R.string.MalbogeDesc;
                break;
            case CPP:
                languageNameResourceId = R.string.CPPName;
                imageResourceId = 0; // TODO
                languageDescResourceId = R.string.CPPDesc;
                break;
            case Python:
                languageNameResourceId = R.string.PythonName;
                imageResourceId = 0; // TODO
                languageDescResourceId = R.string.PythonDesc;
                break;
            case R:
                languageNameResourceId = R.string.RName;
                imageResourceId = 0; // TODO
                languageDescResourceId = R.string.RDesc;
                break;
            case JS:
                languageNameResourceId = R.string.JSName;
                imageResourceId = 0; // TODO
                languageDescResourceId = R.string.JSDesc;
                break;
            case PHP:
                languageNameResourceId = R.string.PHPName;
                imageResourceId = 0; // TODO
                languageDescResourceId = R.string.PHPDesc;
                break;
            case Java:
                languageNameResourceId = R.string.JavaName;
                imageResourceId = 0; // TODO
                languageDescResourceId = R.string.JavaDesc;
                break;
            case CS:
                languageNameResourceId = R.string.CSName;
                imageResourceId = 0; // TODO
                languageDescResourceId = R.string.CSDesc;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + winner);
        }


        ((TextView) this.findViewById(R.id.LangageName)).setText(this.getResources().getString(languageNameResourceId));
        // TODO
        ((TextView) this.findViewById(R.id.LanguageDescription)).setText(this.getResources().getString(languageDescResourceId));
    }

    private Language getResults(int[] results)
    {
        // 2. Get Language with the best score
        // 3. Display Description, Image and name
        Language winner = Language.fromInt(0);
        int maxScore = results[0];
        for (int i = 0; i < results.length; i++)
        {
            int oldM = maxScore;
            maxScore = Math.max(maxScore, results[i]);

            if(oldM < maxScore)
            {
                winner = Language.fromInt(i);
            }
        }
        if (winner == null)
        {
            throw new Error("Dead code reached");
        }

        return winner;
    }

    private void saveResults(DataContainer dc)
    {

    }


    private void QuitButtonAction(View o)
    {
        this.finishAffinity(); // Kills the application
    }

    private void SeeHistoryButton(View o)
    {
        // Lancer une activite dediee
    }
}
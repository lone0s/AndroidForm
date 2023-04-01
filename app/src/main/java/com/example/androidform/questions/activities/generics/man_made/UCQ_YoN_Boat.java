package com.example.androidform.questions.activities.generics.man_made;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.NonNull;

import com.example.androidform.R;
import com.example.androidform.Template;
import com.example.androidform.activities.ImagedOptionQuestions;
import com.example.androidform.core.Language;

public class UCQ_YoN_Boat extends Template {
    public UCQ_YoN_Boat()
    {
        super(R.layout.ucq_yon_boat);
    }

    @Override
    protected void onCreateHook(Bundle savedInstanceState)
    {
        this.UCQYoNOnCreate();
        this.UCQBoatOnCreate();
    }
    private void UCQYoNOnCreate()
    {
        this.findViewById(R.id.UCQ_YesOrNo_A_no).setOnClickListener(
                (evt) ->
                {
                    ((RadioButton)this.findViewById(R.id.UCQ_YesOrNo_A_yes)).setChecked(false);
                    ((RadioButton)this.findViewById(R.id.UCQ_YesOrNo_A_rust)).setChecked(false);
                }
        );
        this.findViewById(R.id.UCQ_YesOrNo_A_yes).setOnClickListener(
                (evt) ->
                {

                    ((RadioButton)this.findViewById(R.id.UCQ_YesOrNo_A_no)).setChecked(false);
                    ((RadioButton)this.findViewById(R.id.UCQ_YesOrNo_A_rust)).setChecked(false);
                }
        );
        this.findViewById(R.id.UCQ_YesOrNo_A_rust).setOnClickListener(
                (evt) ->
                {
                    ((RadioButton)this.findViewById(R.id.UCQ_YesOrNo_A_yes)).setChecked(false);
                    ((RadioButton)this.findViewById(R.id.UCQ_YesOrNo_A_no)).setChecked(false);
                }
        );
    }
    private void UCQBoatOnCreate()
    {
        this.findViewById(R.id.UCQ_Boat_A_boat).setOnClickListener(
                (evt) -> this.cleanUCQBoat(R.id.UCQ_Boat_A_boat)
        );
        this.findViewById(R.id.UCQ_Boat_A_notboat).setOnClickListener(
                (evt) -> this.cleanUCQBoat(R.id.UCQ_Boat_A_notboat)
        );
        this.findViewById(R.id.UCQ_Boat_A_pointer).setOnClickListener(
                (evt) -> this.cleanUCQBoat(R.id.UCQ_Boat_A_pointer)
        );
        this.findViewById(R.id.UCQ_Boat_A_rust).setOnClickListener(
                (evt) -> this.cleanUCQBoat(R.id.UCQ_Boat_A_rust)
        );
        this.findViewById(R.id.UCQ_Boat_A_wut).setOnClickListener(
                (evt) -> this.cleanUCQBoat(R.id.UCQ_Boat_A_wut)
        );
    }
    private void cleanUCQBoat(int ignored)
    {
        if(!(ignored == R.id.UCQ_Boat_A_boat)) ((RadioButton)this.findViewById(R.id.UCQ_Boat_A_boat)).setChecked(false);
        if(!(ignored == R.id.UCQ_Boat_A_notboat)) ((RadioButton)this.findViewById(R.id.UCQ_Boat_A_notboat)).setChecked(false);
        if(!(ignored == R.id.UCQ_Boat_A_pointer)) ((RadioButton)this.findViewById(R.id.UCQ_Boat_A_pointer)).setChecked(false);
        if(!(ignored == R.id.UCQ_Boat_A_rust)) ((RadioButton)this.findViewById(R.id.UCQ_Boat_A_rust)).setChecked(false);
        if(!(ignored == R.id.UCQ_Boat_A_wut)) ((RadioButton)this.findViewById(R.id.UCQ_Boat_A_wut)).setChecked(false);
    }

    @Override
    protected boolean canClickNextButton()
    {
        return this.UCQYoNAnswered() && this.UCQBoatAnswered();
    }
    private boolean UCQYoNAnswered()
    {
        return ((RadioButton)this.findViewById(R.id.UCQ_YesOrNo_A_no)).isChecked() ||
                ((RadioButton)this.findViewById(R.id.UCQ_YesOrNo_A_yes)).isChecked() ||
                ((RadioButton)this.findViewById(R.id.UCQ_YesOrNo_A_rust)).isChecked()
                ;
    }
    private boolean UCQBoatAnswered()
    {
        return ((RadioButton)this.findViewById(R.id.UCQ_Boat_A_boat)).isChecked() ||
                ((RadioButton)this.findViewById(R.id.UCQ_Boat_A_notboat)).isChecked() ||
                ((RadioButton)this.findViewById(R.id.UCQ_Boat_A_pointer)).isChecked() ||
                ((RadioButton)this.findViewById(R.id.UCQ_Boat_A_rust)).isChecked() ||
                ((RadioButton)this.findViewById(R.id.UCQ_Boat_A_wut)).isChecked()
        ;
    }

    @NonNull
    @Override
    protected CharSequence onInvalidFormToastText() {
        if (!this.UCQYoNAnswered() && !this.UCQBoatAnswered())
        {
            return this.getResources().getString(R.string.UCQ_YoN_Boat);
        }
        return this.getResources().getString(R.string.UCQ_YoN_Boat_bothEmpty);
    }

    @Override
    protected void nextButtonAction(View evt) {
        int[] answerScores = new int[11];

        // UCQ_YoN
        if(((RadioButton)this.findViewById(R.id.UCQ_YesOrNo_A_yes)).isChecked())
        {
            answerScores[Language.Caml.toInt()] += 1;
            answerScores[Language.Haskell.toInt()] += 1;
            answerScores[Language.JS.toInt()] += 1;
            answerScores[Language.PHP.toInt()] += 1;
            answerScores[Language.Python.toInt()] += 1;
            answerScores[Language.R.toInt()] += 1;
        }
        else if(((RadioButton)this.findViewById(R.id.UCQ_YesOrNo_A_no)).isChecked())
        {
            answerScores[Language.CPP.toInt()] += 1;
            answerScores[Language.CS.toInt()] += 1;
            answerScores[Language.Java.toInt()] += 1;
            answerScores[Language.Malbolge.toInt()] += 1;
            answerScores[Language.Rust.toInt()] += 1;
        }
        else // Answer: Rust.
        {
            answerScores[Language.Rust.toInt()] += 1;
        }

        // UCQ_Boat
        if(((RadioButton)this.findViewById(R.id.UCQ_Boat_A_boat)).isChecked())
        {
            answerScores[Language.Python.toInt()] += 1;
            answerScores[Language.JS.toInt()] += 1;
            answerScores[Language.PHP.toInt()] += 1;
            answerScores[Language.Java.toInt()] += 1;
            answerScores[Language.CS.toInt()] += 1;
        }
        else if(((RadioButton)this.findViewById(R.id.UCQ_Boat_A_notboat)).isChecked())
        {
            answerScores[Language.Caml.toInt()] += 1;
            answerScores[Language.CPP.toInt()] += 1;
        }
        else if(((RadioButton)this.findViewById(R.id.UCQ_Boat_A_pointer)).isChecked())
        {
            answerScores[Language.CPP.toInt()] += 1;
        }
        else if(((RadioButton)this.findViewById(R.id.UCQ_Boat_A_wut)).isChecked())
        {
            answerScores[Language.Python.toInt()] += 1;
            answerScores[Language.JS.toInt()] += 1;
            answerScores[Language.PHP.toInt()] += 1;
        }
        else // Answer: Rust.
        {
            answerScores[Language.Rust.toInt()] += 1;
        }

        // Persisting data
        this.data.addScore(answerScores); // Set scores to add

        this.startActivity(this, ImagedOptionQuestions.class);
    }
}

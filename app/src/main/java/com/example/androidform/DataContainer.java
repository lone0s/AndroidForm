package com.example.androidform;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Arrays;

public final class DataContainer implements Parcelable {

    /**
     * Use Language.XXX.toInt() to get a language's index
     */
    private final int[][] scores; // length = 11
    private final int currentQuestion;

    public DataContainer()
    {
        Log.d("DataContainer", "Creating new DataContainer");
        this.currentQuestion = -1;
        this.scores = new int[11][0];
    }

    public DataContainer(Parcel in)
    {
        Log.d("DataContainer", "Reading DataContainer from Parcel");

        this.currentQuestion = in.readInt();

        this.scores = new int[11][this.currentQuestion];
        //Log.d("DataContainer", String.valueOf(in.readInt()) + " " + this.currentQuestion);
        for (int i = 0; i < this.scores.length; i++)
        {
            in.readIntArray(this.scores[i]);
            this.scores[i] = Arrays.copyOf(this.scores[i], this.currentQuestion +1);
        }

        Log.d("DataContainer", "Retrieved data is #" + this.currentQuestion + " : " + Arrays.deepToString(this.scores));
    }

    /** Use Language.XXX.toInt() to get a language's index
     */
    public void addScore(@NonNull final int[] score)
    {
        assert score.length == 11;
        assert this.currentQuestion == this.scores[0].length -1;

        for (int i = 0; i < this.scores.length; i++) {
            Log.d("DataContainer", i + " | " + this.currentQuestion);
            this.scores[i][this.currentQuestion] = score[i];
        }
    }

    public int[][] getResults()
    {
        // Stream::reduce marche po
        return Arrays.copyOf(this.scores, this.scores.length);
    }


    /** Parcelable impl **/

    public static final Creator<DataContainer> CREATOR = new Creator<DataContainer>()
    {
        @Override
        public DataContainer createFromParcel(Parcel in)
        {
            return new DataContainer(in);
        }

        @Override
        public DataContainer[] newArray(int size)
        {
            return new DataContainer[size];
        }
    };

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        Log.d("DataContainer", "Writing DataContainer to Parcel");

        parcel.writeInt(this.currentQuestion +1);
        for (int[] score : this.scores) {
            parcel.writeIntArray(score);
        }
    }
}

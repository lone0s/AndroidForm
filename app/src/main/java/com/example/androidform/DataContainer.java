package com.example.androidform;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Arrays;

public final class DataContainer implements Parcelable {

    /**
     * length = 11;
     *
     * index 0 = rust
     * index 1 = haskell
     * index 2 = caml
     * index 3 = malboge
     * index 4 = cpp
     * index 5 = python
     * index 6 = r
     * index 7 = js
     * index 8 = php
     * index 9 = java
     * index 10 = cs
     */
    private final int[] scores; // length = 11

    public DataContainer()
    {
        Log.d("DataContainer", "Creating new DataContainer");
        this.scores = new int[11];
    }

    public DataContainer(Parcel in)
    {
        Log.d("DataContainer", "Reading DataContainer from Parcel");

        this.scores = new int[11];
        for (int i = 0; i < this.scores.length; i++)
        {
            this.scores[i] = in.readInt();
        }

        Log.d("DataContainer", "Retrieved data is " + Arrays.toString(this.scores));
    }

    /**
     * length = 11;
     *
     * index 0 = rust
     * index 1 = haskell
     * index 2 = caml
     * index 3 = malboge
     * index 4 = cpp
     * index 5 = python
     * index 6 = r
     * index 7 = js
     * index 8 = php
     * index 9 = java
     * index 10 = cs
     */
    public void addScore(@NonNull final int[] score)
    {
        assert score.length == 11;

        for (int i = 0; i < this.scores.length; i++) {
            this.scores[i] = score[i];
        }
    }

    public int[] getResults()
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

        for (int score : this.scores) {
            parcel.writeInt(score);
        }
    }
}

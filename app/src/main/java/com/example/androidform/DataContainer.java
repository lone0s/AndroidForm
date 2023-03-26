package com.example.androidform;

import android.os.Parcel;
import android.os.Parcelable;

public final class DataContainer implements Parcelable {
//    private @interface ParcelContent{}

    /**
     * length = 11;
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
    private final int[][] scores; // length = 11
    private final int questionIndex;
//    @ParcelContent private int[] rustScores;
//    @ParcelContent private int[] haskellScores;
//    @ParcelContent private int[] camlScores;
//    @ParcelContent private int[] malbogeScores;
//    @ParcelContent private int[] cppScores;
//    @ParcelContent private int[] pythonScores;
//    @ParcelContent private int[] rScores;
//    @ParcelContent private int[] jsScores;
//    @ParcelContent private int[] phpScores;
//    @ParcelContent private int[] javaScores;
//    @ParcelContent private int[] csScores;

    public DataContainer(Parcel in)
    {
        this.questionIndex = in.readInt() +1;
        this.scores = new int[11][this.questionIndex];
        for (int[] score : this.scores) {
            in.readIntArray(score);
        }
    }

    public void addScore(final int score) // Simplifier en addScore(final Langage lang, final short score) ?
    {
//        this.rustScores[this.rustScores.length -1] = score;
    }

    public short computeResults()
    {
        // Stream::reduce marche po
        int reduce = 0;
        for (Integer rustScore : this.scores[0]) {
            reduce = reduce + rustScore;
        }

        return (short) reduce;
    }


    /** Parcelable impl **/

    public static final Creator<DataContainer> CREATOR = new Creator<DataContainer>() {
        @Override
        public DataContainer createFromParcel(Parcel in) {
            return new DataContainer(in);
        }

        @Override
        public DataContainer[] newArray(int size) {
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
    }
}

package com.example.androidform;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Collection;

public class DataContainer implements Parcelable {

    // Des collections pour manage les retours en arriere
    private Collection<Short> rustScores;
    private Collection<Short> haskellScores;
    private Collection<Short> camlScores;
    private Collection<Short> malbogeScores;
    private Collection<Short> cppScores;
    private Collection<Short> pythonScores;
    private Collection<Short> rScores;
    private Collection<Short> jsScores;
    private Collection<Short> phpScores;
    private Collection<Short> javaScores;
    private Collection<Short> csScores;

    protected DataContainer(Parcel in) {
    }

    public void addRustScore(final short score) // Simplifier en addScore(final Langage lang, final short score) ?
    {
        this.rustScores.add(score);
    }

    public short computeResults()
    {
        // Stream::reduce marche po
        int reduce = 0;
        for (Short rustScore : this.rustScores) {
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}

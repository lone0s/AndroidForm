package com.example.androidform;

import android.os.Parcel;
import android.os.Parcelable;

public class DataContainer implements Parcelable {
    protected DataContainer(Parcel in) {
    }

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

package com.example.gio.testproject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gio on 2/28/2018.
 */

public class ItemObject implements Parcelable {
    private String contents;
    public ItemObject(String contents) {
        this.contents = contents;
    }
    public String getContents() {
        return contents;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.contents);
    }

    protected ItemObject(Parcel in) {
        this.contents = in.readString();
    }

    public static final Parcelable.Creator<ItemObject> CREATOR = new Parcelable.Creator<ItemObject>() {
        @Override
        public ItemObject createFromParcel(Parcel source) {
            return new ItemObject(source);
        }

        @Override
        public ItemObject[] newArray(int size) {
            return new ItemObject[size];
        }
    };
}

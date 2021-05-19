package com.peacecodes.countrylist.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Languages implements Parcelable {
    @SerializedName("iso639_1")
    private String firstLanguage;
    @SerializedName("iso639_2")
    private String secondLanguage;
    @SerializedName("name")
    private String languageName;
    @SerializedName("nativeName")
    private String languageNativeName;

    public Languages() {

    }

    public Languages(String firstLanguage, String secondLanguage, String languageName, String languageNativeName) {
        this.firstLanguage = firstLanguage;
        this.secondLanguage = secondLanguage;
        this.languageName = languageName;
        this.languageNativeName = languageNativeName;
    }
    private Languages (Parcel in){
        languageName = in.readString();
        languageNativeName = in.readString();
        firstLanguage = in.readString();
        secondLanguage = in.readString();
    }
    public static final Parcelable.Creator<Languages> CREATOR = new Creator<Languages>(){

        @Override
        public Languages createFromParcel(Parcel in) {
            return new Languages(in);
        }

        @Override
        public Languages[] newArray(int size) {
            return new Languages[size];
        }
    };

    public String getFirstLanguage() {
        return firstLanguage;
    }

    public String getSecondLanguage() {
        return secondLanguage;
    }

    public String getLanguageName() {
        return languageName;
    }

    public String getLanguageNativeName() {
        return languageNativeName;
    }

    @Override
    public String toString() {
        return "Languages{" +
                "firstLanguage='" + firstLanguage + '\'' +
                ", secondLanguage='" + secondLanguage + '\'' +
                ", languageName='" + languageName + '\'' +
                ", languageNativeName='" + languageNativeName + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstLanguage);
        dest.writeString(secondLanguage);
        dest.writeString(languageName);
        dest.writeString(languageNativeName);
    }
}

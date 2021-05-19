package com.peacecodes.countrylist.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Currencies implements Parcelable {
    @SerializedName("code")
    private String code;
    @SerializedName("name")
    private String name;
    @SerializedName("symbol")
    private String symbol;

    public Currencies(){

    }

    public Currencies(String code, String name, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    protected Currencies(Parcel in) {
        name = in.readString();
        code = in.readString();
        symbol = in.readString();
    }
    public static final Creator<Currencies> CREATOR = new Creator<Currencies>() {
        @Override
        public Currencies createFromParcel(Parcel in) {
                return new Currencies(in);
        }

        @Override
        public Currencies[] newArray(int size) {
            return new Currencies[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(code);
        dest.writeString(symbol);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}

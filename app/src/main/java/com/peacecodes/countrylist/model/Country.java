package com.peacecodes.countrylist.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Country implements Parcelable {

    @SerializedName("name")
    private String name;
    @SerializedName("capital")
    private String capital;
    @SerializedName("region")
    private String region;
    @SerializedName("flag")
    private String imageUrl;
    @SerializedName("population")
    private String population;
    @SerializedName("numericCode")
    private String numericCode;
    @SerializedName("nativeName")
    private String nativeName;
    @SerializedName("subregion")
    private String subRegion;
    @SerializedName("currencies")
    private List<Currencies> currency = new ArrayList<Currencies>();
    @SerializedName("languages")
    private List<Languages> languages = new ArrayList<Languages>();
    @SerializedName("timezones")
    private List<String> timeZones = new ArrayList<String>();
    @SerializedName("area")
    private String area;
    @SerializedName("callingCodes")
    private List<String> codes = new ArrayList<String>();

    public Country () {

    }

    public Country(String name, String capital, String region, String imageUrl, String population, String numericCode, String nativeName, String subRegion, List<Currencies> currency, List<Languages> languages, List<String> timeZones, String area, List<String> codes) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.imageUrl = imageUrl;
        this.population = population;
        this.numericCode = numericCode;
        this.nativeName = nativeName;
        this.subRegion = subRegion;
        this.currency = currency;
        this.languages = languages;
        this.timeZones = timeZones;
        this.area = area;
        this.codes = codes;
    }

    protected Country(Parcel in) {
        name = in.readString();
        capital = in.readString();
        region = in.readString();
        imageUrl = in.readString();
        population = in.readString();
        subRegion = in.readString();
        nativeName = in.readString();
        numericCode = in.readString();
        area = in.readString();
        in.readList(currency, Currencies.class.getClassLoader());
        in.readList(languages, Languages.class.getClassLoader());
        in.readList(timeZones, String.class.getClassLoader());
        in.readList(codes, String.class.getClassLoader());
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public String getName() {
        return name;
    }

    public List<String> getTimeZones() {
        return timeZones;
    }

    public String getArea() {
        return area;
    }

    public List<String> getCodes() {
        return codes;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPopulation() {
        return population;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getSubRegion() {
        return subRegion;
    }

    public List<Currencies> getCurrency() {
        return currency;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", region='" + region + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", population='" + population + '\'' +
                ", numericCode='" + numericCode + '\'' +
                ", nativeName='" + nativeName + '\'' +
                ", subRegion='" + subRegion + '\'' +
                ", currency=" + currency +
                ", languages=" + languages +
                ", timeZones=" + timeZones +
                ", area='" + area + '\'' +
                ", codes=" + codes +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(capital);
        dest.writeString(region);
        dest.writeString(imageUrl);
        dest.writeString(population);
        dest.writeString(subRegion);
        dest.writeString(nativeName);
        dest.writeString(numericCode);
        dest.writeString(area);
        dest.writeList(currency);
        dest.writeList(languages);
        dest.writeList(timeZones);
        dest.writeList(codes);
    }
}


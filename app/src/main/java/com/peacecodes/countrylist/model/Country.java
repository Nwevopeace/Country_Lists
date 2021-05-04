package com.peacecodes.countrylist.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
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

//    @SerializedName("currencies")
//    private List<String> currency = new ArrayList<String>();
//    @SerializedName("code")
//    private String code;
//    @SerializedName("name")
//    private String Name;
//    @SerializedName("symbol")
//    private String symbol;
//    @SerializedName("languages")
//    private List<String> language = new ArrayList<String>();
//    @SerializedName("iso639_1")
//    private String firstLanguage;
//    @SerializedName("iso639_2")
//    private String secondLanguage;
//    @SerializedName("name")
//    private String languageName;
//    @SerializedName("nativeName")
//    private String languageNativeName;
//    @SerializedName("timezones")
//    private List<String> timeZones = new ArrayList<String>();
//    @SerializedName("0")
//    private String time;
//    @SerializedName("area")
//    private String area;
//    @SerializedName("callingCodes")
//    private List<String> codes = new ArrayList<String>();
//    @SerializedName("0")
//    private String number;

    public Country () {

    }

    public Country(String name, String capital, String region, String imageUrl, String population, String numericCode, String nativeName, String subRegion) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.imageUrl = imageUrl;
        this.population = population;
        this.numericCode = numericCode;
        this.nativeName = nativeName;
        this.subRegion = subRegion;
//        this.currency = currency;
    }


    //        this.code = code;
//        Name = name1;
//        this.symbol = symbol;
//        this.language = language;
//        this.firstLanguage = firstLanguage;
//        this.secondLanguage = secondLanguage;
//        this.languageName = languageName;
//        this.languageNativeName = languageNativeName;
//        this.timeZones = timeZones;
//        this.time = time;
//        this.area = area;
//        this.codes = codes;
//        this.number = number;


    protected Country(Parcel in) {
        name = in.readString();
        capital = in.readString();
        region = in.readString();
        imageUrl = in.readString();
        population = in.readString();
        subRegion = in.readString();
        nativeName = in.readString();
        numericCode = in.readString();
//        currency = Collections.singletonList(in.readString());
//        code = in.readString();
//        Name = in.readString();
//        symbol = in.readString();
//        language = Collections.singletonList(in.readString());
//        firstLanguage = in.readString();
//        secondLanguage = in.readString();
//        languageName = in.readString();
//        languageNativeName = in.readString();
//        timeZones = Collections.singletonList(in.readString());
//        time = in.readString();
//        area = in.readString();
//        codes = Collections.singletonList(in.readString());
//        number = in.readString();
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

//    public String getSymbol() {
//        return symbol;
//    }
//
//    public List<String> getLanguage() {
//        return language;
//    }
//
//    public String getFirstLanguage() {
//        return firstLanguage;
//    }
//
//    public String getSecondLanguage() {
//        return secondLanguage;
//    }
//
//    public String getLanguageName() {
//        return languageName;
//    }
//
//    public String getLanguageNativeName() {
//        return languageNativeName;
//    }
//
//    public List<String> getTimeZones() {
//        return timeZones;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public String getArea() {
//        return area;
//    }
//
//    public List<String> getCodes() {
//        return codes;
//    }
//
//    public String getNumber() {
//        return number;
//    }

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

//    public List<String> getCurrency() {
//        return currency;
//    }
//
//    public String getCode() {
//        return code;
//    }

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
//                ", currency=" + currency +
//                ", code='" + code + '\'' +
//                ", Name='" + Name + '\'' +
//                ", symbol='" + symbol + '\'' +
//                ", language=" + language +
//                ", firstLanguage='" + firstLanguage + '\'' +
//                ", secondLanguage='" + secondLanguage + '\'' +
//                ", languageName='" + languageName + '\'' +
//                ", languageNativeName='" + languageNativeName + '\'' +
//                ", timeZones=" + timeZones +
//                ", time='" + time + '\'' +
//                ", area='" + area + '\'' +
//                ", codes=" + codes +
//                ", number='" + number + '\'' +
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
//        dest.writeString(String.valueOf(currency));
//        dest.writeString(code);
//        dest.writeString(symbol);
//        dest.writeString(String.valueOf(language));
//        dest.writeString(languageName);
//        dest.writeString(languageNativeName);
//        dest.writeString(firstLanguage);
//        dest.writeString(secondLanguage);
//        dest.writeString(time);
//        dest.writeString(area);
//        dest.writeString(String.valueOf(timeZones));
//        dest.writeString(String.valueOf(codes));
//        dest.writeString(number);
//        dest.writeString(Name);
    }
}


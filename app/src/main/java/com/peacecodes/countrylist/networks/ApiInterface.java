package com.peacecodes.countrylist.networks;

import com.peacecodes.countrylist.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("all?fields=name;capital;population;region;flag;nativeName;subregion;numericCode;currencies;timezones;callingCodes;languages;area")
    Call<List<Country>> getCountries();
}

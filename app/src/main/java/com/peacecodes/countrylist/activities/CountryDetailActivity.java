package com.peacecodes.countrylist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.PictureDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.peacecodes.countrylist.R;
import com.peacecodes.countrylist.model.Country;

import java.text.DecimalFormat;

public class CountryDetailActivity extends AppCompatActivity {

    private TextView mName, mCapital, mNativeName, mRegion, mSubRegion, mNumericCode, mPopulation;
    private ImageView mFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        mName = findViewById(R.id.tv_name);
        mCapital = findViewById(R.id.tv_capital);
        mNativeName = findViewById(R.id.tv_nativeName);
        mRegion = findViewById(R.id.tv_region);
        mSubRegion = findViewById(R.id.subRegion);
        mNumericCode = findViewById(R.id.numericCode);
        mPopulation = findViewById(R.id.tv_population);
        mFlag = findViewById(R.id.iv_flag);

        getCountryDetails();

    }

    private void getCountryDetails() {
        Intent intent = getIntent();
        Country country = intent.getParcelableExtra("CountrySelected");
        if (country == null) {
            country = new Country();
        }

        //for putting comma in-between the population digits
        String population = country.getPopulation();
        int populationInteger = Integer.parseInt(population);
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String yourFormattedString = formatter.format(populationInteger);

        Country countries = country;
        mName.setText(countries.getName());
        mCapital.setText(countries.getCapital());
        mNativeName.setText(countries.getNativeName());
        mRegion.setText(countries.getRegion());
        mSubRegion.setText(countries.getSubRegion());
        mNumericCode.setText(countries.getNumericCode());
        mPopulation.setText(yourFormattedString);
        showImage(countries.getImageUrl());
    }
    private void showImage(String url) {
        if (url != null && !url.isEmpty()) {
            RequestBuilder<PictureDrawable> requestBuilder = GlideToVectorYou
                    .init()
                    .with(this)
                    .getRequestBuilder();
            requestBuilder
                    .load(url)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .apply(new RequestOptions()
                            .centerCrop())
                    .into(mFlag);
        }
    }
}
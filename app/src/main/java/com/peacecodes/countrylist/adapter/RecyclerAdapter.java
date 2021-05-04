package com.peacecodes.countrylist.adapter;

import android.content.Context;
import android.content.Intent;

import android.graphics.drawable.PictureDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.peacecodes.countrylist.activities.CountryDetailActivity;
import com.peacecodes.countrylist.R;
import com.peacecodes.countrylist.model.Country;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> implements Filterable {
    private Context context;
    private List<Country> countryList;
//    List<Country> currency;
//    List<Country> language;
//    List<Country> timeZone;
//    List<Country> callingCode;

    //a copy of the list
    private List<Country> countryListFull;

    public RecyclerAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
        countryListFull = new ArrayList<>(countryList);
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        Country country = countryList.get(position);
        String url = country.getImageUrl();

        //for putting comma in-between the population digits
        String population = country.getPopulation();
        int populationInteger = Integer.parseInt(population);
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String yourFormattedString = formatter.format(populationInteger);

        holder.textViewName.setText(country.getName());
        holder.textViewCapital.setText(country.getCapital());
        holder.textViewRegion.setText(country.getRegion());
        holder.textViewPopulation.setText(yourFormattedString);

        if (url != null && !url.isEmpty()) {
            /*GlideToVectorYou
                    .init()
                    .with(context)
                    .load(Uri.parse(url), holder.imageViewImageUrl);*/

            RequestBuilder<PictureDrawable> requestBuilder = GlideToVectorYou
                    .init()
                    .with(context)
                    .getRequestBuilder();
            requestBuilder
                    .load(url)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .apply(new RequestOptions()
                            .centerCrop())
                    .into(holder.imageViewImageUrl);
        }
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    @Override
    public Filter getFilter() {
        return countryFilter;
    }

    private Filter countryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
           List<Country> filteredList = new ArrayList<>();

           if (constraint == null || constraint.length() == 0) {
               filteredList.addAll(countryListFull);
           } else {
               String filterPattern = constraint.toString().toLowerCase().trim();

               for (Country item : countryListFull) {
                   if (item.getName().toLowerCase().contains(filterPattern)) {
                       filteredList.add(item);
                   }
               }
           }
           FilterResults results = new FilterResults();
           results.values = filteredList;

           return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            countryList.clear();
            countryList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName;
        TextView textViewCapital;
        TextView textViewRegion;
        TextView textViewPopulation;
        ImageView imageViewImageUrl;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.name);
            textViewCapital = itemView.findViewById(R.id.capital);
            textViewRegion = itemView.findViewById(R.id.region);
            textViewPopulation = itemView.findViewById(R.id.population);
            imageViewImageUrl = itemView.findViewById(R.id.imageUrl);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Country countrySelected = countryList.get(position);
//            Country countrySelectedCurrency = currency.get(position);
//            Country countrySelectedLanguage = language.get(position);
//            Country countrySelectedTimeZone = timeZone.get(position);
//            Country countrySelectedCallingCode = callingCode.get(position);

            Intent intent = new Intent(view.getContext(), CountryDetailActivity.class);
            intent.putExtra("CountrySelected", countrySelected);
//            intent.putExtra("CountrySelectedCurrency", countrySelectedCurrency);
//            intent.putExtra("CountrySelectedLanguage", countrySelectedLanguage);
//            intent.putExtra("CountrySelectedTimeZone", countrySelectedTimeZone);
//            intent.putExtra("CountrySelectedCallingCode", countrySelectedCallingCode);
            view.getContext().startActivity(intent);
        }
    }
}

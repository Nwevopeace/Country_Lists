package com.peacecodes.countrylist.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.peacecodes.countrylist.networks.ApiClient;
import com.peacecodes.countrylist.networks.ApiInterface;
import com.peacecodes.countrylist.R;
import com.peacecodes.countrylist.adapter.RecyclerAdapter;
import com.peacecodes.countrylist.model.Country;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;
    List<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        countryList = new ArrayList<>();

        ApiInterface apiInterface = ApiClient.getClient(MainActivity.this).create(ApiInterface.class);
        Call<List<Country>> call = apiInterface.getCountries();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                countryList = response.body();

                Log.d("MainActivity", countryList.toString());

                mRecyclerAdapter = new RecyclerAdapter(getApplicationContext(), countryList);
                mRecyclerView.setAdapter(mRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.d("MainActivity", t.toString());

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater Inflater = getMenuInflater();
        Inflater.inflate(R.menu.main_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Search for a Country");
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mRecyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
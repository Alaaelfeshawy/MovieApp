package com.example.movieapp.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.model.MovieResponse;
import com.example.movieapp.utils.ClientApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static MovieRepository instance ;

    private MutableLiveData<MovieResponse> data = new MutableLiveData<>();

    public static MovieRepository getInstance() {
        if (instance == null){
            instance = new MovieRepository();
        }
        return instance;
    }

    public MutableLiveData<MovieResponse> getData (String apiKey){
        ClientApi.getInstance().getData(apiKey).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                data.setValue(response.body());

                Log.v("MovieRepository",""+response.body().getTotal_pages());

                Log.v("MovieRepository",""+response.body().getTotal_results());


            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

                Log.v("MovieRepository",""+t.getMessage());

            }
        });

        return data ;
    }
}

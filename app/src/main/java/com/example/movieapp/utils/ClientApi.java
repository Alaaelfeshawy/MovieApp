package com.example.movieapp.utils;

import com.example.movieapp.model.MovieResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientApi {

    private static final String BASE_URL="https://api.themoviedb.org/3/discover/";

    private static ClientApi instance ;

    private MovieInterface movieInterface ;

    public static ClientApi getInstance() {
        if (instance == null){
            instance = new ClientApi();
        }
        return instance;
    }

    public ClientApi(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        movieInterface = retrofit.create(MovieInterface.class);

    }

    public Call<MovieResponse> getData(String apiKey){
        return movieInterface.getMovie(apiKey);
    }
}

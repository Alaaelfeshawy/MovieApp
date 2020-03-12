package com.example.movieapp.utils;

import com.example.movieapp.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieInterface {
    @GET("movie/")
    public Call<MovieResponse> getMovie(@Query("api_key") String apiKey);
}

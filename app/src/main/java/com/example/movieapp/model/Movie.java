package com.example.movieapp.model;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.movieapp.view.MoreInfo;

public class Movie {

    private String popularity ;
    private int vote_count ;
    private String poster_path ;
    private String backdrop_path ;
    private String original_language ;
    private String title ;
    private String vote_average ;
    private String overview ;
    private String release_date ;

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @BindingAdapter({"android:poster_path"})
    public static void loadImage(ImageView view, String imageUrl) {

        String baseImageUrl = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
        Glide.with(view.getContext())
                .load(baseImageUrl+ imageUrl)
                .into(view);
    }

    public  void onClickNext(View view){
        Intent intent = new Intent(view.getContext(), MoreInfo.class);
        Bundle bundle = new Bundle();
        bundle.putString("Overview",overview);
        bundle.putString("date",release_date);
        bundle.putString("voteAverage",vote_average);
        bundle.putInt("voteCount",vote_count);
        bundle.putString("popularity",popularity);
        bundle.putString("posterPath",poster_path);
        bundle.putString("lan",original_language);
        bundle.putString("title",title);
        intent.putExtras(bundle);
        view.getContext().startActivity(intent);
    }

}

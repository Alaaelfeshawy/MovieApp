package com.example.movieapp.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.Repository.MovieRepository;
import com.example.movieapp.model.MovieResponse;

public class MovieViewModel  extends ViewModel {

    private MovieRepository repository ;

    private MutableLiveData<MovieResponse> data ;

    public static String API_KEY ="141033c09a52aac2c3fe8910d524ecb8";


    public void init(){

        repository = MovieRepository.getInstance();

       data = repository.getData(API_KEY);
    }

    public MutableLiveData<MovieResponse> getData() {
        return data;
    }
}

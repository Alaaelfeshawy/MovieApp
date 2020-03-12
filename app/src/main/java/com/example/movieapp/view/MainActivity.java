package com.example.movieapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.movieapp.R;
import com.example.movieapp.model.Movie;
import com.example.movieapp.model.MovieResponse;
import com.example.movieapp.view.Adapter.MovieAdapter;
import com.example.movieapp.viewModel.MovieViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MovieViewModel model ;

    private MovieAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        model = ViewModelProviders.of(this).get(MovieViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.recycler);

        model.init();

        model.getData().observe(this, new Observer<MovieResponse>() {
            @Override
            public void onChanged(MovieResponse movieResponse) {

               List<Movie> movies = movieResponse.getResults();

                adapter = new MovieAdapter(movies);

                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                recyclerView.setAdapter(adapter);

                adapter.notifyDataSetChanged();

            }
        });

    }
}

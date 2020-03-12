package com.example.movieapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.movieapp.R;
import com.example.movieapp.databinding.ActivityMoreInfoBinding;
import com.example.movieapp.model.Movie;

public class MoreInfo extends AppCompatActivity {

   private ActivityMoreInfoBinding binding ;

   private Movie movie ;

   private String overView , date , voteAverage , popularity, posterPath , lan , title ;

   private int voteCount ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_more_info);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_more_info);

        setData();

        applyData();

    }

    public void setData(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            overView = bundle.getString("Overview");
            date = bundle.getString("date");
            voteAverage = bundle.getString("voteAverage");
            voteCount =  bundle.getInt("voteCount");
            popularity = bundle.getString("popularity");
            posterPath =  bundle.getString("posterPath");
            lan =  bundle.getString("lan");
            title = bundle.getString("title");
        }

    }

    public void applyData(){
        movie = new Movie();
        movie.setOverview(overView);
        movie.setRelease_date(date);
        movie.setVote_average(voteAverage);
        movie.setVote_count(voteCount);
        movie.setPopularity(popularity);
        movie.setOriginal_language(lan);
        movie.setTitle(title);
        movie.setPoster_path(posterPath);
        binding.setMovie(movie);
    }
}

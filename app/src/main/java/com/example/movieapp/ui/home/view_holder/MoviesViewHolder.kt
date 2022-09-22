package com.example.movieapp.ui.home.view_holder

import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.MovieItemBinding
import com.example.movieapp.model.home.MovieModel
import com.example.movieapp.ui.base.BaseViewHolder

class MoviesViewHolder(private val itemBinding: ViewBinding,
) : BaseViewHolder<MovieItemBinding, MovieModel>(
    itemBinding
) {
    override fun onBind(position: Int, model: MovieModel) {
        Glide.with(itemBinding.root)
            .load("https://image.tmdb.org/t/p/w600_and_h900_bestv2"+model.backdropPath)
            .placeholder(R.drawable.placeholder)
            .into(binding.image)
        binding.title.text = model.title
        binding.date.text= model.releaseDate

    }

}
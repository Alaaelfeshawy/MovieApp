package com.example.movieapp.ui.home.view_holder

import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.data.util.AppConstants
import com.example.movieapp.R
import com.example.movieapp.databinding.MovieItemBinding
import com.example.movieapp.model.room.entity.MovieModel
import com.example.movieapp.ui.base.BaseViewHolder

class MoviesViewHolder(private val itemBinding: ViewBinding,
) : BaseViewHolder<MovieItemBinding, MovieModel>(
    itemBinding
) {
    override fun onBind(position: Int, model: MovieModel) {
        Glide.with(itemBinding.root)
            .load(AppConstants.BASE_IMAGE_URL+model.backdropPath)
            .placeholder(R.drawable.placeholder)
            .into(binding.image)
        binding.title.text = model.title
        binding.date.text= model.releaseDate
        binding.overview.text = model.overview

    }

}
package com.example.movieapp.ui.movie_details

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.example.data.util.AppConstants
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieDetailsBinding
import com.example.movieapp.model.home.MovieModel
import com.example.movieapp.model.home.response.TopRatedMoviesResponseModel
import com.example.movieapp.ui.base.BaseFragment
import com.example.movieapp.ui.home.HomeViewModel
import com.example.movieapp.ui.util.Util
import com.example.movieapp.ui.util.Util.makeToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding>() {
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MovieDetailsViewModel by lazy {
        ViewModelProvider(this)[MovieDetailsViewModel::class.java]
    }

    private var movieId : Int ? =null

    override val layoutId: Int
        get() = R.layout.fragment_movie_details

    override fun viewSetup() {
        _binding = viewDataBinding
        movieId = arguments?.getInt("movieId") ?: 0
        movieId?.let {
            viewModel.getMovieDetails(it)
        }
        binding.tryAgain.setOnClickListener {
            movieId?.let {
                viewModel.getMovieDetails(it)
            }
        }
    }

    override fun viewModelSetup() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    when (it) {
                        is MovieDetailsViewModel.MovieDetailsState.Loading -> showLoader(it.isLoading)
                        is MovieDetailsViewModel.MovieDetailsState.Idle -> Unit
                        is MovieDetailsViewModel.MovieDetailsState.Error -> showError(it.message)
                        is MovieDetailsViewModel.MovieDetailsState.NoConnection -> handleNetwork(it.isConnected)
                        is MovieDetailsViewModel.MovieDetailsState.Success<MovieModel> -> bindData(it.data)
                    }
                }
            }
        }
    }

    private fun bindData(model: MovieModel){
        binding.mainView.visibility= View.VISIBLE
        binding.date.text = model.releaseDate
        binding.title.text = model.title
        binding.overview.text = model.overview
        Glide.with(requireContext())
            .load(AppConstants.BASE_IMAGE_URL+model.posterPath)
            .placeholder(R.drawable.placeholder)
            .into(binding.movieImage)

    }

    private fun showLoader(isLoading:Boolean){
        if (isLoading){
            binding.progressBar.visibility= View.VISIBLE
            binding.noInternetLayout.visibility= View.GONE
            binding.mainView.visibility= View.GONE
        }else{
            binding.progressBar.visibility= View.GONE
        }
    }

    private fun showError(message:String){
        makeToast(requireContext(),message, Toast.LENGTH_SHORT)
    }

    private fun handleNetwork(isConnected:Boolean){
        if(isConnected){
            binding.noInternetLayout.visibility= View.GONE
        }else{
            binding.noInternetLayout.visibility= View.VISIBLE
            binding.mainView.visibility= View.GONE
        }
    }
}
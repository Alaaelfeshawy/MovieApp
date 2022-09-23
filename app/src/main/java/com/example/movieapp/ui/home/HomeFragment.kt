package com.example.movieapp.ui.home

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.databinding.MovieItemBinding
import com.example.movieapp.model.home.response.TopRatedMoviesResponseModel
import com.example.movieapp.model.room.entity.MovieModel
import com.example.movieapp.ui.base.BaseAdapter
import com.example.movieapp.ui.base.BaseFragment
import com.example.movieapp.ui.home.view_holder.MoviesViewHolder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() , SwipeRefreshLayout.OnRefreshListener{

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(requireActivity())[HomeViewModel::class.java]
    }

    private val moviesAdapter: BaseAdapter<MovieModel, MovieItemBinding> by lazy {
        BaseAdapter(R.layout.movie_item, {
            it.id?.let {
                movieId->
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(movieId))
            }
        }) {
            MoviesViewHolder(it)
        }
    }

    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun viewSetup() {
        _binding = viewDataBinding
        viewModel.getTopRatedMovies()
        binding.moviesRecyclerView.adapter = moviesAdapter
        binding.tryAgain.setOnClickListener {
            viewModel.getTopRatedMovies()
        }
        binding.mainSwipeRefreshLayout.setOnRefreshListener(this)
        binding.mainSwipeRefreshLayout.setColorSchemeResources(
            R.color.black,
            R.color.black,
            R.color.black,
            R.color.black
        )
    }

    override fun viewModelSetup() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    when (it) {
                        is HomeViewModel.HomeState.Loading -> showLoader(it.isLoading)
                        is HomeViewModel.HomeState.Idle -> Unit
                        is HomeViewModel.HomeState.Error -> showError(it.message)
                        is HomeViewModel.HomeState.NoConnection -> handleNetwork(it.isConnected)
                        is HomeViewModel.HomeState.Success<TopRatedMoviesResponseModel> -> {
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listState.collect{
                    binding.mainView.visibility= View.VISIBLE
                    binding.noInternetLayout.visibility=View.GONE
                    moviesAdapter.setDataList(it)
                }
            }
        }
    }

    private fun showLoader(isLoading:Boolean){
        if (isLoading){
            binding.progressBar.visibility=View.VISIBLE
            binding.noInternetLayout.visibility=View.GONE
            binding.mainView.visibility=View.GONE
        }else{
            binding.progressBar.visibility=View.GONE
        }
    }

    private fun showError(message:String){
        Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
    }

    private fun handleNetwork(isConnected:Boolean){
        if(isConnected){
            binding.noInternetLayout.visibility=View.GONE
        }else if(viewModel.listState.value.isEmpty()){
            binding.noInternetLayout.visibility=View.VISIBLE
            binding.mainView.visibility=View.GONE
        }else{
            binding.noInternetLayout.visibility=View.GONE
            binding.mainView.visibility=View.VISIBLE
        }
    }

    override fun onRefresh() {
        binding.mainSwipeRefreshLayout.isRefreshing = true
        viewModel.getTopRatedMovies()
        binding.mainSwipeRefreshLayout.isRefreshing = false
    }
}
package com.example.movieapp.ui.movie_details

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieDetailsBinding
import com.example.movieapp.ui.base.BaseFragment
import com.example.movieapp.ui.util.Util.makeToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding>() {
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!
//    private var articleModel : ArticleModel ?= null
    private val viewModel: MovieDetailsViewModel by lazy {
        ViewModelProvider(this)[MovieDetailsViewModel::class.java]
    }
    override val layoutId: Int
        get() = R.layout.fragment_movie_details

    override fun viewSetup() {
        _binding = viewDataBinding
//        arguments?.let {
//            articleModel = it.getParcelable(AppConstants.ARTICLE_MODEL)
//        }
//        Glide.with(requireContext())
//            .load(articleModel?.urlToImage)
//            .placeholder(R.drawable.placeholder)
//            .into(binding.articleImage)
//        binding.articleTitle.text = articleModel?.title
//        binding.articleDesc.text = articleModel?.description
//        binding.articleAuthor.text = articleModel?.author
//        binding.articleDate.text= articleModel?.publishedAt?.let { Util.covertDate(it) }
//        binding.openWebView.setOnClickListener {
//            navController?.navigate(NewsDetailsFragmentDirections.actionNewsDetailsFragmentToWebViewFragment(articleModel?.url ?: ""))
//        }
//        val article = ArticleModelMapper.mapper.toDomain(articleModel)
//        binding.bookmarkIcon.setOnClickListener {
//            article?.let {
//                viewModel.isArticleExistInDbAnUpdate(it) {
//                    if (it) {
//                        binding.bookmarkIcon.setImageDrawable(requireContext().getDrawable(R.drawable.ic_fill_bookmark))
//                    } else {
//                        binding.bookmarkIcon.setImageDrawable(requireContext().getDrawable(R.drawable.ic_e_bookmark_border))
//                    }
//                }
//            }
//        }
//        article?.let { it1 ->
//            viewModel.isArticleExistInDb(it1) {
//                if (it) {
//                    binding.bookmarkIcon.setImageDrawable(requireContext().getDrawable(R.drawable.ic_fill_bookmark))
//                } else {
//                    binding.bookmarkIcon.setImageDrawable(requireContext().getDrawable(R.drawable.ic_e_bookmark_border))
//                }
//            }
//        }
    }

    override fun viewModelSetup() {

    }

}
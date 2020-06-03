package com.example.nexlist.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide

import com.example.nexlist.R
import com.example.nexlist.databinding.FragmentSingleMovieBinding
import com.example.nexlist.di.MyApplication
import com.example.nexlist.utils.Utils
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SingleMovieFragment : Fragment() {

    lateinit var binding: FragmentSingleMovieBinding
    @Inject
    lateinit var movieViewModel: MovieViewModel
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (requireActivity().application as MyApplication).appComponent.inject(this)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_single_movie, container, false)

        val args = SingleMovieFragmentArgs.fromBundle(requireArguments())
        val movie = args.singleMovie
        binding.singleMovie = movie


        if (movie.rating.isEmpty()){
            val rating = 0.0.toFloat()
            binding.favouriteRatingBar4.rating= rating
            binding.favouriteRatingNum.text= "Rating: $rating/5"
        }else{
            var sm = movie.rating.toDouble() ?: 0.0
            val rating = Utils.rating(movie.rating.toDouble()) ?: 0.0.toFloat()
            binding.favouriteRatingBar4.rating= rating
            binding.favouriteRatingNum.text= "Rating: $rating/5"
        }


        val img = movie.largeimage
        Glide.with(binding.root.context).asBitmap().error(R.drawable.banner33_2x).load(img)
            .into(binding.imageView3)


        return binding.root
    }

}

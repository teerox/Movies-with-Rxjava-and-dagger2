package com.example.nexlist.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

import com.example.nexlist.R
import com.example.nexlist.databinding.FragmentMovieBinding
import com.example.nexlist.di.MyApplication
import com.example.nexlist.model.Movie
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    lateinit var binding: FragmentMovieBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MovieAdapter
    // Fields that need to be injected by the login graph
    @Inject
    lateinit var movieViewModel: MovieViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (requireActivity().application as MyApplication).appComponent.inject(this)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie, container, false)

        recyclerView = binding.recyclerId
        movieViewModel.allMovies().observeForever {
            Log.e("All Movies",it.toString())
            adapter = MovieAdapter(it.ITEMS){
                item ->
                val action = MovieFragmentDirections.actionMovieFragmentToSingleMovieFragment(item)
                findNavController().navigate(action)

            }

            recyclerView.adapter = adapter
            binding.progressBar.visibility = View.GONE

        }

        return binding.root
    }

}

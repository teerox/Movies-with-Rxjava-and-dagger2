package com.example.nexlist.screens

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nexlist.R
import com.example.nexlist.databinding.MovieItemBinding
import com.example.nexlist.model.ITEMS


import com.example.nexlist.utils.Utils



class MovieAdapter(
    private var movieArray: List<ITEMS>,
    private val clickListener: (result: ITEMS) -> Unit
) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(view)

        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return movieArray.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movieArray[position], clickListener)


    class ViewHolder(var binding: MovieItemBinding ) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(result: ITEMS, clickListener: (result: ITEMS) -> Unit) {
            if (result.rating.isEmpty()){
                val rating = 0.0.toFloat()
                binding.moveItemRating.rating = rating
                binding.textView3.text = "Rating: $rating/5"
            }else {
                val rating = Utils.rating(result.rating.toDouble())
                binding.moveItemRating.rating = rating
                binding.textView3.text = "Rating: $rating/5"
            }

            binding.root.setOnClickListener {
                clickListener(result)
            }

            binding.myMovie = result
            val img = result.image
            Glide.with(binding.root.context).asBitmap().error(R.drawable.banner33_2x).load(img)
                .into(binding.imageView)
        }
    }


}
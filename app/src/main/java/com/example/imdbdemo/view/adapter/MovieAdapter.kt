package com.example.imdbdemo.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdbdemo.databinding.LayoutMovieItemBinding
import com.example.imdbdemo.model.Movie
import javax.inject.Inject

class MovieAdapter @Inject constructor() : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private var list: List<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutMovieItemBinding.
        inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(itemList: List<Movie>?) {
        if (itemList != null) {
            list = itemList
            notifyDataSetChanged()
        }
    }

    inner class MyViewHolder(private val binding: LayoutMovieItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(movie.image)
                    .into(binding.ivMoviePoster)

                binding.apply {
                    tvMovieTitle.text = movie.fullTitle?:""
                    tvCrewMember.text = movie.crew?:""
                    tvReleaseDate.text = movie.year?:""
                    if (movie.imDbRating.isNullOrEmpty()) {
                        tvImdbRating.visibility = View.GONE
                    } else {
                        tvImdbRating.visibility = View.VISIBLE
                        tvImdbRating.text = movie.imDbRating
                    }
                }
            }
        }

    }
}
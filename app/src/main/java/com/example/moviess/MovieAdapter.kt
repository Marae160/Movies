package com.example.moviess

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleTextView.text = movie.title
        holder.overviewTextView.text = movie.overview

        // Load movie poster using Picasso or another image loading library
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
            .into(holder.posterImageView)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val overviewTextView: TextView = itemView.findViewById(R.id.overviewTextView)
        val posterImageView: ImageView = itemView.findViewById(R.id.posterImageView)
    }
}

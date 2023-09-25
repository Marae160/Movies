package com.example.moviess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.movieRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val movieService = ApiClient.retrofit.create(MovieService::class.java)
        val call = movieService.getNowPlayingMovies("YOUR_API_KEY")

        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val movies = response.body()?.results
                    val adapter = MovieAdapter(movies.orEmpty())
                    recyclerView.adapter = adapter
                } else {
                    // Handle API error
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                // Handle network error
            }
        })
    }
}

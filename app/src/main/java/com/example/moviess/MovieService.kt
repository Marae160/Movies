package com.example.moviess

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/now_playing")
    fun getNowPlayingMovies(
        @Query("a07e22bc18f5cb106bfe4cc1f83ad8ed") apiKey: String
    ): Call<MovieResponse>
}

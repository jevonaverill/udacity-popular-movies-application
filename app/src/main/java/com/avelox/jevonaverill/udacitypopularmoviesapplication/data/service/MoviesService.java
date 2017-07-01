package com.avelox.jevonaverill.udacitypopularmoviesapplication.data.service;

import com.avelox.jevonaverill.udacitypopularmoviesapplication.data.model.MoviesResponse;
import com.avelox.jevonaverill.udacitypopularmoviesapplication.data.model.SortBy;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by jevonaverill on 6/30/17.
 */

public interface MoviesService {

    @GET("/movie/{sort_by}")
    Observable<MoviesResponse> discoverMovies(
            @Path("sort_by") SortBy sort_by,
            @Query("page") Integer page);

}

package com.avelox.jevonaverill.udacitypopularmoviesapplication.dagger;

import com.avelox.jevonaverill.udacitypopularmoviesapplication.BuildConfig;
import com.avelox.jevonaverill.udacitypopularmoviesapplication.data.service.MoviesService;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by jevonaverill on 6/30/17.
 */

@Module(
        complete = false,
        library = true
)
public final class ApiModule {

    public static final String THE_MOVIE_DB_API_URL = "http://api.themoviedb.org/3";

    @Provides
    @Singleton
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(THE_MOVIE_DB_API_URL);
    }

    @Provides @Singleton
    RestAdapter provideRestAdapter(Endpoint endpoint, OkHttpClient client, Gson gson) {
        return new RestAdapter.Builder()
                .setClient(new OkClient(client))
                .setEndpoint(endpoint)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override public void intercept(RequestFacade request) {
                        request.addQueryParam("api_key", BuildConfig.THE_MOVIE_DB_API_KEY);
                    }
                })
                .setConverter(new GsonConverter(gson))
                .build();
    }

    @Provides @Singleton MoviesService provideMoviesService(RestAdapter restAdapter) {
        return restAdapter.create(MoviesService.class);
    }

}
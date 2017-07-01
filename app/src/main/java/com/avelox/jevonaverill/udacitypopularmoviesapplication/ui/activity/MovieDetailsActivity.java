package com.avelox.jevonaverill.udacitypopularmoviesapplication.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.avelox.jevonaverill.udacitypopularmoviesapplication.R;
import com.avelox.jevonaverill.udacitypopularmoviesapplication.data.model.Movie;
import com.avelox.jevonaverill.udacitypopularmoviesapplication.ui.fragment.MovieFragment;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;

/**
 * Created by jevonaverill on 6/30/17.
 */

public final class MovieDetailsActivity extends BaseActivity {

    public static final String EXTRA_MOVIE = "com.avelox.jevonaverill.udacitypopularmoviesapplication.extras.EXTRA_MOVIE";

    @Bind(R.id.movie_title)
    TextView mMovieTitle;

    @Bind(R.id.movie_release_year)
    TextView mReleaseYear;

    private MovieFragment mMovieFragment;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setDisplayShowHomeEnabled(true);
            ab.setTitle("");
        }

        final Toolbar toolbar = getToolbar();
        if (toolbar != null) {
            ViewCompat.setElevation(toolbar, 0);
        }

        Movie movie = (Movie) getIntent().getSerializableExtra(EXTRA_MOVIE);
        setMovie(movie);

        mMovieFragment = (MovieFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_movie);
        mMovieFragment.setMovie(movie);
    }

    private void setMovie(Movie movie) {
        mMovieTitle.setText(movie.getTitle());

        String initialDate = movie.getReleaseDate();
        SimpleDateFormat input = new SimpleDateFormat("yyyy-dd-mm");
        SimpleDateFormat output = new SimpleDateFormat("MMM dd, yyyy");

        try {
            Date newDate = input.parse(initialDate);         // parse input
            mReleaseYear.setText(output.format(newDate));    // format output
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}

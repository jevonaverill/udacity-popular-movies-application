package com.avelox.jevonaverill.udacitypopularmoviesapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.avelox.jevonaverill.udacitypopularmoviesapplication.R;
import com.avelox.jevonaverill.udacitypopularmoviesapplication.data.model.Movie;
import com.avelox.jevonaverill.udacitypopularmoviesapplication.data.model.SortBy;
import com.avelox.jevonaverill.udacitypopularmoviesapplication.ui.fragment.MoviesFragment;
import com.avelox.jevonaverill.udacitypopularmoviesapplication.ui.listener.MovieClickListener;

/**
 * Created by jevonaverill on 6/30/17.
 */

public final class BrowseMoviesActivity extends BaseActivity implements MovieClickListener {

    private static final String STATE_SORT = "STATE_SORT";

    private MoviesFragment mMoviesFragment;
    private SortBy mSortBy;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        mMoviesFragment = (MoviesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_movies);
    }

    @Override protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mSortBy = (savedInstanceState != null) ? (SortBy)
                savedInstanceState.getSerializable(STATE_SORT) : SortBy.MOST_POPULAR;

        Log.d(TAG, "SortBy=" + mSortBy);

        mMoviesFragment.reloadMovies(mSortBy);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_browse_movies, menu);
        return true;
    }

    @Override public boolean onPrepareOptionsMenu(Menu menu) {
        switch (mSortBy) {
            case MOST_POPULAR:
                menu.findItem(R.id.menu_sort_by_most_popular).setChecked(true);
                break;
            case HIGHEST_RATED:
                menu.findItem(R.id.menu_sort_by_highest_rated).setChecked(true);
                break;
        }
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_sort_by_most_popular:
                item.setChecked(!item.isChecked());
                onSortChanged(SortBy.MOST_POPULAR);
                break;
            case R.id.menu_sort_by_highest_rated:
                item.setChecked(!item.isChecked());
                onSortChanged(SortBy.HIGHEST_RATED);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(STATE_SORT, mSortBy);
    }

    @Override public void onContentClicked(Movie movie, View view) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra(MovieDetailsActivity.EXTRA_MOVIE, movie);
        startActivity(intent);
    }

    private void onSortChanged(@NonNull SortBy sortBy) {
        mSortBy = sortBy;
        mMoviesFragment.reloadMovies(mSortBy);
        mMoviesFragment.scrollToTop();
    }

}

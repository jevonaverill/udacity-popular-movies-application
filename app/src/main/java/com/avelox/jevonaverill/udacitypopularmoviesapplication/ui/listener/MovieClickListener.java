package com.avelox.jevonaverill.udacitypopularmoviesapplication.ui.listener;

import android.view.View;

import com.avelox.jevonaverill.udacitypopularmoviesapplication.data.model.Movie;

/**
 * Created by jevonaverill on 6/30/17.
 */

public interface MovieClickListener {

    void onContentClicked(Movie movie, View view);

    class SimpleListener implements MovieClickListener {

        @Override public void onContentClicked(Movie movie, View view) {}

    }

}

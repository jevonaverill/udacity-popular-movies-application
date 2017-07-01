package com.avelox.jevonaverill.udacitypopularmoviesapplication.data.model;

/**
 * Created by jevonaverill on 6/30/17.
 */

public enum SortBy {

    MOST_POPULAR("popular"),
    HIGHEST_RATED("top_rated");

    private final String value;

    SortBy(String value) {
        this.value = value;
    }

    @Override public String toString() {
        return value;
    }

}

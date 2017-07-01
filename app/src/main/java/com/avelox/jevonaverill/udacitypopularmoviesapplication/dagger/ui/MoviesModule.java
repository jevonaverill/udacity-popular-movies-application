package com.avelox.jevonaverill.udacitypopularmoviesapplication.dagger.ui;

import com.avelox.jevonaverill.udacitypopularmoviesapplication.dagger.AppModule;
import com.avelox.jevonaverill.udacitypopularmoviesapplication.ui.fragment.MoviesFragment;

import dagger.Module;

/**
 * Created by jevonaverill on 6/30/17.
 */

@Module(
        injects = {
                MoviesFragment.class
        },
        addsTo = AppModule.class
)
public final class MoviesModule {}

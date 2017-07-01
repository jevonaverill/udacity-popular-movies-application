package com.avelox.jevonaverill.udacitypopularmoviesapplication.dagger;

import android.app.Application;

import com.avelox.jevonaverill.udacitypopularmoviesapplication.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jevonaverill on 6/30/17.
 */

@Module(
        includes = DataModule.class,
        injects = {
                App.class
        },
        library = true
)
public final class AppModule {

    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

}
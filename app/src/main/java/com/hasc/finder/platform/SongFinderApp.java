package com.hasc.finder.platform;

import com.hasc.finder.platform.di.app.AppComponent;
import com.hasc.finder.platform.di.app.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class SongFinderApp extends DaggerApplication {


    @Override
    protected AndroidInjector<SongFinderApp> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}

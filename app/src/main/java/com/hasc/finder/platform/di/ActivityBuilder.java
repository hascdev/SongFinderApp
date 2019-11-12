package com.hasc.finder.platform.di;

import com.hasc.finder.platform.di.list.ListActivityModule;
import com.hasc.finder.platform.ui.SongListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = ListActivityModule.class)
    abstract SongListActivity bindListActivity();
}

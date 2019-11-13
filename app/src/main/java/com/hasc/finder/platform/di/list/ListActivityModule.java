package com.hasc.finder.platform.di.list;

import com.hasc.finder.domain.interactor.UseCaseFactory;
import com.hasc.finder.platform.ui.SongListActivity;
import com.hasc.finder.presentation.presenters.SongListPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ListActivityModule {

    @Provides
    SongListPresenter providePresenter(SongListActivity activity, UseCaseFactory useCaseFactory){
        SongListPresenter presenter = new SongListPresenter(useCaseFactory);
        presenter.setView(activity);
        return presenter;
    }

}

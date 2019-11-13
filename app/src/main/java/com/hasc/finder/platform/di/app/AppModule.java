package com.hasc.finder.platform.di.app;

import android.app.Application;
import android.content.Context;

import com.hasc.finder.data.entity.mapper.SongEntityDataMapper;
import com.hasc.finder.data.repository.impl.SongsRepositoryImpl;
import com.hasc.finder.data.source.remote.SongService;
import com.hasc.finder.data.source.remote.SongsRemoteDataSource;
import com.hasc.finder.data.source.remote.SongsRemoteDataSourceImpl;
import com.hasc.finder.domain.repository.SongsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    SongService provideService() {
        return new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SongService.class);
    }

    @Provides
    @Singleton
    SongsRemoteDataSource provideRemoteDataSource(SongService songService) {
        return new SongsRemoteDataSourceImpl(songService);
    }

    @Provides
    @Singleton
    SongsRepository provideRepository(SongsRemoteDataSource remoteDataSource, SongEntityDataMapper entityDataMapper) {
        return new SongsRepositoryImpl(remoteDataSource, entityDataMapper);
    }
}

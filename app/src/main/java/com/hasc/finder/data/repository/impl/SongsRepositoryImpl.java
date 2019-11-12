package com.hasc.finder.data.repository.impl;

import com.hasc.finder.data.entity.SongEntity;
import com.hasc.finder.data.entity.mapper.SongEntityDataMapper;
import com.hasc.finder.data.source.remote.SongsRemoteDataSource;
import com.hasc.finder.domain.Handler;
import com.hasc.finder.domain.Song;
import com.hasc.finder.domain.repository.SongsRepository;

import java.util.List;

import javax.inject.Inject;

public class SongsRepositoryImpl implements SongsRepository {

    private SongsRemoteDataSource songsRemoteDataSource;

    private SongEntityDataMapper songEntityDataMapper;

    @Inject
    public SongsRepositoryImpl(SongsRemoteDataSource songsRemoteDataSource, SongEntityDataMapper songEntityDataMapper) {
        this.songsRemoteDataSource = songsRemoteDataSource;
        this.songEntityDataMapper = songEntityDataMapper;
    }

    @Override
    public void getSongs(String mediaType, String term, final Handler<List<Song>> handler) {
        songsRemoteDataSource.getAll(mediaType, term, new Handler<List<SongEntity>>() {
            @Override
            public void handle(List<SongEntity> songEntityList) {
                handler.handle(songEntityDataMapper.transform(songEntityList));
            }

            @Override
            public void error(Exception exception) {
                handler.error(exception);
            }
        });
    }

    @Override
    public void getSong(int songId, Handler<Song> handler) {

    }
}

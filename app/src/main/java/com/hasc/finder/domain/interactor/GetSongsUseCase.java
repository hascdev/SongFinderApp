package com.hasc.finder.domain.interactor;

import com.hasc.finder.domain.Handler;
import com.hasc.finder.domain.Song;
import com.hasc.finder.domain.repository.SongsRepository;

import java.util.List;

public class GetSongsUseCase implements UseCase<List<Song>, String> {

    private SongsRepository repository;

    public GetSongsUseCase(SongsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(final Handler<List<Song>> handler, String term) {

        repository.getSongs("music", term, new Handler<List<Song>>() {

            @Override
            public void handle(List<Song> songList) {
                handler.handle(songList);
            }

            @Override
            public void error(Exception exception) {
                handler.error(exception);
            }
        });
    }
}

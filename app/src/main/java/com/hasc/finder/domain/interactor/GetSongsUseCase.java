package com.hasc.finder.domain.interactor;

import com.hasc.finder.domain.Handler;
import com.hasc.finder.domain.Song;
import com.hasc.finder.domain.repository.SongsRepository;

import java.util.List;

public class GetSongsUseCase implements UseCase<List<Song>, GetSongsUseCase.Params> {

    private SongsRepository repository;

    public GetSongsUseCase(SongsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(final Handler<List<Song>> handler, GetSongsUseCase.Params params) {

        repository.getSongs(params.getMediaType(), params.getTerm(), new Handler<List<Song>>() {

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

    public static final class Params {

        private final String mediaType;
        private final String term;

        public Params(String mediaType, String term) {
            this.mediaType = mediaType;
            this.term = term;
        }

        public String getMediaType() {
            return mediaType;
        }

        public String getTerm() {
            return term;
        }
    }
}

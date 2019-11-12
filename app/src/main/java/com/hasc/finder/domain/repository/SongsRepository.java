package com.hasc.finder.domain.repository;

import com.hasc.finder.domain.Handler;
import com.hasc.finder.domain.Song;

import java.util.List;

public interface SongsRepository {

    void getSongs(String mediaType, String term, Handler<List<Song>> handler);

    void getSong(int songId, Handler<Song> handler);
}

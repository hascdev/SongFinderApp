package com.hasc.finder.data.source.remote;

import com.hasc.finder.data.entity.SongEntity;
import com.hasc.finder.domain.Handler;

import java.util.List;

public interface SongsRemoteDataSource {

    void getAll(String mediaType, String term, Handler<List<SongEntity>> handler);
}

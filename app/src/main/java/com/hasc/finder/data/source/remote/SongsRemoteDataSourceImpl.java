package com.hasc.finder.data.source.remote;

import com.hasc.finder.data.entity.PageEntity;
import com.hasc.finder.data.entity.SongEntity;
import com.hasc.finder.domain.Handler;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongsRemoteDataSourceImpl implements SongsRemoteDataSource {

    private SongService songService;

    @Inject
    public SongsRemoteDataSourceImpl(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void getAll(String mediaType, String term, final Handler<List<SongEntity>> handler) {

        songService.getPageEntity(mediaType, term).enqueue(new Callback<PageEntity>() {

            @Override
            public void onResponse(Call<PageEntity> call, Response<PageEntity> response) {
                if(response.isSuccessful() && response.body() != null){
                    handler.handle(response.body().songs);
                } else {
                    handler.error(new RuntimeException());
                }
            }

            @Override
            public void onFailure(Call<PageEntity> call, Throwable t) {
                handler.error(new RuntimeException());
            }
        });
    }
}

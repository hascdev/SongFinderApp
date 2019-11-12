package com.hasc.finder.data.source.remote;

import com.hasc.finder.data.entity.PageEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SongService {

    @GET("search")
    Call<PageEntity> getPageEntity(@Query("mediaType") String mediaType, @Query("term") String term);
}

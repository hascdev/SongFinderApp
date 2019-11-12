package com.hasc.finder.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PageEntity {

    @SerializedName("page")
    public int page;

    @SerializedName("resultCount")
    public int resultCount;

    @SerializedName("totalPages")
    public int totalPages;

    @SerializedName("results")
    public List<SongEntity> songs;

    public PageEntity() {    }

    public PageEntity(int page, int resultCount, int totalPages, List<SongEntity> songs) {
        this.page = page;
        this.resultCount = resultCount;
        this.totalPages = totalPages;
        this.songs = songs;
    }
}

package com.hasc.finder.data.entity;

import android.content.ContentValues;
import android.database.Cursor;

import com.google.gson.annotations.SerializedName;

public class SongEntity {

    @SerializedName("trackId")
    public int trackId;

    @SerializedName("artistId")
    public int artistId;

    @SerializedName("collectionId")
    public int collectionId;

    @SerializedName("kind")
    public String kind;

    @SerializedName("artistName")
    public String artistName;

    @SerializedName("collectionName")
    public String collectionName;

    @SerializedName("trackName")
    public String trackName;

    @SerializedName("artworkUrl100")
    public String artworkUrl100;

    @SerializedName("previewUrl")
    public String previewUrl;

    @SerializedName("collectionViewUrl")
    public String collectionViewUrl;

    public SongEntity() {    }

    public SongEntity(int artistId, String kind, int collectionId, int trackId, String artistName, String collectionName, String trackName, String artworkUrl100, String previewUrl, String collectionViewUrl) {
        this.artistId = artistId;
        this.kind = kind;
        this.collectionId = collectionId;
        this.trackId = trackId;
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.trackName = trackName;
        this.artworkUrl100 = artworkUrl100;
        this.previewUrl = previewUrl;
        this.collectionViewUrl = collectionViewUrl;
    }

    public SongEntity(Cursor cursor) {
        super();
    }

    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        return values;
    }
}

package com.hasc.finder.domain;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.Objects;

public final class Song implements Serializable {

    private final int id;
    private final String artistName;
    private final String collectionName;
    private final String trackName;
    private final String artworkUrl100;
    private final String previewUrl;
    private final String collectionViewUrl;

    public Song(int id, String artistName, String collectionName, String trackName, String artworkUrl100, String previewUrl, String collectionViewUrl) {
        this.id = id;
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.trackName = trackName;
        this.artworkUrl100 = artworkUrl100;
        this.previewUrl = previewUrl;
        this.collectionViewUrl = collectionViewUrl;
    }

    public int getId() {
        return id;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Song that = (Song) obj;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artistName, collectionName, trackName, artworkUrl100, previewUrl, collectionViewUrl);
    }
}

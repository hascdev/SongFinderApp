package com.hasc.finder.utils;

import com.hasc.finder.domain.Song;

import java.util.ArrayList;
import java.util.List;

public class TestUtils implements TestData {

    public static Song createMainSong(){
        return new Song(MAIN_ID, MAIN_ARTIST_NAME, MAIN_COLLECTION_NAME, MAIN_TRACK_NAME,
                MAIN_ARTWORK_URL_100, MAIN_PREVIEW_URL, MAIN_COLLECTION_PREVIEW_URL);
    }

    public static Song createAltSong(){
        return new Song(ALT_ID, ALT_ARTIST_NAME, ALT_COLLECTION_NAME, ALT_TRACK_NAME,
                ALT_ARTWORK_URL_100, ALT_PREVIEW_URL, ALT_COLLECTION_PREVIEW_URL);
    }

    public static List<Song> createMainSongList(){
        List<Song> songs = new ArrayList<>();
        songs.add(createMainSong());
        songs.add(createAltSong());
        return songs;
    }
}

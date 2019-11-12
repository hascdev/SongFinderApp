package com.hasc.finder.data.entity.mapper;

import com.hasc.finder.data.entity.SongEntity;
import com.hasc.finder.domain.Song;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SongEntityDataMapper {

    @Inject
    public SongEntityDataMapper(){ }

    public List<Song> transform(List<SongEntity> songEntityList){
        List<Song> songList = new ArrayList<>();
        for(SongEntity songEntity : songEntityList){
            Song song = transform(songEntity);
            if(song != null){
                songList.add(song);
            }
        }
        return songList;
    }

    public Song transform(SongEntity songEntity){
        Song song = null;
        if(songEntity != null){
            song = new Song(songEntity.trackId,
                    songEntity.artistName,
                    songEntity.collectionName,
                    songEntity.trackName,
                    songEntity.artworkUrl100,
                    songEntity.previewUrl,
                    songEntity.collectionViewUrl);
        }
        return song;
    }
}

package com.hasc.finder.presentation.presenters;

import com.hasc.finder.domain.Handler;
import com.hasc.finder.domain.Song;
import com.hasc.finder.domain.interactor.GetSongsUseCase;
import com.hasc.finder.domain.interactor.UseCase;
import com.hasc.finder.domain.interactor.UseCaseFactory;
import com.hasc.finder.presentation.SongHolder;
import com.hasc.finder.presentation.SongListView;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

public class SongListPresenter implements Handler<List<Song>> {

    private UseCaseFactory useCaseFactory;

    private String mediaType, term;

    private int selectedSongId;

    private WeakReference<SongListView> view;

    private List<Song> songList;

    @Inject
    public SongListPresenter(UseCaseFactory useCaseFactory){
        this.useCaseFactory = useCaseFactory;
    }

    @Override
    public void handle(List<Song> songList) {
        saveSongs(songList);
        SongListView songListView = view.get();
        if (songListView != null) {
            songListView.cancelRefreshDialog();
            songListView.refreshList();
        }
    }

    @Override
    public void error(Exception exception) {
        saveSongs(songList);
        SongListView songListView = view.get();
        if (songListView != null) {
            songListView.cancelRefreshDialog();
            songListView.showErrorMessage(exception.getMessage());
        }
    }

    public void setView(SongListView songListView){
        view = new WeakReference<>(songListView);
    }

    public void refresh(){
        invokeUseCase();
    }

    public void search(String mediaType, String term) {
        this.mediaType = mediaType;
        this.term = term;
        invokeUseCase();
    }

    public int getItemsCount(){
        if(songsListIsEmpty()){
            return 0;
        } else{
            return songList.size();
        }
    }

    public void configureCell(SongHolder songHolderView, int position){
        Song song = getSong(position);
        songHolderView.display(song);
    }

    public void onItemClick(int position){
        Song song = getSong(position);
        saveSelectedSongId(song.getId());
        SongListView songListView = view.get();
        if (songListView!=null) {
            songListView.navigateToDetailScreen(getSelectedSongId());
        }
    }

    private void invokeUseCase(){
        UseCase useCase = useCaseFactory.getSongs();
        useCase.execute(this, new GetSongsUseCase.Params(mediaType, term));
    }

    public void saveSongs(List<Song> songList){
        this.songList = songList;
    }

    public Song getSong(int position){
        return songList.get(position);
    }

    public void saveSelectedSongId(int selectedSongId){
        this.selectedSongId = selectedSongId;
    }

    public boolean songsListIsEmpty(){
        return songList == null || songList.isEmpty();
    }

    public int getSelectedSongId(){
        return selectedSongId;
    }
}

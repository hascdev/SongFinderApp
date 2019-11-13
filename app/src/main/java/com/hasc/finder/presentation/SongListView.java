package com.hasc.finder.presentation;

import com.hasc.finder.domain.Song;

public interface SongListView extends BaseView {

    void refreshList();

    void cancelRefreshDialog();

    void navigateToDetailScreen(Song song);

}

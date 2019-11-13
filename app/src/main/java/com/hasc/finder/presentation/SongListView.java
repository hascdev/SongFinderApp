package com.hasc.finder.presentation;

public interface SongListView extends BaseView {

    void refreshList();

    void cancelRefreshDialog();

    void navigateToDetailScreen(int songId);

}

package com.hasc.finder.platform.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.hasc.finder.R;
import com.hasc.finder.platform.ui.adapter.SongsAdapter;
import com.hasc.finder.presentation.SongListView;
import com.hasc.finder.presentation.presenters.SongListPresenter;

import javax.inject.Inject;

public class SongListActivity extends BaseActivity implements SongListView {

    public static final String MUSIC_MEDIA_TYPE = "music";
    @Inject
    SongListPresenter presenter;

    private SongsAdapter adapter;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_song_list);

        loadViews();
    }

    private void loadViews() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        refreshLayout = findViewById(R.id.refreshLayout);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        adapter = new SongsAdapter(presenter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        refreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.refresh();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.appSearchBar);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String term) {
                if (term != null && !term.isEmpty()) {
                    presenter.search(MUSIC_MEDIA_TYPE, term);
                }

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void refreshList() {
        adapter.refreshData();
    }

    @Override
    public void cancelRefreshDialog() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void navigateToDetailScreen(int songId) {
        // TODO: ir al detalle de la canción.
    }
}

package com.hasc.finder.platform.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hasc.finder.R;
import com.hasc.finder.domain.Song;
import com.squareup.picasso.Picasso;

public class SongDetailActivity extends AppCompatActivity {

    private Song song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_song_detail);

        song = (Song) getIntent().getSerializableExtra(SongListActivity.EXTRA_SONG);

        loadViews();
    }

    private void loadViews() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(song.getArtistName());

        ImageView artwork = findViewById(R.id.artwork);
        Picasso.get().load(song.getArtworkUrl100()).into(artwork);

        TextView album = findViewById(R.id.album);
        album.setText(song.getCollectionName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_song_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.hasc.finder.platform.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hasc.finder.R;
import com.hasc.finder.domain.Song;
import com.hasc.finder.presentation.SongHolder;
import com.hasc.finder.presentation.presenters.SongListPresenter;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongViewHolder> {

    private SongListPresenter presenter;


    public SongsAdapter(SongListPresenter presenter){
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (parent instanceof RecyclerView ) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_song, parent, false);
            return new SongViewHolder(view);
        } else {
            throw new RuntimeException("Not bound to RecyclerView");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder songViewHolder, int position) {
        presenter.configureCell(songViewHolder, position);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemsCount();
    }

    public void refreshData(){
        notifyDataSetChanged();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder implements SongHolder, View.OnClickListener {

        ImageView artwork;
        TextView name;
        TextView artist;

        public SongViewHolder(View itemView) {
            super(itemView);

            artwork = itemView.findViewById(R.id.artwork);
            name = itemView.findViewById(R.id.name);
            artist = itemView.findViewById(R.id.artist);

            itemView.setOnClickListener(this);
        }

        @Override
        public void display(Song song) {

            name.setText(song.getTrackName());
            artist.setText(song.getArtistName());

            /*
            Picasso.with(imageView.getContext())
                    .load(url)
                    .placeholder(R.drawable.movie_placeholder)
                    .into(imageView);
             */
        }

        @Override
        public void onClick(View view) {
            presenter.onItemClick(getAdapterPosition());
        }

    }
}

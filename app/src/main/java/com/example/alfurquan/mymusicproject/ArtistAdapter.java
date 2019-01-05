package com.example.alfurquan.mymusicproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.MyViewHolder> {
    private Context mContext;
    private List<Artist> artistList;

    public ArtistAdapter(Context mContext, List<Artist> artistList) {
        this.mContext = mContext;
        this.artistList = artistList;
    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.artist_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Artist artist=artistList.get(position);
        holder.title.setText(artist.getName());
        holder.genre.setText(artist.getGenre());
        holder.thumbnail.setImageResource(artist.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView thumbnail;
        private TextView title,genre;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            genre = (TextView) view.findViewById(R.id.title1);

        }
    }
}

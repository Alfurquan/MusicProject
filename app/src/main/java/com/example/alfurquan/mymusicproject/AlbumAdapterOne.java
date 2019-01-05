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

public class AlbumAdapterOne extends RecyclerView.Adapter<AlbumAdapterOne.MyViewHolder> {

    Context context;
    List<Album> albumList;

    public AlbumAdapterOne(Context context, List<Album> albumList) {
        this.context = context;
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_card1,parent,false);
        return  new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AlbumAdapterOne.MyViewHolder holder, int position) {

        Album album = albumList.get(position);
        holder.thumbnail.setImageResource(album.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, artist;
        public ImageView thumbnail;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            artist = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }
}

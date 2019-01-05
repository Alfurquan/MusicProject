package com.example.alfurquan.mymusicproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ArtistFragment1 extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private ArtistAdapter adapter;
    private List<Artist> artistList;

    public ArtistFragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_artist, container, false);
        recyclerView=(RecyclerView)v.findViewById(R.id.recycler_view);
        artistList=new ArrayList<>();
        adapter=new ArtistAdapter(getActivity(),artistList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
     //   recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareArtist();
        return v;
    }
    public void prepareArtist(){
        int[] covers = new int[]{
                R.drawable.artist1,
                R.drawable.artist2,
                R.drawable.artist3,
                R.drawable.artist4,
                R.drawable.artist5,
                R.drawable.artist6,
        };
        Artist a=new Artist("Justin Bieber","English",covers[0]);
        artistList.add(a);
        a=new Artist("Enrique Iglesias","English",covers[1]);
        artistList.add(a);
        a=new Artist("Adele","English",covers[2]);
        artistList.add(a);
        a=new Artist("English Country Music","English",covers[3]);
        artistList.add(a);
        a=new Artist("Selena Gomez","English",covers[4]);
        artistList.add(a);
        a=new Artist("Chainsmokers","English",covers[5]);
        artistList.add(a);
        adapter.notifyDataSetChanged();

    }
}

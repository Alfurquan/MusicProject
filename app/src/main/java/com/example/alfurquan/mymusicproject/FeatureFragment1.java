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

public class FeatureFragment1 extends android.support.v4.app.Fragment {
    private RecyclerView recyclerView;
    private FeaturesAdapter adapter;
    private List<Feature> featureList;
    public FeatureFragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_feature, container, false);
        recyclerView=(RecyclerView)v.findViewById(R.id.recycler_view);
        featureList=new ArrayList<>();
        adapter=new FeaturesAdapter(getActivity(),featureList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
      //  recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareFeatures();
        return v;
    }
    public void prepareFeatures(){
        int[] covers = new int[]{
                R.drawable.love_notes,
                R.drawable.chill1,
                R.drawable.retro1,
                R.drawable.oldies

        };
        Feature a=new Feature("Love Notes","Hindi",covers[0]);
        featureList.add(a);
        a=new Feature("Chill","Hindi",covers[1]);
        featureList.add(a);
        a=new Feature("Retro 70s and 80s","Hindi",covers[2]);
        featureList.add(a);
        a=new Feature("Oldies 50s and 60s","Hindi",covers[3]);
        featureList.add(a);
        adapter.notifyDataSetChanged();
    }
}

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

public class FeaturesAdapter extends RecyclerView.Adapter<FeaturesAdapter.MyViewHolder> {
    private Context mContext;
    private List<Feature> featureList;

    public FeaturesAdapter(Context mContext, List<Feature> featureList) {
        this.mContext = mContext;
        this.featureList = featureList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feature_card, parent, false);

        return new FeaturesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Feature feature = featureList.get(position);
        holder.title.setText(feature.getName());
        holder.genre.setText(feature.getTheme());
        holder.thumbnail.setImageResource(feature.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return featureList.size();
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

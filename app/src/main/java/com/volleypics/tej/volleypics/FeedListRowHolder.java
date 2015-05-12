package com.volleypics.tej.volleypics;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by TejeswaraReddy on 5/12/2015.
 */
public class FeedListRowHolder extends RecyclerView.ViewHolder {
    protected ImageView thumbnail;
    protected TextView title;
    protected TextView description;

    public FeedListRowHolder(View view) {
        super(view);
        this.thumbnail = (ImageView) view.findViewById(R.id.imageView);
        this.title = (TextView) view.findViewById(R.id.title);
        this.description= (TextView) view.findViewById(R.id.description);
    }

}
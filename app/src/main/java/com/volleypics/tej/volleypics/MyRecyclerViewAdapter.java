package com.volleypics.tej.volleypics;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import java.util.List;

/**
 * Created by TejeswaraReddy on 5/12/2015.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<FeedListRowHolder> {

    private List<FeedItem> feedItemList;
    private Context mContext;

    public MyRecyclerViewAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public FeedListRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        FeedListRowHolder mh = new FeedListRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(FeedListRowHolder feedListRowHolder, int i) {
        FeedItem feedItem = feedItemList.get(i);
        feedListRowHolder.title.setText(feedItem.getTitle());
        feedListRowHolder.description.setText(feedItem.getDescription());
        volleyImage(feedListRowHolder.thumbnail, feedItem.getThumbnail());


    }


    private void volleyImage(final ImageView iv, String url){
        // Retrieves an image specified by the URL, displays it in the UI.
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        iv.setImageBitmap(bitmap);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        iv.setImageResource(R.mipmap.placeholder);
                    }
                });
// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(mContext).addToRequestQueue(request);


    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }
}
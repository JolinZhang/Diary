package com.example.jonelezhang.diary;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jonelezhang on 5/27/16.
 */
//ViewHolder's constructor receives a View object, which in our case would be our defined CardView
public class ViewHolder extends RecyclerView.ViewHolder {
    protected TextView title;
    protected TextView createTime;
    protected CardView  cardView;
    protected ImageView photo;
    public ViewHolder(View itemView){
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.noteTitle);
        createTime = (TextView) itemView.findViewById(R.id.noteCreateTime);
        photo = (ImageView) itemView.findViewById(R.id.noteImage);
        cardView = (CardView) itemView;
    }

}

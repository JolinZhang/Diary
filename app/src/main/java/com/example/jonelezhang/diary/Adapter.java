package com.example.jonelezhang.diary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonelezhang on 5/27/16.
 */
public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Note> notes;
    private Context context;
    public Adapter(Context context,List<Note> notes){
        this.context = context;
        this.notes = new ArrayList<Note>();
        this.notes.addAll(notes);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i ) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_list, viewGroup, false);

        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Note note = notes.get(i);
        viewHolder.title.setText(note.getTitle());
        viewHolder.createTime.setText(note.getCreateTime());
        if(note.getImageResourceId() == null)
        {
            int id = context.getResources().getIdentifier("com.example.jonelezhang.diary:drawable/" + "def", null, null);
            viewHolder.photo.setImageResource(id);
        } else{
            //Photo file path and show photo
            String path = Environment.getExternalStorageDirectory().toString() + "/diary_images/";
            String photoPath = path + note.getImageResourceId();
            Bitmap myBitmap = BitmapFactory.decodeFile(photoPath);
            viewHolder.photo.setImageBitmap(Bitmap.createScaledBitmap(myBitmap, 220, 270, false));
        }
    }
    @Override
    public int getItemCount(){
        return notes.size();
    }
}

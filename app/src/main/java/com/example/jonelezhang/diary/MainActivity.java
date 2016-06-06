package com.example.jonelezhang.diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView cardList;
    NotesDatabaseHelper noteHelper;
    private List<Note> noteList;
    private Adapter adapter;
    private ImageButton write;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardList = (RecyclerView) findViewById(R.id.cardList);
        cardList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        cardList.setLayoutManager(llm);

        noteHelper = new NotesDatabaseHelper(MainActivity.this);
        noteList = noteHelper.getAllNote();
        adapter = new Adapter(MainActivity.this,noteList);
        cardList.setAdapter(adapter);


        write = (ImageButton) findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.startAnimation(buttonClick);
                startActivity(new Intent(MainActivity.this, write.class));
            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}

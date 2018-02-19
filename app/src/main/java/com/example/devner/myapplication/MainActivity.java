package com.example.devner.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Note> dataModels;
    private static CustomAdapter adapter;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNote("test notepayload");
            }
        });

        r = new Random();

        lv = (ListView) findViewById(R.id.list);
        dataModels = new ArrayList<>();
        adapter = new CustomAdapter(dataModels, getApplicationContext());

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note dataModel = dataModels.get(position);

                Snackbar.make(view, dataModel.getNotePayload(), Snackbar.LENGTH_SHORT)
                        .setAction("No action", null).show();
            }
        });
    }

    public void addNote(String notePayload) {
        final Note note = new Note(r.nextDouble(), notePayload);
        dataModels.add(note);
        adapter.notifyDataSetChanged();
        System.out.println(dataModels.size());
    }
}

package sg.edu.rp.c346.id22016845.songv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SongDisplay extends AppCompatActivity {
    Button button5;
    ListView displayList;
    ArrayList<Song> songsList;
    CustomAdapter adapter;
    Song song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_display);
        DBHelper dbh = new DBHelper(SongDisplay.this);
        displayList = findViewById(R.id.displayList);
        button5 = findViewById(R.id.fivestarbutton);
        songsList = new ArrayList<Song>();

        adapter = new CustomAdapter(this, R.layout.row ,songsList);
        displayList.setAdapter(adapter);



        displayList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song data = songsList.get(position);
                Intent i = new Intent(SongDisplay.this,EditSong.class);
                i.putExtra("data",data);
                startActivity(i);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songsList.clear();
                songsList.addAll(dbh.getSongsWithFiveStars(5));
                adapter.notifyDataSetChanged();
            }
        });


    }
    @Override
    public void onResume() {
        super.onResume();
        DBHelper db = new DBHelper(SongDisplay.this);
        songsList.clear();
        songsList.addAll(db.getAllSongs());
        adapter.notifyDataSetChanged();
    }

    }

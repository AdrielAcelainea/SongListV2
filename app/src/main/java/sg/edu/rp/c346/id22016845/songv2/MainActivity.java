package sg.edu.rp.c346.id22016845.songv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText title, singers, year;
    Button input, showList;
    RadioGroup stars;
    ArrayList<Song> songsList;
    ArrayAdapter<Song> songsArray;
    int stringStars;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.songTitle);
        singers=findViewById(R.id.songSinger);
        year=findViewById(R.id.songYears);
        stars=findViewById(R.id.stars);
        input=findViewById(R.id.button);
        showList=findViewById(R.id.button2);

        songsList = new ArrayList<Song>();
        songsArray = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1,songsList);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                int checkedRadioId = stars.getCheckedRadioButtonId();
                if (checkedRadioId == R.id.star1){
                     stringStars= 1;
                }else if (checkedRadioId == R.id.star2){
                     stringStars= 2;
                }else if (checkedRadioId == R.id.star3){
                    stringStars = 3;
                }else if (checkedRadioId == R.id.star4){
                    stringStars = 4;
                }else if (checkedRadioId == R.id.star5) {
                    stringStars = 5;
                }
                dbh.insertSong(title.getText().toString(),singers.getText().toString(),Integer.parseInt(year.getText().toString()),stringStars);
                title.setText("");
                singers.setText("");
                year.setText("");
                dbh.close();
            }
        });

        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                Intent i = new Intent(MainActivity.this, SongDisplay.class);
                i.putExtra("song",title.getText().toString());
                i.putExtra("singers",singers.getText().toString());
                i.putExtra("year",year.getText().toString());
                i.putExtra("stars",stringStars);
                startActivity(i);
                songsList.addAll(dbh.getAllSongs());
                songsArray.notifyDataSetChanged();
                dbh.close();
            }
        });
    }
}
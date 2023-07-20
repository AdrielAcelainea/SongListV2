package sg.edu.rp.c346.id22016845.songv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EditSong extends AppCompatActivity {

    EditText title,singers,year,id;
    Song data;
    RadioGroup stars;
    Button update,delete,cancel;
    int starsS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);
        id=findViewById(R.id.editTextText);
        title=findViewById(R.id.editedTitle);
        singers=findViewById(R.id.editedSingers);
        year=findViewById(R.id.editedYear);
        stars=findViewById(R.id.starGroupp);
        update=findViewById(R.id.updateButton);
        delete=findViewById(R.id.deleteButton);
        cancel=findViewById(R.id.cancelButton);
        Intent i = getIntent();

        data = (Song) i.getSerializableExtra("data");
        id.setText(String.valueOf(data.getId()));
        title.setText(String.valueOf(data.getTitle()));
        singers.setText(String.valueOf(data.getSingers()));
        year.setText(String.valueOf(data.getYear()));
        if (data.getStars()==1){
            stars.check(R.id.starr1);
        } else if (data.getStars()==2){
            stars.check(R.id.starr2);
        } else if (data.getStars()==3) {
            stars.check(R.id.starr3);
        } else if (data.getStars()==4){
            stars.check(R.id.starr4);
        } else if (data.getStars()==5) {
            stars.check(R.id.starr5);        }

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(EditSong.this);
                int CheckedRadioId=stars.getCheckedRadioButtonId();
                if(CheckedRadioId == R.id.starr1){
                    starsS=1;
                }else if(CheckedRadioId == R.id.starr2){
                    starsS=2;
                }else if(CheckedRadioId == R.id.starr3){
                    starsS=3;
                }else if(CheckedRadioId == R.id.starr4){
                    starsS=4;
                }else if(CheckedRadioId == R.id.starr5){
                    starsS=5;
                }

                data.setSongTitle(title.getText().toString());
                data.setSingers(singers.getText().toString());
                data.setYear(Integer.valueOf(year.getText().toString()));
                data.setStars(starsS);

                db.updateSong(data);
                db.close();
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(EditSong.this);
                db.deleteSong(data.getId());
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
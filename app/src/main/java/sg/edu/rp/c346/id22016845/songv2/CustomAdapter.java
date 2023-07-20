package sg.edu.rp.c346.id22016845.songv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> songsList;
    public CustomAdapter(Context context, int resource, ArrayList<Song>objects){
        super(context,resource,objects);
        parent_context = context;
        layout_id = resource;
        songsList = objects;

    }
    private String getStarsSymbol(int stars) {
        StringBuilder starsSymbol = new StringBuilder();
        for (int i = 0; i < stars; i++) {
            starsSymbol.append("*");
        }
        return starsSymbol.toString();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.title);
        TextView tvSingers = rowView.findViewById(R.id.singer);
        TextView tvYear = rowView.findViewById(R.id.year);
        TextView tvStars = rowView.findViewById(R.id.stars);

        // Obtain the Android Version information based on the position
        Song currentVersion = songsList.get(position);

        // Set values to the TextView to display the corresponding information
        tvName.setText(currentVersion.getTitle());
        tvSingers.setText(currentVersion.getSingers());
        tvYear.setText(String.valueOf(currentVersion.getYear()));
        String starsSymbol = getStarsSymbol(currentVersion.getStars());
        tvStars.setText(starsSymbol);

        return rowView;

    }


}

package sg.edu.rp.c346.id22016845.songv2;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(int id, String title, String singers, int year, int stars ){
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public void setSongTitle(String title){
        this.title= title;
    }
    public String getSingers(){
        return singers;
    }
    public void setSingers(String singers){
        this.singers= singers;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getStars(){
        return stars;
    }
    public void setStars(int stars){
        this.stars= stars;
    }

    @Override
    public String toString(){
        String ratingStars = "";
        if(stars == 1){
            ratingStars="*";
        }else if(stars == 2){
            ratingStars="**";
        }else if(stars == 3){
            ratingStars="***";
        }else if(stars == 4){
            ratingStars="****";
        }else if(stars == 5){
            ratingStars="*****";
        }
        return "Title: " + title + "\n" + singers + " - " + year +"\n"+ratingStars;
    }
}

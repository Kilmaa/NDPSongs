package sg.edu.rp.c346.id20022404.ndpsongs;

public class Song {
    private int id;
    private String title;
    private String singer;
    private int year;
    private int rating;

    public Song(int id, String title, String singer, int year, int rating) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.rating = rating;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return title + "\n" + singer + " - "+ year + "\n" + (rating*Integer. parseInt("*"));
    }

}

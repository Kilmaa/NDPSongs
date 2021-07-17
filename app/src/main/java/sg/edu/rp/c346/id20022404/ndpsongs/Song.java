package sg.edu.rp.c346.id20022404.ndpsongs;


public class Song {
    private int id;
    private String description;
    private String date;

    public Song(int id, String description, String date) {
        this.id = id;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ID:" + id + ", " + description + date;
    }

}

package model;

public class Song extends Media {
    private String artist; // Соответствует колонке artist в БД

    public Song(int id, String title, String artist) {
        super(id, title);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    @Override
    public void showDetails() {
        System.out.println("Song: " + getTitle() + " | Artist: " + artist);
    }

    @Override
    public String getType() { return "SONG"; }

    @Override
    public void play() {
        System.out.println("Playing: " + getTitle() + " by " + artist);
    }
}
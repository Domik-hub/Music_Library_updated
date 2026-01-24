package model;

public class Song extends Media {
    public Song(int id, String title) { super(id, title); }
    @Override public void play() { System.out.println("Playing song: " + title); }
    @Override public String getType() { return "SONG"; }
    @Override public void showDetails() { System.out.println("Song: " + title); }
    @Override public void validate() throws Exception {
        if (title == null || title.isEmpty()) throw new Exception("Title empty");
    }
}
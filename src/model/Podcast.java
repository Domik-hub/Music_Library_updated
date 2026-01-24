package model;

public class Podcast extends Media {
    public Podcast(int id, String title) { super(id, title); }
    @Override public void play() { System.out.println("Playing podcast: " + title); }
    @Override public String getType() { return "PODCAST"; }
    @Override public void showDetails() { System.out.println("Podcast: " + title); }
    @Override public void validate() throws Exception {
        if (title.length() < 2) throw new Exception("Title too short");
    }
}
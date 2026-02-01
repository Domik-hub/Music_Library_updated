package model;

public abstract class Media implements Playable {
    private int id;
    private String title;

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }
    public abstract void play();
    public abstract String getType();
    public abstract void showDetails();

    public String getSummary() { return "ID: " + id + ", Title: " + title + ", Type: " + getType(); }
}
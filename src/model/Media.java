package model;

public abstract class Media implements Playable, Validatable {
    protected int id;
    protected String title;

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() { return title; }
    public abstract String getType();
    public abstract void showDetails();
}
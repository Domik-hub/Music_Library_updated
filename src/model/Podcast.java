package model;

import exception.InvalidInputException;

public class Podcast extends Media {
    private String host;

    public Podcast(int id, String title, String host) {
        super(id, title);
        this.host = host;
    }

    public String getHost() { return host; }

    @Override
    public void play() {
        System.out.println("Playing podcast: " + getTitle() + " hosted by " + host);
    }

    @Override
    public String getType() { return "PODCAST"; }

    @Override
    public void showDetails() {
        System.out.println("Podcast: " + getTitle() + " | Host: " + host);
    }


    public void validate() throws InvalidInputException {
        if (getTitle() == null || getTitle().length() < 2) {
            throw new InvalidInputException("Podcast title is too short or null!");
        }
        if (host == null || host.isEmpty()) {
            throw new InvalidInputException("Podcast must have a host!");
        }
    }
}
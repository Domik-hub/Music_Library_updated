package model;
import java.util.*;
public class Playlist {
    private List<Media> items = new ArrayList<>();
    public void add(Media m) { items.add(m); }
    public void playAll() {
        for (Media m : items) m.play();
    }
}
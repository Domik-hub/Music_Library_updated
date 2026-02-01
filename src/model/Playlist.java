package model;

import java.util.ArrayList;
import java.util.List;
import utils.SortingUtils;

public class Playlist {
    private int id;
    private String name;
    private List<Media> mediaList;

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;
        this.mediaList = new ArrayList<>();
    }

    public void addMedia(Media media) {
        this.mediaList.add(media);
    }

    public void sortPlaylist() {
        SortingUtils.sortByTitle(this.mediaList); // Используем твою лямбду из утилиты
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public String getName() { return name; }
}
package by.myadel.Homework14;

import java.util.HashMap;

public class Album {
    private String name;
    private HashMap<String, Song> songs = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Song> getSongs() {
        return songs;
    }

    public void setAlbums(String songNumber, Song song) {
        songs.put(songNumber, song);
    }
}

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

    public void addMusicFile(MusicFile musicFile) throws DuplicatedSongException {
        if (songs.containsKey(musicFile.getSongName())) {
            DuplicatedSongException exception = new DuplicatedSongException(songs.get(musicFile.getSongName()));
            exception.setAlbumName(name);
            throw exception;
        } else {
            Song song = new Song();
            song.setName(musicFile.getSongName());
            song.setSongLength(musicFile.getSongLength());
            song.setFilePath(musicFile.getFilePath());
            songs.put(musicFile.getSongName(), song);
        }
    }
}

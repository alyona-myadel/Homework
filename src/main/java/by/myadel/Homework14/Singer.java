package by.myadel.Homework14;

import java.util.HashMap;

public class Singer {
    private String name;
    private HashMap<String, Album> albums = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Album> getAlbums() {
        return albums;
    }

    public void setAlbums(String nameAlbum, Album album) {
        albums.put(nameAlbum, album);
    }

    public void addMusicFile(MusicFile musicFile) throws DuplicatedSongException {
        Album album = null;
        if (albums.containsKey(musicFile.getAlbumName())) {
            album = albums.get(musicFile.getAlbumName());
        } else {
            album = new Album();
            album.setName(musicFile.getAlbumName());
            albums.put(musicFile.getAlbumName(), album);
        }
        try {
            album.addMusicFile(musicFile);
        } catch (DuplicatedSongException e) {
            e.setSingerName(name);
            throw e;
        }
    }
}

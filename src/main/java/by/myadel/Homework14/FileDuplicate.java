package by.myadel.Homework14;


import java.util.LinkedList;

public class FileDuplicate {
    private Song song;
    private LinkedList<String> duplicateLocations = new LinkedList<>();
    private String albumName;
    private String singerName;

    public FileDuplicate(Song song) {
        this.song = song;
    }

    public void addDuplicateLocation(String duplicateLocation) {
        duplicateLocations.add(duplicateLocation);
    }

    public Song getSong() {
        return song;
    }

    public LinkedList<String> getDuplicateLocations() {
        return duplicateLocations;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
}

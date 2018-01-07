package by.myadel.Homework14;

public class DuplicatedSongException extends Exception {
    private Song existSong;
    private String albumName;
    private String singerName;

    public DuplicatedSongException(Song existSong) {
        this.existSong = existSong;
    }

    public Song getExistSong() {
        return existSong;
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

package by.myadel.Homework14;

import java.util.LinkedList;

public class MusicStore {
    private LinkedList<Singer> singers = new LinkedList();

    public LinkedList<Singer> getSingers() {
        return singers;
    }

    public void addSinger(Singer singer) {
        singers.add(singer);
    }

    void parseMusicFile(MusicFile musicFile) {
        Singer singer = new Singer();
        singer.setName(musicFile.getSinger());
        Album album = new Album();
        album.setName(musicFile.getAlbumName());
        Song song = new Song();
        song.setName(musicFile.getSongName());
        album.setAlbums(musicFile.getTrackNumber(), song);
        singer.setAlbums(album.getName(), album);
        singers.add(singer);
    }
}

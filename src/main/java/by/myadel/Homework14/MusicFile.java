package by.myadel.Homework14;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MusicFile {
    private String singer;
    private String songName;
    private String albumName;
    private String trackNumber;

    static MusicFile parseFile(String path) throws InvalidDataException, IOException, UnsupportedTagException, InvalidTackNumberName {
        MusicFile musicFile = new MusicFile();
        Mp3File mp3file = new Mp3File(path);
        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            musicFile.setTrackNumber(parseTrackNumber(id3v2Tag.getTrack()));
            musicFile.setSinger(id3v2Tag.getArtist());
            musicFile.setSongName(id3v2Tag.getTitle());
            musicFile.setAlbumName(id3v2Tag.getAlbum());
        }
        return musicFile;
    }

    private static String parseTrackNumber(String trackNumber) throws InvalidTackNumberName {
        Pattern pattern = Pattern.compile("^(\\d+)/(\\d+)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(trackNumber);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new InvalidTackNumberName();
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getSinger() {
        return singer;
    }

    public String getSongName() {
        return songName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getTrackNumber() {
        return trackNumber;
    }
}

package by.myadel.Homework14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class MusicStore {
    private HashMap<String, Singer> singers = new HashMap<>();
    private HashMap<String, FileDuplicate> fullDuplicates = new HashMap();
    private HashMap<String, FileDuplicate> duplicatesOfMetadata = new HashMap();

    public HashMap<String, Singer> getSingers() {
        return singers;
    }

    public void addSinger(Singer singer) {
        if (!singers.containsKey(singer.getName())) {
            singers.put(singer.getName(), singer);
        }
    }

    public void addMusicFile(MusicFile musicFile) throws DuplicatedSongException {
        Singer singer;
        if (singers.containsKey(musicFile.getSingerName())) {
            singer = singers.get(musicFile.getSingerName());
        } else {
            singer = new Singer();
            singer.setName(musicFile.getSingerName());
            singers.put(musicFile.getSingerName(), singer);
        }
        try {
            singer.addMusicFile(musicFile);
        } catch (DuplicatedSongException duplicatedSong) {
            FileDuplicate fileDuplicate;
            if (getCheckHashSum(musicFile.getFilePath()).equals(getCheckHashSum(duplicatedSong.getExistSong().getFilePath()))) {
                if (fullDuplicates.containsKey(duplicatedSong.getExistSong().getFilePath())) {
                    fileDuplicate = fullDuplicates.get(duplicatedSong.getExistSong().getFilePath());
                } else {
                    fileDuplicate = new FileDuplicate(duplicatedSong.getExistSong());
                    fileDuplicate.setAlbumName(duplicatedSong.getAlbumName());
                    fileDuplicate.setSingerName(duplicatedSong.getSingerName());
                    fullDuplicates.put(duplicatedSong.getExistSong().getFilePath(), fileDuplicate);
                }
                fileDuplicate.addDuplicateLocation(musicFile.getFilePath());
            } else {
                if (duplicatesOfMetadata.containsKey(duplicatedSong.getExistSong().getFilePath())) {
                    fileDuplicate = duplicatesOfMetadata.get(duplicatedSong.getExistSong().getFilePath());
                } else {
                    fileDuplicate = new FileDuplicate(duplicatedSong.getExistSong());
                    fileDuplicate.setAlbumName(duplicatedSong.getAlbumName());
                    fileDuplicate.setSingerName(duplicatedSong.getSingerName());
                    duplicatesOfMetadata.put(duplicatedSong.getExistSong().getFilePath(), fileDuplicate);
                }
                fileDuplicate.addDuplicateLocation(musicFile.getFilePath());
            }
        }
    }

    private String getCheckHashSum(String pathDuplicate) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            FileInputStream fileInputStream = new FileInputStream(pathDuplicate);
            byte[] dataByte = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(dataByte)) > 0) {
                md.update(dataByte, 0, bytesRead);
            }
            byte[] mdBytes = md.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte hashSumByte : mdBytes) {
                stringBuilder.append(String.format("%02x", hashSumByte));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    void printSingers() {
        for (Map.Entry<String, Singer> singerEntry : singers.entrySet()) {
            System.out.println("Исполнитель: " + singerEntry.getKey());
            for (Map.Entry<String, Album> albumEntry : singerEntry.getValue().getAlbums().entrySet()) {
                System.out.println("  Альбом: " + albumEntry.getKey());
                for (Map.Entry<String, Song> songEntry : albumEntry.getValue().getSongs().entrySet()) {
                    System.out.println("    " + songEntry.getValue().getName() + " "
                            + songEntry.getValue().getSongLength() + " " + songEntry.getValue().getFilePath());
                }
            }
        }
    }

    void printDuplicateSinger() {
        for (Map.Entry<String, FileDuplicate> songEntry : fullDuplicates.entrySet()) {
            System.out.println("Дубликат - " + songEntry.getValue().getSong().getName() + ":");
            for (String duplicationLocation : songEntry.getValue().getDuplicateLocations()) {
                System.out.println("    " + duplicationLocation);
            }
        }

        for (Map.Entry<String, FileDuplicate> songEntry : duplicatesOfMetadata.entrySet()) {
            System.out.println("Исполнитель - " + songEntry.getValue().getSingerName() + ", Альбом - " +
                    songEntry.getValue().getAlbumName() + ", Композиция - " + songEntry.getValue().getSong().getName());
            for (String duplicationLocation : songEntry.getValue().getDuplicateLocations()) {
                System.out.println("    " + duplicationLocation);
            }
        }
    }
}

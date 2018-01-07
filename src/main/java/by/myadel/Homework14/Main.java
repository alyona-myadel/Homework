package by.myadel.Homework14;


import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Path dir = Paths.get(args[0]);
        MusicStore musicStore = new MusicStore();
        FileFinder fileFinder = new FileFinder(dir, "mp3");

        fileFinder.find(new FileFinder.FindResultHandler() {

            @Override
            public void handleFile(String path) {
                try {
                    MusicFile musicFile = MusicFile.parseFile(path);
                    musicStore.addMusicFile(musicFile);
                } catch (InvalidTrackNumberException invalidFileName) {
                    System.out.println("В файле не указан номер трека в альбоме или указан неверно." + path);
                    invalidFileName.printStackTrace();
                } catch (UnsupportedTagException e) {
                    System.out.println("Неподдерживаемый ID3 тэг" + path);
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.println("Ошибка ввода/вывода" + path);
                    e.printStackTrace();
                } catch (InvalidDataException e) {
                    System.out.println("Ошибка парсинга ID3" + path);
                    e.printStackTrace();
                } catch (DuplicatedSongException e) {
                    e.printStackTrace();
                }
            }
        });
        musicStore.printSingers();
        musicStore.printDuplicateSinger();
    }
}

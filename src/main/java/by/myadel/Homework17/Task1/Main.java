package by.myadel.Homework17.Task1;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        FileStore fileStore = new FileStore();
        for (String arg : args) {
            Path dir = Paths.get(arg);
            FileFinder fileFinder = new FileFinder(dir, "mp3");
            fileFinder.find(new FileFinder.FindResultHandler() {

                @Override
                public void handleFile(String path) {
                    DataFile dataFile = new DataFile();
                    fileStore.addDataFileInStore(dataFile.parsDataFile(path));
                }
            });
        }
        WriteFile fileXML = new WriteFile();
        fileXML.recordFile(fileStore);
    }
}

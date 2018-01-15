package by.myadel.Homework17.Task2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        FileDataStore fileDataStore = new FileDataStore();
        for (String arg : args) {
            Path dir = Paths.get(arg);
            FileFinder fileFinder = new FileFinder(dir);
            fileFinder.find(new FileFinder.FindResultHandler() {

                @Override
                public void handleFile(String path) {

                    fileDataStore.addDataFile(path);

                }
            });
        }
        WriteFile fileXML = new WriteFile();
        fileXML.recordFile(fileDataStore);
    }
}

package by.myadel.Homework17.Task1;

import java.util.LinkedList;

class FileStore {
    private LinkedList<DataFile> dataFiles = new LinkedList<>();

    void addDataFileInStore(DataFile dataFile) {
        dataFiles.add(dataFile);
    }

    LinkedList<DataFile> getDataFiles() {
        return dataFiles;
    }
}

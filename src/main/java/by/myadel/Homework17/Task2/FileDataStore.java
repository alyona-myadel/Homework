package by.myadel.Homework17.Task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileDataStore {
    private HashMap<String, ArrayList<String>> dataFiles = new HashMap<>();

    void addDataFile(String path) {
        String extension = null;
        try {
            extension = receiveFileFormat(path);
        } catch (InvalidFileFormatException e) {
            e.printStackTrace();
        }
        if (dataFiles.containsKey(extension)) {
            dataFiles.get(extension).add(path);
        } else {
            ArrayList<String> paths = new ArrayList<>();
            paths.add(path);
            dataFiles.put(extension, paths);
        }
    }

    HashMap<String, ArrayList<String>> getDataFiles() {
        return dataFiles;
    }

    private static String receiveFileFormat(String text) throws InvalidFileFormatException {
        Pattern pattern = Pattern.compile(".+\\\\((.+)\\.(\\w+))$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(3);
        }
        throw new InvalidFileFormatException();
    }

    void print() {
        for (Map.Entry<String, ArrayList<String>> data : dataFiles.entrySet()) {
            System.out.println(data.getKey());
            for (String path : dataFiles.get(data.getKey())) {
                System.out.println("    " + path);
            }
        }
    }
}

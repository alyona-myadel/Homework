package by.myadel.Homework17.Task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DataFile {
    private String fileName;
    private String filePath;
    private long fileSize;
    private String dataTime;

    DataFile parsDataFile(String path) {
        DataFile dataFile = new DataFile();
        try {
            dataFile.setFileName(receiveFileNameWithExtension(path));
            dataFile.setFilePath(path);
            dataFile.setFileSize(receiveSizeFile(path));
            dataFile.setDataTime(receiveDateTime(path));
        } catch (IOException ex) {
            System.out.println("Дата создания файла не найдена: " + path);
        } catch (InvalidFileNameException ex) {
            System.out.println("Формат файла не найден: " + path);
        }

        return dataFile;
    }

    String getFileName() {
        return fileName;
    }

    private void setFileName(String fileName) {
        this.fileName = fileName;
    }

    String getFilePath() {
        return filePath;
    }

    private void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    long getFileSize() {
        return fileSize;
    }

    private void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    String getDataTime() {
        return dataTime;
    }

    private void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    private static String receiveFileNameWithExtension(String text) throws InvalidFileNameException {
        Pattern pattern = Pattern.compile(".+\\\\(.+)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new InvalidFileNameException();
    }

    private long receiveSizeFile(String inputPath) {
        File file = new File(inputPath);
        return file.length();
    }

    private String receiveDateTime(String inputPathFile) throws IOException {
        File file = new File(inputPathFile);
        Path pathFile = Paths.get(file.getAbsolutePath());
        BasicFileAttributes attr;
        attr = Files.readAttributes(pathFile, BasicFileAttributes.class);
        if (attr.creationTime() == null) {
            throw new IOException();
        }
        return String.valueOf(attr.creationTime());
    }
}

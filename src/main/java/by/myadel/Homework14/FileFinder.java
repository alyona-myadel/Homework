package by.myadel.Homework14;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFinder {
    public interface FindResultHandler {
        void handleFile(String path);
    }

    private Path path;
    private String extension;

    public FileFinder(Path path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public void find(FindResultHandler resultHandler) {
        findFiles(resultHandler, path);
    }

    private boolean isExtensionFile(String fileName) {
        Pattern pattern = Pattern.compile("\\." + extension + "$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    private void findFiles(FindResultHandler resultHandler, Path path) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path foundPath : stream) {
                if (foundPath.toFile().isDirectory()) {
                    findFiles(resultHandler, foundPath);
                }
                if (isExtensionFile(foundPath.getFileName().toString())) {
                    resultHandler.handleFile(path.toString() + "\\" + foundPath.getFileName().toString());
                }
            }
        } catch (IOException | DirectoryIteratorException x) {
            System.err.println(x);
        }
    }
}

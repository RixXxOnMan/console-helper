package by.boyko.helperapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class ConsoleApp {
    private String homePath;

    public void setup() {

    }

    public ConsoleApp() {

    }

    public List<Path> findByFolderName(String folderName) throws IOException {
        String pathStart = "D:\\";
        List<Path> results = new ArrayList<>();
        Files.walkFileTree(Paths.get(pathStart), Collections.singleton(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (dir.toAbsolutePath().endsWith(folderName)) {
                    results.add(dir);
                    return FileVisitResult.CONTINUE;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                return FileVisitResult.SKIP_SUBTREE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                return FileVisitResult.SKIP_SUBTREE;
            }
        });

        return results;
    }
}


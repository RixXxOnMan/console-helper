package by.boyko.helperapp;

import java.io.File;
import java.util.List;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleApp {
    private String homePath;

    public void setup() {

    }

    public ConsoleApp() {

    }

    public List<Path> findByFolderName(String folderName) throws IOException {
        String pathStart = "D:\\";
        List<Path> results = null;

//        try (Stream<Path> pathStream = Files.find(Paths.get(pathStart), Integer.MAX_VALUE, (p, basicFileAttributes) -> {
//            if (Files.isRegularFile(p) || !Files.isReadable(p) || !Files.isWritable(p)) {
//                return false;
//            }
//
//            return p.endsWith(folderName);
//        }, FileVisitOption.FOLLOW_LINKS)) {
//            results = pathStream.collect(Collectors.toList());
//        } catch (AccessDeniedException ade) {
//            System.out.println("файлик не читаица :((");
//        }

        try (Stream<Path> walk = Files.walk(Paths.get(pathStart))) {
            results = walk.filter(Files::isDirectory)
                    .map(Path::toFile)
                    .filter(File::canWrite)
                    .map(File::toPath)
                    .collect(Collectors.toList());
        }

        return results;
    }
}


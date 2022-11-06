package by.boyko.helperapp;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.List;

/*
* В первую очередь нужно сделать так, чтобы пользователь вводил путь и
* */

public class ConsoleHelper {
    public static void main(String[] args) {
        Path path;
        Scanner scanner = new Scanner(System.in);
        String[] defaultPaths = {"C:\\", "D:\\"};
        System.out.println("Введите название начальной папки");
        String p = scanner.next();
        // пользователь вводит имя папки, в которой будет произведена работа (Desktop)
        if (p == "") {
            path = Paths.get("C:\\");
        }

        ConsoleApp app = new ConsoleApp();
        List<Path> paths = new ArrayList<>();

        try {
            paths = app.findByFolderName(p);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println(paths);
    }
}

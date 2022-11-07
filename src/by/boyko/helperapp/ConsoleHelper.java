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
        String greetings = "Hello! This is a console helper!";
        Path path;
        Scanner scanner = new Scanner(System.in);
        String[] defaultPaths = {"C:\\", "D:\\"};


        System.out.println(greetings);

        System.out.println("Введите название начальной папки");
        String p = scanner.next();
        System.out.println("Ожидайте, поиск нужной папки может занять некоторое время...");
        // пользователь вводит имя папки, в которой будет произведена работа (Desktop)
        if (p == "") {
            path = Paths.get("D:\\");
        }

        ConsoleApp app = new ConsoleApp();
        List<Path> paths = new ArrayList<>();

        try {
            paths = app.findByFolderName(p);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        if (paths.size() > 0) {
            System.out.println("Обнаружено " + paths.size() + " совпадений по имени файла! Какой именно вы предпочтете использовать?");
            for (int i = 0; i < paths.size(); i++) {
                System.out.println((i + 1) + ". " + paths.get(i));
            }
            System.out.println("Нажмите номер пути, который вам подходит: ");
            int userChoice = scanner.nextInt();
            System.out.println("Ваша корневая папка:");
            System.out.println(paths.get(userChoice - 1));
        }
    }
}

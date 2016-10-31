package task2_ListRelativeFileStructure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2_ListRelativeFileStructure {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String directoryName = sc.nextLine();
        ArrayList<File> files = new ArrayList<File>();
        listf(directoryName, files);
        for (File file : files) {
            Path pathAbsolute = Paths.get(file.toString());
            Path pathBase = Paths.get(directoryName);
            Path pathRelative = pathBase.relativize(pathAbsolute);
            System.out.println(pathRelative);
        }
    }

    public static void listf(String directoryName, ArrayList<File> files) throws IOException {
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listf(file.getPath(), files);
            }
        }
    }
}

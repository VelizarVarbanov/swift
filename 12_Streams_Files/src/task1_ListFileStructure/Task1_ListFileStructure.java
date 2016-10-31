package task1_ListFileStructure;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task1_ListFileStructure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String directoryName = sc.nextLine();
        ArrayList<File> files = new ArrayList<>();
        listf(directoryName, files);
        for (File file : files) {
            System.out.println(file);
        }

    }
    public static void listf(String directoryName, ArrayList<File> files) {
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
    }
}

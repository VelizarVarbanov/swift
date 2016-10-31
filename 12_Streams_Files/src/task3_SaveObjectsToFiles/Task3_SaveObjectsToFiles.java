package task3_SaveObjectsToFiles;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3_SaveObjectsToFiles {
    public static void main(String[] args) throws IOException {
        Movie movie = new Movie();
        movie.title = "The God Father";
        movie.director = "Francis Coppola";
        movie.actors = new String[]{"Marlon Brando", "Al Pacino"};
        movie.releaseDate = LocalDate.parse("1972-03-24");
        String fileName = "movie.txt";

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName))) {
            os.writeObject(movie);
        }
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName))) {
            Movie m = (Movie) is.readObject();
            System.out.println(m.title);
            System.out.println(m.director);
            System.out.println(m.releaseDate);
            for (String actor : m.actors) {
                System.out.println(actor);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

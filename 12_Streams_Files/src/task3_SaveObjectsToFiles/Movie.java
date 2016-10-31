package task3_SaveObjectsToFiles;

import java.io.Serializable;
import java.time.LocalDate;

public class Movie implements Serializable{
    String title;
    String director;
    String[] actors;
    LocalDate releaseDate;
}

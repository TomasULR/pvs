package oop.Movies;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class MovieSorting {
    static ArrayList<Movie> loadData(String filePath) {
        ArrayList<Movie> movies = new ArrayList<>();
        DataImport di = new DataImport(filePath);
        String line;
        String[] split;
        while (di.hasNext()) {
            line = di.readLine();
            split = line.split(";");
            movies.add(new Movie(split[0],
                    Integer.parseInt(split[1]),
                    Double.parseDouble(split[2]),
                    Integer.parseInt(split[3])
            ));
        }
        di.finishImport();
        return movies;
    }

    public static void main(String[] args) {
        ArrayList<Movie> movies = loadData("Movies.txt");

        System.out.println("Zadejte 1 BY_NAME");
        System.out.println("Zadejte 2 BY_YEAR");
        System.out.println("Zadejte 3 BY_RATING");

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        switch (s) {
            case "1":
                movies.sort(Movie.BY_NAME);
                System.out.println(movies);;
                break;
            case "2":
                movies.sort(Movie.BY_YEAR.reversed());
                System.out.println(movies);;
                break;
            case "3":
                movies.sort(Movie.BY_RATING);
                for (int i = 10; i > 0; i--) {
                    System.out.println(movies.get(i));
                };
                break;

        }
    }
}

public class Movie implements Comparator<Movie> {

    int Rok;
    String Jmeno;
    Double Rating;
    int Seconds;

    public Movie(String jmeno, int rok, Double rating, int seconds) {
        Rok = rok;
        Jmeno = jmeno;
        Rating = rating;
        Seconds = seconds;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Rok=" + Rok +
                ", Jmeno='" + Jmeno + '\'' +
                ", Rating=" + Rating +
                ", Seconds=" + Seconds +
                '}' + '\n';
    }

    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.Jmeno.compareTo(o2.Jmeno);
    }

    static final Comparator<Movie> BY_NAME = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.Jmeno.compareTo(o2.Jmeno);
        }
    };
    static final Comparator<Movie> BY_YEAR = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.Rok - o2.Rok;
        }
    };
    static final Comparator<Movie> BY_RATING = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o2.Rating.compareTo(o1.Rating);
        }
    };

}
package streaming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class movieList {
    public void main(String[] args) throws IOException {
        ArrayList<Film> movies = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("data\\movieList.txt"));
            String[] params;
            for (String line : lines) {
                params = line.split(";");
                movies.add(new Film(
                        params[0],
                        Integer.parseInt(params[1]),
                        params[2],
                        Double.parseDouble(params[3])));

            }
        } catch (IOException e) {
            System.out.println("Nepodarilo se načíst soubor");
        }

        movies.stream()
                .filter(movie -> movie.year > 2000)
                .forEach(System.out::println);

        System.out.println("====================");

        movies.stream()
                .sorted(Comparator.comparingDouble(Film::getRating))
                .forEach(System.out::println);

        movies.stream()
                .filter(m -> m.genre.equals("Horror"))
                .mapToDouble(m -> m.rating)
                .average()
                .orElse(0);

        List<Film> actionFilm = movies.stream()
                .filter(m -> m.genre.equals("Action") && m.year > 2000)
                .distinct()
                .toList();
    }

    class Film {
        String name;
        int year;
        String genre;
        double rating;

        public Film(String name, int year, String genre, double rating) {
            this.name = name;
            this.year = year;
            this.genre = genre;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "name='" + name + '\'' +
                    ", year=" + year + "\n";
        }
    }
}

package oop.basics.inheritance.polymorphism;

import java.util.Objects;

public class Movie {
    String name;
    int yearOfRelease;
    int lenght;
    int mvID;

    public Movie(String name, int yearOfRelease, int lenght, int mvID) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.lenght = lenght;
        this.mvID = mvID;
    }

    public static void main(String[] args) {
        Movie shrek = new Movie("Shrek", 2004, 5580, 2);
        Movie allsoShrek = new Movie("Shrek", 2004, 5528, 2);
        Movie anotherShrek = new Movie("Shrek", 2004, 5580, 2);

        System.out.println(shrek == allsoShrek);
        System.out.println(shrek.equals(allsoShrek));
        System.out.println(anotherShrek.equals(allsoShrek));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return yearOfRelease == movie.yearOfRelease && mvID == movie.mvID && Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfRelease, mvID);
    }

    @Override
    public String toString() {

        return name + "(" + yearOfRelease + ")";
    }
}

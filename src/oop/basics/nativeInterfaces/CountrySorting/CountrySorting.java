package oop.basics.nativeInterfaces.CountrySorting;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CountrySorting {
    static ArrayList<Country> loadData(String filePath) {
        ArrayList<Country> countries = new ArrayList<>();
        DataImport di = new DataImport(filePath);
        String[] split;
        String line;

        while (di.hasNext()) {
            line = di.readLine();
            split = line.split(",");

            countries.add(new Country(split[0], split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3])));
        }

        return countries;
    }

    public static void main(String[] args) {
        ArrayList<Country> countries = loadData("countries.txt");

        //Collections.sort(Country.BY_NAME);
        System.out.println(countries);
        countries.sort(new CountryComparator());

        Comparator<Country> lifeCompare = new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return Double.compare(o1.lifeExpectancy, o2.lifeExpectancy);
            }

        };
        countries.sort(lifeCompare);
        System.out.println(countries);

    }
}

class Country implements Comparable<Country> {
    String name, continent;
    int population;
    double lifeExpectancy;

    static final Comparator<Country> BY_NAME = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return o1.name.compareTo(o2.name);
        }
    };
    static final Comparator<Country> BY_LIFE = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    public Country(String name, String continent, int population, double lifeExpectancy) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
    }

    @Override
    public String toString() {
        return " \n " + name + ", " + population + ", " + lifeExpectancy;
    }

    @Override
    public int compareTo(Country o) {
        return this.population - o.population;
    }


}
class CountryComparator implements Comparator<Country>{

    @Override
    public int compare(Country o1, Country o2) {
        return o1.name.compareTo(o2.name);
    }
}

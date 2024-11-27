package oop.basics.test.test2;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.*;

public class globe {
    static ArrayList<City> loadData(String filePath) {
        ArrayList<City> cities = new ArrayList<>();
        DataImport di = new DataImport(filePath);
        String[] split;
        String line;

        while (di.hasNext()) {
            line = di.readLine();
            split = line.split(",");

            cities.add(new City(split[0], split[1], split[2]));
        }

        return cities;
    }


    public static void main(String[] args) {
        DataExport de = new DataExport("Citiesuniq.txt");
        ArrayList<City> cities = loadData("Cities.txt");


        ArrayList<City> subsetCity = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {
            subsetCity.add(cities.get(i));
        }

        ArrayList<String> countries = new ArrayList<>();

        for (int i = 0; i < cities.size(); i++) {
           countries.add(cities.get(i).Country);
        }
        HashSet<String> subSetCountries = new HashSet<>(countries);

        HashSet<City> subSet = new HashSet<>(subsetCity);
        ArrayList<City> actualSubsetCity = new ArrayList<>(new HashSet<>(subsetCity));

        System.out.println("Počet neunikátních měst " + subsetCity.size());
        System.out.println("Počet měst " + subSet.size());
        System.out.println("Počet států "+ subSetCountries.size());



        System.out.println("počet neunikátních měst: " + (subsetCity.size() - subSet.size()));
        actualSubsetCity.sort(City.BY_CONTINENT);
        //System.out.println("Města seřazené se státy: " + actualSubsetCity);


        for (int i = 0; i < subSet.size(); i++) {
            de.writeLine(String.valueOf(actualSubsetCity.get(i)));
        }

        de.finishExport();
    }

}

class City implements Comparator{
    String name;
    String Country;
    String Contitnet;





    public City(String name, String country, String contitnet) {
        this.name = name;
        Country = country;
        Contitnet = contitnet;
    }

    static final Comparator<City> BY_NAME = new Comparator<City>() {
        @Override
        public int compare(City o1, City o2) {
            return o1.name.compareTo(o2.name);
        }
    };
    static final Comparator<City> BY_COUNTRY = new Comparator<City>() {
        @Override
        public int compare(City o1, City o2) {
            return o1.Country.compareTo(o2.Country);
        }
    };


    static final Comparator<City> BY_CONTINENT = new Comparator<City>() {
        @Override
        public int compare(City o1, City o2) {
            return o1.Contitnet.compareTo(o2.Contitnet);
        }
    };
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) && Objects.equals(Country, city.Country) && Objects.equals(Contitnet, city.Contitnet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Country, Contitnet);
    }

}

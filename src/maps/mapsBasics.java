package maps;

import java.util.HashMap;
import java.util.Map;

public class mapsBasics {
    public static void main(String[] args) {
        HashMap<String, String> countries = new HashMap<>();
        countries.put("USA", "Washington DC");
        countries.put("SK", "Bratislava");
        countries.put("CZ", "Praha");

        System.out.println(countries.size());
        System.out.println(countries.get("CZ"));
        System.out.println(countries.getOrDefault("CZ", "No country found"));
        countries.replace("CZ", "Plzen");
        System.out.println(countries);
        countries.remove("CZ", "Praha");

        countries.containsKey("CZ");
        countries.containsValue("Bratislava");

        for (String country: countries.keySet()) {

        }

        for (Map.Entry<String, String> entry : countries.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        double avreageNamelENGHT = countries.values().stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
        System.out.println(avreageNamelENGHT);
    }
}

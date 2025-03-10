package streaming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class health {
    public static void main(String[] args) {
        ArrayList<Customer> Customers = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("data\\health.csv"));
            String[] params;
            for (String line : lines) {
                params = line.split(",");
                Customers.add(new Customer(
                        params[0],
                        Integer.parseInt(params[1]),
                        params[2],
                        params[3],
                        Double.parseDouble(params[4])));

            }
        } catch (IOException e) {
            System.out.println("Nepodarilo se načíst soubor");
        }

        System.out.println(Customers.stream()
                .filter(m -> m.BlodType.equals("A-") && m.Age > 20 && m.Age < 50)
                .count() + " má skupinu A-");


        System.out.println((((double) Customers.stream()
                .filter(m -> m.BlodType.equals("O+"))
                .count() + (double) Customers.stream()
                .filter(m -> m.BlodType.equals("O-"))
                .count()) / Customers.size()) * 100 + " " + " je pomer");


        int a = (int) Customers.stream()
                .filter(m -> m.Gender.equals("Female")).count();

        int b = (int) Customers.stream()
                .filter(m -> m.Gender.equals("Female"))
                .map(m -> m.Name.toLowerCase())
                .distinct().count();

        System.out.println(  a - b + " " + " Počet duplicitních žen");



        Customers.stream()
                .filter(m -> m.Cost < 5000 && m.BlodType.contains("+"))
                .forEach(m -> System.out.println(m.Name + " " + m.Cost + " " + m.BlodType));

        ArrayList<Customer> BlessedOnes = new ArrayList<>();

        Customers.stream()
                        .filter(m -> m.BlodType.contains("O") || m.BlodType.contains("B"))
                .forEach(BlessedOnes::add);

        //System.out.println(        BlessedOnes.size());

        System.out.println(Customers.stream().filter(m -> m.Gender.equals("Female"))
                .mapToDouble(m -> m.Cost)
                .sum());
    }

}

class Customer {
    String Name;
    int Age;
    String Gender;
    String BlodType;
    Double Cost;

    public Customer(String name, int age, String gender, String blodType, Double cost) {
        Name = name;
        Age = age;
        Gender = gender;
        BlodType = blodType;
        Cost = cost;
    }
}

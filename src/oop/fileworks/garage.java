package oop.fileworks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Garage {
    public static void main(String[] args) throws IOException {
        List<String> cars = Files.readAllLines(Paths.get("garage.txt"));
        List<Car> carObjects = new ArrayList<>();

        for (String line : cars) {
            String[] params = line.split(",");
            if (params.length == 4) {
                carObjects.add(new Car(
                        params[0].trim(),
                        params[1].trim(),
                        Integer.parseInt(params[2].trim()),
                        Boolean.parseBoolean(params[3].trim())
                ));
            }
        }

        // Výpis vytvořených objektů
        carObjects.forEach(System.out::println);

        // Příklad seřazení podle barvy
        carObjects.sort(Car::compareTo);
        System.out.println("\nSeřazeno podle barvy:");
        carObjects.forEach(System.out::println);
    }
}

class Car implements Comparable<Car> {
    String color;
    String model;
    int engineSize;
    Boolean drivable;

    public Car(String color, String model, int engineSize, Boolean drivable) {
        this.color = color;
        this.model = model;
        this.engineSize = engineSize;
        this.drivable = drivable;
    }

    @Override
    public int compareTo(Car o) {
        return this.color.compareTo(o.color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", engineSize=" + engineSize +
                ", drivable=" + drivable +
                '}';
    }
}

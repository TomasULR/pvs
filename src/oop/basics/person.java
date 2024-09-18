package oop.basics;

import fileworks.DataImport;

import java.io.DataInput;

public class person {
    public static void main(String[] args) {
        DataImport di = new DataImport("osoba.txt");
        String line;
        String[] atr;

        Person p = new Person("TMP", Integer.MIN_VALUE,0,0);
        while (di.hasNext()){
            line = di.readLine();
            atr = line.split(",");
            p = new Person(atr[0], Integer.parseInt(atr[1]), Integer.parseInt(atr[2]), Integer.parseInt(atr[3]) );
            System.out.println(p);
        }
        System.out.println("Tallest person: " + tallest);

        di.finishImport();
    }

}
class Person{
        String fullName;
        int height;
        int weight;
        int age;

    public Person(String fullName, int height, int weight, int age) {
        this.fullName = fullName;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}
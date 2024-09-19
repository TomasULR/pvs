package oop.basics;

import fileworks.DataImport;
public class Human {
    public static void main(String[] args) {
        DataImport di = new DataImport("osoba.txt");
        String line;
        String[] atr;
        Person p;

        Person tallest = new Person("TMP", Integer.MIN_VALUE,0,0);
        while (di.hasNext()){
            line = di.readLine();
            atr = line.split(",");
            p = new Person(atr[0], Integer.parseInt(atr[1]), Integer.parseInt(atr[2]), Integer.parseInt(atr[3]) );
            if (p.height > tallest.height){
                tallest = p;
            }
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
package oop.basics.nativeInterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedMap;

public class NativeInterfaces {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Carl", 25, 46.3));
        persons.add(new Person("Old Carl", 95, 44.3));
        persons.add(new Person("Jarmil", 19, 40.3));
        persons.add(new Person("Radim", 33, 50.3));

        System.out.println(persons);

        Collections.sort(persons);

        System.out.println(persons);
    }


}
class Person implements Comparable<Person>{
    String name;
    int age;
    double shoeSize;

    public Person(String name, int age, double shoeSize) {
        this.name = name;
        this.age = age;
        this.shoeSize = shoeSize;
    }

    @Override
    public String toString() {
        return '\n' + "Name: "+ name + " Age: "+ age + " Shoe size: "+ shoeSize;
    }

    @Override
    public int compareTo(Person o) {


        //return this.age - o.age;
        return o.age - this.age;
        //return this.name.compareTo(o.name);
        //return (int)(this.shoeSize - o.shoeSize);
    }
}



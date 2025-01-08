package oop.fileworks.serialization;

import java.io.*;

public class MultipleSerial {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cordinates c1 = new Cordinates(5,6,8);
        Cordinates c2 = new Cordinates(85,8,8);
        Cordinates c3 = new Cordinates(5,27,8);
        Cordinates c4 = new Cordinates(5,6,8);


        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.ser"));
        oos.writeObject(c1);
        oos.writeObject(c2);
        oos.writeObject(c3);
        oos.writeObject(c4);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.ser"));

        Cordinates d1 = (Cordinates) ois.readObject();
        Cordinates d2 = (Cordinates) ois.readObject();
        Cordinates d3 = (Cordinates) ois.readObject();
        Cordinates d4 = (Cordinates) ois.readObject();

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);

    }
}

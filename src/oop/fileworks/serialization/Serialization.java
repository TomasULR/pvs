package oop.fileworks.serialization;

import java.io.*;

public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //serializace
        Cordinates cordinates = new Cordinates(5,0,10);
        System.out.println("export>" + cordinates);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("single_cord.ser"));
        oos.writeObject(cordinates);

        oos.close();
        //deserializace

        Cordinates deserilized = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("single_cord.ser"));

        deserilized = (Cordinates) ois.readObject();

        System.out.println("import> " + deserilized);
    }
}

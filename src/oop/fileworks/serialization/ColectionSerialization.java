package oop.fileworks.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ColectionSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Cordinates> cordinates = new ArrayList<>();
        cordinates.add(new Cordinates(9,8,7));
        cordinates.add(new Cordinates(9,8,7));
        cordinates.add(new Cordinates(9,8,7));
        cordinates.add(new Cordinates(9,8,7));
        cordinates.add(new Cordinates(9,8,7));
        cordinates.add(new Cordinates(9,8,7));
        cordinates.add(new Cordinates(9,8,7));
        cordinates.add(new Cordinates(9,8,7));
        cordinates.add(new Cordinates(9,8,7));
        cordinates.add(new Cordinates(9,8,7));
        cordinates.add(new Cordinates(9,8,7));
        cordinates.add(new Cordinates(9,8,7));
        cordinates.add(new Cordinates(9,8,7));
        cordinates.add(new Cordinates(9,8,7));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file2.ser"));
        oos.writeObject(cordinates);
        oos.close();

        List<Cordinates> deseralizedCordinates = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("File2.ser"));
        deseralizedCordinates = (List<Cordinates>) ois.readObject();
        ois.close();

        System.out.println(cordinates.size());
        System.out.println(deseralizedCordinates.size());
    }
}

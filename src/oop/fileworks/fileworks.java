package oop.fileworks;

import java.io.File;
import java.util.Arrays;

public class fileworks {


    public static void main(String[] args) {
        File file = new File("Cities.txt");
        File folder = new File("src");
        //File oFolder = new File("C:\\Users\\tomas.ulrych\\Desktop\\");

        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println("Size: " + file.length());
        System.out.println("Size kB: " + (file.length()/1000));
        System.out.println(file.exists()); //o adresář vejš
        System.out.println(file.getParent());
        System.out.println(file.exists());

        System.out.println(folder.isDirectory());
        System.out.println(Arrays.toString(folder.list()));
        System.out.println(Arrays.toString(folder.listFiles()));


    }
}

package oop.basics.generics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Setting {
    public static void main(String[] args) {

        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 121 );
        }

        System.out.println(Arrays.toString(array));

        Set<Integer> uniqNumbers = new HashSet<>();

        while (uniqNumbers.size() < 100){
            uniqNumbers.add((int)(Math.random() * 121 ));

        }
        System.out.println(uniqNumbers);

        ArrayList<Integer> tuniqNumbers = new ArrayList<>();

        while(tuniqNumbers.size() < 100){
            tuniqNumbers.add((int)(Math.random() * 200 ));

        }
        System.out.println(tuniqNumbers);

    }
}
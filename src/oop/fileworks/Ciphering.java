package oop.fileworks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ciphering {
    public static void main(String[] args) throws IOException {
        Caesar cipher = new Caesar(3, "Caesar cipher");
        List<String> lines = Files.readAllLines(Paths.get("inputs.txt"));

        System.out.println("Original");
        System.out.println(lines);
        //pro ucely debugu, ulozit cely soubor do promenne
        ArrayList<String> encryptedLines = new ArrayList<>();
        for (String line : lines){
            encryptedLines.add(cipher.encrypt(line));
        }

        System.out.println("Encrypted:");
        System.out.println(encryptedLines);

        //nahazet do souboru:
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("encryptedTest.txt")));
        for (String line : encryptedLines){
            writer.println(line);
        }
        writer.close();

        lines = Files.readAllLines(Paths.get("encryptedTest.txt"));
        System.out.println("Decrypted");
        for (String line : lines){
            System.out.println(cipher.decrypt(line));
        }



    }
}
abstract class Cipher{
    int key;
    String name;

    public Cipher(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cipher name:" + name + " secret: " + key;
    }

    abstract String encrypt(String input);

    abstract String decrypt(String encryptedInput);

}
class Caesar extends Cipher{

    public Caesar(int key, String name) {
        super(key, name);
    }

    @Override
    String encrypt(String input) {
        return null;
    }

    @Override
    String decrypt(String encryptedInput) {
        return null;
    }
}
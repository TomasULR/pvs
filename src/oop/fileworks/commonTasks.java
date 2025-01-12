package oop.fileworks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class commonTasks {
    public static void main(String[] args) throws IOException {

        // vygeneruj soubor plny nahodnych cisel
        // path, lines (5000) (-10000; 10000), printwriter
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tasks.txt")));
        for (int i = 0; i < 5000; i++) {
            out.println((int) (Math.random()*20001-10000));
        }
        out.close();

        //u souboru spočitat řádky
        List<String> lines = Files.readAllLines(Paths.get("tasks.txt"));
        System.out.println(lines.size());
        
        //jake radky obsahuji kladna cisla
        for (int i = 0; i < lines.size(); i++) {
            if(Integer.parseInt(lines.get(i)) > 0) {
                System.out.println(i + " -- " + lines.get(i));
            }
        }
        
        //
    }
}

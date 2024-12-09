package oop.fileworks;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ReadingExamples {
    public static void main(String[] args) throws IOException {
        File file = new File("data/countries.txt");
        if (file.exists() && file.isFile()){
            FileReader reader = new FileReader(file);
            int input;
            while(((input = reader.read()) != -1)){
                //System.out.print((char) input);
            }
            reader.close();
        }
        int vets =0;
        int otazeks =0;
        int vykricniks =0;
        int slov =0;
        List<String> lines = Files.readAllLines(Paths.get("inputs.txt"));
        for (String line : lines){
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == '.') vets++;
                if(line.charAt(i) == ' ') slov++;
                if(line.charAt(i) == '!') vykricniks++;
                if(line.charAt(i) == '?') otazeks++;


            }
        }
        System.out.println(vets + " " + otazeks + " " + vykricniks + " " + slov);
    }
}

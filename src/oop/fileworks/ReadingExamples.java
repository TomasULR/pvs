package oop.fileworks;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadingExamples {
    public static void main(String[] args) throws IOException {
        File file = new File("data/countries.txt");
        if (file.exists() && file.isFile()){
            FileReader reader = new FileReader(file);
            int input;
            while(((input = reader.read()) != -1)){
                System.out.print((char) input);
            }
            reader.close();
        }
    }
}

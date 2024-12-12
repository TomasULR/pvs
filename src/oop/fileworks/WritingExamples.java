package oop.fileworks;

import javax.sound.sampled.Line;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WritingExamples {
    public static void main(String[] args) throws IOException {

        FileWriter fr = new FileWriter("out1.txt");

//po char
        for (int i = 0; i < 100; i++) {
            fr.write(String.valueOf((int)(Math.random()*4001)));
            fr.write('\n');
        }

        fr.close();

        //po radcich
        BufferedWriter bw = new BufferedWriter(new FileWriter("out2.txt"));
        for (int i = 0; i < 4000; i++) {
            bw.write(String.valueOf((int)(Math.random()*4001)));
            bw.newLine();
        }
        bw.close();


        //po radcich
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("out3.txt")));
        for (int i = 0; i < 4000; i++) {
            pw.println(String.valueOf((int)(Math.random()*4001)));
        }
        pw.close();


    }
}

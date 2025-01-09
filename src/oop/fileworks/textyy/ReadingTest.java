package oop.fileworks.textyy;


import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class ReadingTest {
    static ArrayList<String> getTexts(String filePath, int from, int to) throws IOException {
        ArrayList<String> texts = new ArrayList<>();
        String line;

        for (int i = from; i <= to; i++) {
            BufferedReader br = new BufferedReader(new FileReader(filePath+ "\\" + "\\*.txt"));
            while((line = br.readLine()) != null){

                    texts.add(line);

            }
            br.close();
        }
        return texts;
    }

    static void printFile(ArrayList<String> texts, String filePath) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
        for (String text : texts){
            pw.println(texts);
        }
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        String dirPath = "testData";
        File fileDir = new File(dirPath);
        if(fileDir.exists() && fileDir.isDirectory()){
            ArrayList<String> evens = getTexts("testData", 1,4);
        }

    }


}

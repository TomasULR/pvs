package oop.fileworks;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Dictionary;

public class FileFilter implements Comparator {
    static ArrayList<File> getFilesByType(String dirPath, String fileType){
        ArrayList<File> filteredFieles = new ArrayList<>();
        File someFile = new File(dirPath);
        if (someFile.exists() && someFile.isDirectory()){
            File[] dirContent = someFile.listFiles();
            for (File file : dirContent){
                if (file.isFile() && file.getName().endsWith(fileType)){
                    filteredFieles.add(file);
                }
            }
        }
        return filteredFieles;
    }
    static void printSortedFiles(ArrayList<File> files){

        files.sort(BY_SIZE);

        for (File file : files){
            System.out.println(file.toString());
        }

    }

    public static void main(String[] args) {


        printSortedFiles(getFilesByType("testData", ".txt"));



    }

    static final Comparator<File> BY_SIZE = new Comparator<File>() {
        @Override
        public int compare(File o1, File o2) {
            return (int) (o1.getTotalSpace()-o2.getTotalSpace());
        }
    };
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}

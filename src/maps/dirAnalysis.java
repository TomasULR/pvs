package maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class dirAnalysis {

    public static void analyzeDir(String path) throws IOException {
        Path p = Paths.get(path);
        try (Stream<Path> fileStream = Files.walk(p)) {
//           fileStream.forEach(System.out::println);

            List<Path> filePaths = fileStream
                    .filter(Files::isRegularFile)
                    .toList();
            System.out.println(filePaths);

            Map<String, Long> fileTypeCount = filePaths.stream()
                    .collect(Collectors.groupingBy(
                            filePath -> getExtension(filePath.getFileName().toString()),
                            Collectors.counting()//pocty souboru v groupe
                    ));
            //fuj vypis
            System.out.println(fileTypeCount);
            //nice vypis
            fileTypeCount.forEach((ext, count) ->
                    System.out.println(ext + ": " + count + " souboru")
            );

            //velikost vsech souboru celkem dle typu
            Map<String, Long> fileTypeSizeTotal = filePaths.stream()
                    .collect(Collectors.groupingBy(
                            filePath -> getExtension(filePath.getFileName().toString()),
                            Collectors.summingLong( p1 -> { //specifikuju, ze bude scitat sumu
                                try{
                                    return Files.size(p1); //musim specifikovat ceho, Path ma hodne atributu
                                } catch (IOException e){
                                    return 0L;
                                }
                            })
                    ));
            System.out.println(fileTypeSizeTotal);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static String getExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        return (dotIndex == -1) ? "NO_TYPE" : fileName.substring(dotIndex + 1).toLowerCase();
    }

    public static void main(String[] args) {
        try {
            analyzeDir("data\\testData");
        } catch (IOException e) {
            System.out.println("Zpracovani souboru nevyslo: " + e.getMessage());
        }
    }
}
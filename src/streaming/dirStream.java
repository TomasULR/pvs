package streaming;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class dirStream {
    public static void main(String[] args) {

        //File f = new File("cesta").listFiles();

        Path start = Paths.get("data");
        try (Stream<Path> fileStream = Files.walk(start)){
            fileStream
                    .filter(p -> p.endsWith(".java"))
                    .count();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

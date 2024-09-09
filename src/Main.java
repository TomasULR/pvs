import fileworks.DataImport;

public class Main {
    public static void main(String[] args) {
        DataImport de = new DataImport("inputs.txt");
        de.printFile();
        de.finishImport();
    }
}
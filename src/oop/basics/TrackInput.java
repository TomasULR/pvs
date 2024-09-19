package oop.basics;

import fileworks.DataExport;
import fileworks.DataImport;

public class TrackInput {
    public static void main(String[] args) {
        DataImport di = new DataImport("Tracks.txt");
        DataExport de = new DataExport("exptrack.txt");

        String[] params;
        String line;
        Songs s;
        while (di.hasNext()){
            line = di.readLine();
            params = line.split(";");
            s = new Songs(
                    params[0],
                    Integer.parseInt(params[1]),
                    Double.parseDouble(params[2]),
                    Integer.parseInt(params[3])

            );
            de.writeLine(s.toString());
            System.out.println(s);

        }
        de.finishExport();
        di.finishImport();
    }
}

class  Songs{
    String name;
    int yearOfRelease;
    double rating;
    int seconds;

    public Songs(String name, int yearOfRelease, double rating, int seconds) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return name + " - " + yearOfRelease;
    }

    String timeFormat(){
        return seconds/60 + ":" + seconds%60;
    }
}

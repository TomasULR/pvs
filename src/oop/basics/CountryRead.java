package oop.basics;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;

public class CountryRead {



    public static void main(String[] args) {

        DataImport di = new DataImport("countries.txt");
        DataExport de = new DataExport("exptrackZ.txt");

        String[] params;
        String line;
        Country c;
        double counttt = 0;
        ArrayList ageavr = new ArrayList();
        double counter = 0;
        int europecounter = 0;
        int totaly = 0;


        int MaxArea = 0;
        int lastAre = 0;
        String areMax = "";
        while (di.hasNext()){
            line = di.readLine();
            params = line.split(";");
            counttt += Double.parseDouble(params[3]);
            ageavr.add(Double.parseDouble(params[3]));
            c = new Country(
                    params[0],
                    params[1],
                    Integer.parseInt(params[2]),
                    Double.parseDouble(params[3])

            );

            ageavr.add(c);
            counter++;
            if(params[1].equals("Europe")){
                europecounter++;
            }


            lastAre = Integer.parseInt(params[2]);
            if (lastAre > MaxArea){
                MaxArea = lastAre;
                areMax = params[0];

            }


            //de.writeLine(c.toString());
            //System.out.println(ageavr);


        }



        de.finishExport();
        di.finishImport();

        System.out.println("Vek doziti "+counttt/counter);
        System.out.println("europecounter "+europecounter);
        System.out.println("MaxPopulation " + areMax);




    }


}

class  Country{
    String name;
    String continent;
    int area;
    double expectedAge;

    public Country(String name, String continent, int area, double expectedAge) {
        this.name = name;
        this.continent = continent;
        this.area = area;
        this.expectedAge = expectedAge;
    }

    @Override
    public String toString() {
        return ""+expectedAge;
    }
}

package oop.basics.kronika;

import fileworks.DataExport;
import fileworks.DataImport;
import oop.basics.prep.Hunter;
import oop.basics.prep.Soldier;
import oop.basics.prep.Witcher;

import java.util.ArrayList;
import java.util.Collections;

public class kronika {
    public static void main(String[] args) {

        DataImport di = new DataImport("kronika.txt");
        DataExport de = new DataExport("kronikaexp.txt");
        String[] params;
        String line;
        ArrayList<String> fullparams = new ArrayList<>();
        while (di.hasNext()) {
            line = di.readLine();
            params = line.split(",");

            for (int i = 0; i < params.length; i++) {
                fullparams.add(params[i]);
            }

        }


        Collections.reverse(fullparams);


        for (int i = 0; i < fullparams.size(); i++) {
            de.writeLine(fullparams.get(i));
        }

        de.finishExport();
        di.finishImport();
    }
}

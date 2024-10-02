package oop.basics.inheritance;

import fileworks.DataExport;
import fileworks.DataImport;
import oop.basics.prep.Hunter;
import oop.basics.prep.Soldier;
import oop.basics.prep.Witcher;

import java.util.ArrayList;
import java.util.Arrays;

public class Hospital {
    public static void main(String[] args) {

        ArrayList<Doctor> doctors = new ArrayList<>();
        DataImport di = new DataImport("procedures.txt");
        String[] params;
        String line;
        int initSalary = 50000;
        int counter = 0;
        while (di.hasNext()) {
            line = di.readLine();
            params = line.split(",");
            switch (params[1]) {
                case "DOC":
                    doctors.add(new Doctor(params[0], initSalary));
                    break;
                case "SUR":
                    doctors.add(new Surgeon(params[0], initSalary));
                    break;
                case "CAR":
                    doctors.add(new CardioSurgeon(params[0], initSalary));
                    break;
            }
            System.out.println(doctors.get(counter).name);
            doJob(params, doctors, counter);

            counter++;

        }

        getmost(doctors);
        getLeast(doctors);
        getReport(doctors);


        di.finishImport();
    }


    static void getmost(ArrayList<Doctor> doctors){
        Doctor max = new Doctor("max", 0);
        for (Doctor d: doctors) {
            if (d.salary > max.salary){
                max.salary = d.salary;
                max.name = d.name;
            }
        }
        System.out.println("Nejvetsi salary ma " + max.name + " a to " + max.salary);
    }

    static void getLeast(ArrayList<Doctor> doctors){
        int min = 0;
        String minname = "";
        min = doctors.get(0).salary;
        for (Doctor d: doctors) {
            if (d.salary < min){
                min = d.salary;
                minname = d.name;
            }
        }
        System.out.println("Nejmensi salary ma " + minname + " a to " + min);
    }


    static void doJob(String[] params, ArrayList<Doctor> doctors, int counter) {
        for (int i = 2; i < params.length; i++) {
            switch (params[i]) {
                case "D":
                    doctors.get(counter).diagnose();

                    break;
                case "S":
                    if (doctors.get(counter) instanceof Surgeon) {
                        ((Surgeon) (doctors.get(counter))).surgery();
                    } else {
                        System.out.println("Nekvalifikovany");
                        doctors.get(counter).salary -= 50000;
                    }
                    break;
                case "C":
                    if (doctors.get(counter) instanceof CardioSurgeon) {
                        ((CardioSurgeon) (doctors.get(counter))).cardioSurgery();
                    } else {
                        System.out.println("Nekvalifikovany");
                        doctors.get(counter).salary -= 50000;
                    }
                    break;
            }
        }
    }

    static void getReport(ArrayList<Doctor> doctors){
        DataExport de = new DataExport("report.txt");

        for (Doctor d: doctors) {
            de.writeLine(d.name+ ": " + d.salary);
        }
        de.finishExport();
    }
}


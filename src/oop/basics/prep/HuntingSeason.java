package oop.basics.prep;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Random;

class HuntingSeason {
    static void doRandomJob(Hunter tester, int job) {
        switch (job) {
            case 1:
                tester.hunt(); //tohle by melo projit vzdy
                System.out.println(tester.gold);
                break;
            case 2:
                try {
                    ((Soldier) tester).killBandits(); //tohle jen nekdy
                    System.out.println(tester.gold);

                } catch (Exception e) {
                    System.out.println(tester.name + " to nezvladne");
                    tester.gold -= 100;
                }
                break;
            case 3:
                try {
                    ((Witcher) tester).slayMonster(); // tohle jeste minkrat
                    System.out.println(tester.gold);

                } catch (Exception e) {
                    System.out.println(tester.name + " to nezvladne");
                    tester.gold -= 100;
                }
                break;
        }
    }

    public static void main(String[] args) {
        ArrayList<Hunter> hunters = new ArrayList<>();
        DataImport di = new DataImport("hunters.txt");
        String[] params;
        String line;
        int counter = 0;
        while (di.hasNext()) {
            line = di.readLine();
            params = line.split(",");
            switch (params[1]) {
                case "Hunter": hunters.add(new Hunter(params[0])); break;
                case "Soldier": hunters.add(new Soldier(params[0])); break;
                case "Witcher": hunters.add(new Witcher(params[0])); break;
            }
                for (int i = 2; i <= params.length-1; i++) {
                    switch (params[i]) {
                        case "H": doRandomJob(hunters.get(counter), 1); break;
                        case "K": doRandomJob(hunters.get(counter), 2); break;
                        case "M": doRandomJob(hunters.get(counter), 3); break;
                    }
                }
            counter++;
        }
        di.finishImport();
        Hunter MAX = new Hunter("Max");
        for (Hunter h : hunters) {

            if (h.gold > MAX.gold) {
                MAX.gold = h.gold;
                MAX.name = h.name;
            }
        }
        System.out.println("Nejvíc si vydělává " + MAX.name + " a to " + MAX.gold);
    }
}


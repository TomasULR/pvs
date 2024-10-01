package oop.basics.inheritance;

public class Neuro extends CardioSurgeon{

    int neuroBonus = 100000;

    public Neuro(String name, int salary) {
        super(name, salary);
        this.salary += neuroBonus;
    }



}

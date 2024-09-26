package oop.basics.inheritance;

public class Surgeon extends Doctor{
    int SURGEON_BONUS = 20000;

    public Surgeon(String name, int salary) {
        super(name, salary);
        this.salary += SURGEON_BONUS;
    }

    void surgery(){
        System.out.println("Cutting open...");
        salary += 5000;
    }



}

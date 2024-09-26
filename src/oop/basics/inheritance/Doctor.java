package oop.basics.inheritance;

public class Doctor {
    String name;
    int salary;

    public Doctor(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    void diagnose(){
        System.out.println("DIagnosing");
        salary += 1000;
    }
}

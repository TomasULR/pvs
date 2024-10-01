package oop.basics.inheritance;

import java.util.Arrays;

public class Hospital {
    public static void main(String[] args) {

        Doctor carl = new Doctor("Carl", 50000);
        System.out.println(carl.name + " vydělává " + carl.getSalary());
        carl.diagnose();
        carl.diagnose();
        System.out.println(carl.name + " vydělává " + carl.getSalary());

        Surgeon Joseph = new Surgeon("Joseph", 50000);
        Joseph.diagnose();
        Joseph.surgery();
        System.out.println(Joseph.name + " vydělává " + Joseph.getSalary());

        CardioSurgeon Franz = new CardioSurgeon("Franz", 50000);
        Franz.cardioSurgeon();
        Franz.diagnose();
        Franz.surgery();
        System.out.println(Franz.name + " vydělává " + Franz.getSalary());

        Neuro Sam = new Neuro("Sam", 50000);
        System.out.println(Sam.name + " vydělává " + Sam.getSalary());






        //Doctor carl = new Doctor("Carl", 50000);
        //System.out.println(carl.name + " vydělává " + carl.getSalary());
        //carl.diagnose();
        //carl.diagnose();
        //System.out.println(carl.name + " vydělává " + carl.getSalary());
//
        //Surgeon Joseph = new Surgeon("Joseph", 50000);
        //Joseph.diagnose();
        //Joseph.surgery();
        //System.out.println(Joseph.name + " vydělává " + Joseph.getSalary());
//
        //CardioSurgeon Franz = new CardioSurgeon("Franz", 50000);
        //Franz.cardioSurgeon();
        //Franz.diagnose();
        //Franz.surgery();
//
        //System.out.println(Franz.name + " vydělává " + Franz.getSalary());
//
//
        //Doctor Jarmil = new Surgeon("Jarmil", 50000);
        //System.out.println(Jarmil.getSalary() + " Jarmil sallary");
//
        //((Surgeon) Jarmil).surgery();
        //
//
        //Doctor[] doctors = {carl, Joseph, Franz, Jarmil};
        ////v3ichni zkusí operaci
//
        //for (Doctor doctor : doctors) {
        //    System.out.println(doctor.name + " surgery");
        //    if (doctor instanceof Surgeon){
        //        ((Surgeon) doctor).surgery();
//
        //    }
        //    else {
        //        System.out.println("Doctor " + doctor.name + " neumí to ");
        //    }
//
//
        //}





    }
}

package oop.basics.prep;

public class Soldier extends Hunter{

    public Soldier(String name){
        super(name);
        gold += 40; // uz neco ma nasetreno
    }

    public void killBandits(){
        System.out.println(name + " is going against bandits");
        gold += 100;
    }
}

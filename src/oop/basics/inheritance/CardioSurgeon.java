package oop.basics.inheritance;

public class CardioSurgeon extends Surgeon{
    int CARDIO_SURGEON_BONUS = 35000;


    public CardioSurgeon(String name, int salary) {
        super(name, salary);
        salary+= CARDIO_SURGEON_BONUS;
    }

    void cardioSurgery(){
        System.out.println("Cut heart");
        salary += 15000;
    }
}

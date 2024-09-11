package oop.basics;

public class ClassArray {
    public static void main(String[] args) {
        Cordinates c = new Cordinates(4.5, 5.8);


        Cordinates[] cords = new Cordinates[5];
        Cordinates[] cordsss = { new Cordinates(5.5,8.8),c};

        for (Cordinates cord : cordsss) {
            System.out.println(cordsss);
        }

    }
}
class Coordinates{
    double x,y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " "+ y;
    }
}

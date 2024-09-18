package oop.basics;

import java.awt.*;

public class basics {
    public static void main(String[] args) {
        Cordinates cordinates = new Cordinates(2,4);


    }
}

class Cordinates{
    double x,y;

    public Cordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle{
    double height, widht;
    final double DEFAULT_HEIGHT = 4;
    final double DEFAULT_WIDTH = 4;

    public Rectangle(double height, double widht) {
        this.height = height;
        this.widht = widht;
    }

    public Rectangle(Dimension d){

    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", widht=" + widht +
                ", DEFAULT_HEIGHT=" + DEFAULT_HEIGHT +
                ", DEFAULT_WIDTH=" + DEFAULT_WIDTH +
                '}';
    }
}

package oop.basics.inheritance;

public class Cuboid extends Rectanglee {

    double depth;

    public Cuboid(double width, double height, double depth) {
        super(width, height);
        this.depth = depth;
    }

    double getVolume() {
        return super.getArea() * depth;
    }
    public double getArea() {
        return 2 * (width * height) + (height * depth) + (depth * width);
    }

    public static void main(String[] args) {
        Rectanglee r = new Rectanglee(5, 6);
        System.out.println(r.getArea());

        Cuboid c = new Cuboid(5, 6, 3);
        Rectanglee wierd = new Cuboid(4,1,5);

    }


}

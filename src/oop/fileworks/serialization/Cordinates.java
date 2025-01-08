package oop.fileworks.serialization;

import java.io.Serial;
import java.io.Serializable;

public class Cordinates implements Serializable {
    private int x,y,z;
    @Serial
    private static final long SUID = 27L;

    public Cordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "[" + x + " " + y + " " + z + "]";
    }
}



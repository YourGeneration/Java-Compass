package com.epam.rd.autotasks;

import java.util.Optional;
import static java.lang.Math.abs;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        while(degrees >= 360) degrees = degrees - 360;
        while(degrees < 0) degrees = 360 + degrees;

        for( Direction dir : Direction.values()){
            if(dir.degrees == degrees) return dir;
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        while(degrees >= 360) degrees = degrees - 360;
        while(degrees < 0) degrees = 360 + degrees;

        for( Direction dir : Direction.values()){
            if(dir.degrees -23 <= degrees && dir.degrees +22 >= degrees) return dir;
        }
        return null;
    }

    public Direction opposite() {
        int newDegrees = degrees + 180;
        return ofDegrees(newDegrees);
    }

    public int differenceDegreesTo(Direction direction) {
        int newDegrees = abs(degrees - direction.degrees);
        while(newDegrees > 180) newDegrees = abs(360 - newDegrees);
        return newDegrees;
    }

}

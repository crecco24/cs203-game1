package game1;

import java.util.Random;
import javalib.worldimages.Posn;

public class Field {

    int leftBound;
    int rightBound;
    int upperBound;
    int lowerBound;

    public Field(int l, int r, int u, int lo) {
        this.leftBound = l;
        this.rightBound = r;
        this.upperBound = u;
        this.lowerBound = lo;
    }

//    public Ball makeRandBall() {
//        int type = randInt();
//        Posn postn = randomRemainingSpace();
//        return new Ball(postn, type, true);
//    }
//
//    public Posn randomRemainingSpace() {
//        int x = randDouble(this.leftBound, this.rightBound);
//        int y = randDouble(this.leftBound, this.upperBound);
//        return new Posn(x, y);
//    }


    public double randDouble(double min, double max) {
        Random r = new Random();
        double randomValue = min + (max - min) * r.nextDouble();
        return randomValue;
    }

}

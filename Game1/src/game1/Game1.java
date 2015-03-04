package game1;

import java.util.List;
import java.util.Random;
import javalib.worldimages.Posn;

public class Game1 {

    public static int randInt() {
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;

        return randomNum;
    }

    public static void main(String[] args) {

        Field field = new Field(0, 720, 720, 0);
        field.bigBang(field.rightBound, field.upperBound, 1);

        System.out.println(0 % 100);
        System.out.println(10 % 100);

    }

}

package game1;

import java.awt.Color;
import java.util.Random;
import javalib.funworld.World;
import javalib.worldimages.*;

public class Ball extends World implements Object {

    Posn position;
    int type;
    boolean inPlay;
    int radius = 20;
    public CircleImage circ;

    Ball(Posn position, int type, Boolean inPlay) {
        this.position = position;
        this.type = type;
        this.inPlay = inPlay;
        this.circ = new CircleImage(new Posn(400, 400), this.radius, randColor(randInt()));
    }

    public Posn getPosn() {
        return this.position;
    }

    public Boolean inPlay() {
        return this.inPlay;
    }

    public int ballType() {
        return this.type;
    }

    public Boolean equalType(Ball b) {
        return this.type == b.type;
    }

    public Boolean touching(Ball b) {
        if (this.position.x + radius >= b.position.x - radius
                && this.position.x + radius <= b.position.x + radius) {
            return (this.position.y + radius >= b.position.y - radius
                    && this.position.y + radius <= b.position.y + radius)
                    || (this.position.y - radius >= b.position.y - radius
                    && this.position.y - radius <= b.position.y + radius);
        } else if (this.position.x - radius >= b.position.x - radius
                && this.position.x - radius <= b.position.x + radius) {
            return (this.position.y + radius >= b.position.y - radius
                    && this.position.y + radius <= b.position.y + radius)
                    || (this.position.y - radius >= b.position.y - radius
                    && this.position.y - radius <= b.position.y + radius);
        } else {
            return false;
        }
    }

    //unfinished method, must think more thoroughly about how to move
    // ball over small iterations, checking to see if it comes in contact
    // with a wall or ball forcing a stop.
    public Ball move(Posn p) {
        return new Ball(p, this.type, true);
    }

    public java.awt.Color randColor(int i) {
        if (i == 1) {
            return java.awt.Color.BLUE;
        }
        if (i == 2) {
            return java.awt.Color.RED;
        }
        if (i == 3) {
            return java.awt.Color.GREEN;
        }
        return java.awt.Color.MAGENTA;
    }

    public static int randInt() {
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;

        return randomNum;
    }

    @Override
    public WorldImage makeImage() {
        return this.circ;
    }

}
